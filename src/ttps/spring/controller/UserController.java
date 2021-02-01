package ttps.spring.controller;


import java.util.Objects;
import java.util.Optional;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.dto.UsuarioDTO;
import ttps.spring.model.Usuario;
import ttps.spring.service.AuthenticationService;
import ttps.spring.service.UserService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(name = "/ttps-spring")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationService authenticateService;
	
	@GetMapping("/")
	public void llegamos() {
		
	}
	
	@PostMapping("/usuario")
	public ResponseEntity<UsuarioDTO> createUser(@RequestBody UsuarioDTO userDTO){
		Usuario usuario = null;
		try {
			 usuario = this.userService.createUser(userDTO);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(new UsuarioDTO(usuario),HttpStatus.CREATED);
	}
	
	@PostMapping("/autenticacion")
	public ResponseEntity<UsuarioDTO> authentication(@RequestHeader("usuario")String unUser,
			@RequestHeader("clave")String unaClave){
		
		if(this.userService.authenticate(unUser, unaClave)) {
			Usuario user = this.userService.getUserByUsername(unUser).orElseThrow();
			String token = user.getId().toString().concat("123456");
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
			headers.add("token", token);
			UsuarioDTO userResponse = new UsuarioDTO(user);
			
			return new ResponseEntity<>(userResponse,headers, HttpStatus.ACCEPTED);
			
		}
		return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
	}
	
	@GetMapping("/usuario/{userId}")
	public ResponseEntity<Usuario> getUser(@PathVariable  Long userId,
										   @RequestHeader("token")String token){
		
		if(!this.authenticateService.verification(token,userId)) {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}
		
		Optional<Usuario> userdb = this.userService.getUserById(userId);
		
		if(userdb.isPresent()) {
			return new ResponseEntity<>(userdb.get(),HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/usuario/{userId}")
	public ResponseEntity<Usuario> updateUser(@PathVariable Long userId,
									 @RequestBody Usuario userEdit,
									 @RequestHeader("token")String token){
		
		if(!this.authenticateService.verification(token, userId)) {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}
		
		Objects.requireNonNull(userEdit,"De suministrar un usuario valido");
		userEdit.setId(userId);
		try {
			this.userService.updateUser(userEdit);			
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(userEdit,HttpStatus.OK);
	}
}

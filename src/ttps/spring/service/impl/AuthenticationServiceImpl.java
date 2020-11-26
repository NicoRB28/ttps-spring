package ttps.spring.service.impl;

import java.util.Objects;

import org.springframework.stereotype.Service;

import ttps.spring.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Override
	public boolean verification(String token) {
		Objects.requireNonNull(token,"No se ha provisto un Token");
		if ((token.length() > 6) && (token.endsWith("123456"))){
			return true;
		}
		return false;
	}

}

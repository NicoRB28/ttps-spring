package ttps.spring.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T> {
	public T update(T entity);
	public void delete(T entity);
	public void delete(Serializable id);
	public T findById(Serializable id);
	public List<T> findAll();
	public T save(T entity);
}

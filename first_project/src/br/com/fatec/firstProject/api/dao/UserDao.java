package br.com.fatec.firstProject.api.dao;

import java.util.List;

import br.com.fatec.firstProject.api.entity.User;

public interface UserDao {
	
	Long save(User user);
	
	void update(User user);
	
	void delete(Long id);
	
	User findById(Long id);
	
	List<User> findAll();	
}

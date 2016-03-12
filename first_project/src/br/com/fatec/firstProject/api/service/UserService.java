package br.com.fatec.firstProject.api.service;

import java.util.List;

import br.com.fatec.firstProject.api.dto.UserDTO;

public interface UserService {
	
	UserDTO save(UserDTO user);
	
	UserDTO update(UserDTO user);
	
	void delete(Long userId);
	
	List<UserDTO> list();
	
	UserDTO searchById (Long userId);
}

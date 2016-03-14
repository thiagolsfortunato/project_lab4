package br.com.fatec.firstProject.core.converter;

import java.util.List;
import br.com.fatec.firstProject.api.dto.UserDTO;
import br.com.fatec.firstProject.api.entity.User;
import br.com.spektro.minispring.dto.DTOConverter;

public class UserDTOConverter implements DTOConverter<User, UserDTO>{

	@Override
	public UserDTO toDTO(User arg0) {
		return null;
	}

	@Override
	public List<UserDTO> toDTO(List<User> arg0) {
		return null;
	}

	@Override
	public User toEntity(UserDTO arg0) {
		return null;
	}

	@Override
	public List<User> toEntity(List<UserDTO> arg0) {
		return null;
	}
	
	
}

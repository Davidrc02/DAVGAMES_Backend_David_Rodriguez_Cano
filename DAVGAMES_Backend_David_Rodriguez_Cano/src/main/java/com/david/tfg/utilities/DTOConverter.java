package com.david.tfg.utilities;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.david.tfg.dto.RegistroDTO;
import com.david.tfg.dto.UsuarioDTOSalida;
import com.david.tfg.models.entity.Usuario;

@Component
public class DTOConverter {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public UsuarioDTOSalida convertirADTO(Usuario user) {
		UsuarioDTOSalida userDTO = modelMapper().map(user, UsuarioDTOSalida.class);
		return userDTO;
	}
	
	public Usuario convertirAEntidad(RegistroDTO userDTOEntrada) {
		Usuario user = modelMapper().map(userDTOEntrada, Usuario.class);
		return user;
	}
}

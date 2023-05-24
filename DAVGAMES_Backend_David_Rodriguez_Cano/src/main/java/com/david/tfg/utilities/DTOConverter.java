package com.david.tfg.utilities;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.david.tfg.dto.RegistroDTO;
import com.david.tfg.dto.UsuarioDTOSalida;
import com.david.tfg.dto.VideojuegoDTOEntrada;
import com.david.tfg.dto.VideojuegoDTOSalida;
import com.david.tfg.models.entity.Usuario;
import com.david.tfg.models.entity.Videojuego;

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
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		userDTOEntrada.setPassword(passwordEncoder.encode(userDTOEntrada.getPassword()));
		Usuario user = modelMapper().map(userDTOEntrada, Usuario.class);
		return user;
	}
	
	public VideojuegoDTOSalida convertirADTO(Videojuego videojuego) {
		VideojuegoDTOSalida videojuegoDTO = modelMapper().map(videojuego, VideojuegoDTOSalida.class);
		return videojuegoDTO;
	}
	
	public Videojuego convertirAEntidad(VideojuegoDTOEntrada videojuegoDTO) {
		Videojuego videojuego = modelMapper().map(videojuegoDTO, Videojuego.class);
		return videojuego;
	}
	
}

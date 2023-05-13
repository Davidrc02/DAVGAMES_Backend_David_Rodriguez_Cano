package com.david.tfg.models.service.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.tfg.dto.UsuarioDTOSalida;
import com.david.tfg.excepciones.ResourceNotFoundException;
import com.david.tfg.models.entity.Usuario;
import com.david.tfg.models.repositorios.UsuarioRepositorio;
import com.david.tfg.models.service.IUsuarioService;
import com.david.tfg.utilities.DTOConverter;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private DTOConverter dtoConverter;
	
	@Override
	public List<UsuarioDTOSalida> obtenerUsuarios() {
		return usuarioRepositorio.findAll().stream().map(usuario -> dtoConverter.convertirADTO(usuario)).collect(Collectors.toList());
	}

	@Override
	public UsuarioDTOSalida obtenerUsuario(long id) {
		Usuario usuario =usuarioRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario"));
		return dtoConverter.convertirADTO(usuario);
	}

}

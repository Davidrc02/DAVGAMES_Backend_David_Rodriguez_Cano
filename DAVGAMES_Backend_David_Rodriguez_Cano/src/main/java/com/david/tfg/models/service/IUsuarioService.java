package com.david.tfg.models.service;

import java.util.List;

import com.david.tfg.dto.UsuarioDTOSalida;

public interface IUsuarioService {
	
	public List<UsuarioDTOSalida> obtenerUsuarios();

	public UsuarioDTOSalida obtenerUsuario(long id);
}

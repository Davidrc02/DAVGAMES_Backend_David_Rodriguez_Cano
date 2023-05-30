package com.david.tfg.models.service;

import java.util.List;

import com.david.tfg.dto.RegistroDTO;
import com.david.tfg.dto.UsuarioDTOSalida;

public interface IUsuarioService {
	
	public List<UsuarioDTOSalida> obtenerUsuarios();

	public UsuarioDTOSalida obtenerUsuario(long id);

	public void crearUsuario(RegistroDTO registroDTO);

	public void actualizarUsuario(long id, RegistroDTO registroDTO);

	public void eliminarUsuario(long id);
}

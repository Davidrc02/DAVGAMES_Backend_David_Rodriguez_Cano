package com.david.tfg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.tfg.dto.UsuarioDTOSalida;
import com.david.tfg.models.service.IUsuarioService;

@RestController
@RequestMapping("/v0/davgames/api/admin")
public class ControladorAdministracion {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public ResponseEntity<List<UsuarioDTOSalida>> listadoUsuarios() {
		return new ResponseEntity<>(usuarioService.obtenerUsuarios(), HttpStatus.OK);
	}
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<UsuarioDTOSalida> obtenerUsuario(@PathVariable(value="id") long id) {
		return new ResponseEntity<>(usuarioService.obtenerUsuario(id), HttpStatus.OK);
	}
}

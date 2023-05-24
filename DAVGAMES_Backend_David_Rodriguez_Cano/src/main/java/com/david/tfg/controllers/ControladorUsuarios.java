package com.david.tfg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.tfg.dto.RegistroDTO;
import com.david.tfg.dto.UsuarioDTOSalida;
import com.david.tfg.models.service.IUsuarioService;
import com.david.tfg.utilities.ApiResponse;

@RestController
@RequestMapping("/v0/davgames/api/usuarios")
public class ControladorUsuarios {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTOSalida>> listadoUsuarios() {
		return new ResponseEntity<>(usuarioService.obtenerUsuarios(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTOSalida> obtenerUsuario(@PathVariable(value="id") long id) {
		return new ResponseEntity<>(usuarioService.obtenerUsuario(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ApiResponse> crearUsuario(@RequestBody RegistroDTO registroDTO) {
		usuarioService.crearUsuario(registroDTO);
		return new ResponseEntity<>(new ApiResponse("Usuario creado."), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse> actualizarUsuario(@PathVariable(value="id") long id, @RequestBody RegistroDTO registroDTO) {
		System.out.println("Entra");
		usuarioService.actualizarUsuario(id, registroDTO);
		return new ResponseEntity<>(new ApiResponse("Usuario creado."), HttpStatus.OK);
	}
}
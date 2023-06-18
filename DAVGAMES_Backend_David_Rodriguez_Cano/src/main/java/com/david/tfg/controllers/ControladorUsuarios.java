package com.david.tfg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.tfg.dto.RegistroDTO;
import com.david.tfg.dto.UsuarioDTOSalida;
import com.david.tfg.excepciones.ResourceNotFoundException;
import com.david.tfg.models.entity.Usuario;
import com.david.tfg.models.repositorios.UsuarioRepositorio;
import com.david.tfg.models.service.IUsuarioService;
import com.david.tfg.utilities.ApiResponse;

@RestController
@RequestMapping("/v0/davgames/api/usuarios")
public class ControladorUsuarios {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTOSalida>> listadoUsuarios() {
		return new ResponseEntity<>(usuarioService.obtenerUsuarios(), HttpStatus.OK);
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<UsuarioDTOSalida> obtenerUsuario(@PathVariable(value="username") String username) {
		return new ResponseEntity<>(usuarioService.obtenerUsuario(username), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ApiResponse> crearUsuario(@RequestBody RegistroDTO registroDTO) {
		usuarioService.crearUsuario(registroDTO);
		return new ResponseEntity<>(new ApiResponse("Usuario creado."), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse> actualizarUsuario(@PathVariable(value="id") long id, @RequestBody RegistroDTO registroDTO) {
		usuarioService.actualizarUsuario(id, registroDTO);
		return new ResponseEntity<>(new ApiResponse("Usuario modificado con éxito."), HttpStatus.OK);
	}
	
	@PutMapping("/cambiarContrasenna/{email}")
	public ResponseEntity<?> cambiarContrasenna(@PathVariable(value="email") String email, @RequestBody ApiResponse contrasenna) {
		System.out.println("Test 1 superado");
		System.out.println(email);
		System.out.println(contrasenna.getMensaje());
		if(usuarioRepositorio.existsByEmail(email)) {
			Usuario u =usuarioRepositorio.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Usuario"));
			u.setPassword(passwordEncoder.encode(contrasenna.getMensaje()));
			usuarioRepositorio.save(u);
			return new ResponseEntity<>(new ApiResponse("La contraseña ha sido actualizada"), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ApiResponse("El usuario introducido no existe"), HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> eliminarUsuario(@PathVariable(value="id") long id) {
		usuarioService.eliminarUsuario(id);
		return new ResponseEntity<>(new ApiResponse("Usuario eliminado."), HttpStatus.OK);
	}
}

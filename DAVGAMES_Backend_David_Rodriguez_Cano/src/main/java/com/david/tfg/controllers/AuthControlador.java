package com.david.tfg.controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.tfg.dto.LoginDTO;
import com.david.tfg.dto.RegistroDTO;
import com.david.tfg.models.entity.Rol;
import com.david.tfg.models.entity.Usuario;
import com.david.tfg.models.repositorios.RolRepositorio;
import com.david.tfg.models.repositorios.UsuarioRepositorio;
import com.david.tfg.seguridad.JWTAuthResponseDTO;
import com.david.tfg.seguridad.JwtTokenProvider;
import com.david.tfg.utilities.ApiResponse;

@RestController
@RequestMapping("/v0/davgames/auth")
public class AuthControlador {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private RolRepositorio rolRepositorio;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@PostMapping("/login")
	public ResponseEntity<JWTAuthResponseDTO> authenticateUser(@RequestBody LoginDTO loginDTO){
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token = jwtTokenProvider.generarToken(authentication);
		
		return ResponseEntity.ok(new JWTAuthResponseDTO(token));
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> registrarUsuario(@RequestBody RegistroDTO registroDTO){
		System.out.println("entra");
		if(usuarioRepositorio.existsByUsername(registroDTO.getUsername())) {
			return new ResponseEntity<>(new ApiResponse("Ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
		}
		
		if(usuarioRepositorio.existsByEmail(registroDTO.getEmail())) {
			return new ResponseEntity<>(new ApiResponse("Ese email de usuario ya existe"), HttpStatus.BAD_REQUEST);
		}
		
		Usuario usuario = new Usuario();
		usuario.setNombre(registroDTO.getNombre());
		usuario.setApellidos(registroDTO.getApellidos());
		usuario.setUsername(registroDTO.getUsername());
		usuario.setEmail(registroDTO.getEmail());
		usuario.setComunidadAutonoma(registroDTO.getComunidadAutonoma());
		usuario.setFechaNac(registroDTO.getFechaNac());
		usuario.setPassword(passwordEncoder.encode(registroDTO.getPassword()));
		usuario.setSaldo(1000000.0);
		
		Rol roles= rolRepositorio.findByNombre("ROLE_USER").get();
		usuario.setRoles(Collections.singleton(roles));
		
		usuarioRepositorio.save(usuario);
		return new ResponseEntity<>(new ApiResponse("Usuario registrado correctamente"), HttpStatus.OK);
	}
	
	@GetMapping("/verifyToken")
	public ResponseEntity<?> verifyToken(@RequestHeader("Authorization") String token) {
		if (token == null) {
			return new ResponseEntity<>("false", HttpStatus.BAD_REQUEST);
		}
		if (jwtTokenProvider.validarToken(token))
			return ResponseEntity.ok("true");
		else
			return new ResponseEntity<>("false", HttpStatus.BAD_REQUEST);

	}
}

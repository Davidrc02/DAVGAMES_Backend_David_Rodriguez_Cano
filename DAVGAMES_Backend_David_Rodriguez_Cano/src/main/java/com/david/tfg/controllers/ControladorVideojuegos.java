package com.david.tfg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.david.tfg.dto.VideojuegoDTO;
import com.david.tfg.models.entity.VideojuegoPK;
import com.david.tfg.models.service.IVideojuegoService;
import com.david.tfg.utilities.ApiResponse;

@RestController
@RequestMapping("/v0/davgames/api/videojuegos")
public class ControladorVideojuegos {
	
	@Autowired
	private IVideojuegoService videojuegoService;
	
	@GetMapping
	public ResponseEntity<List<VideojuegoDTO>> obtenerVideojuegos() {
		return new ResponseEntity<>(videojuegoService.obtenerVideojuegos(),HttpStatus.OK);
	}
	
	@GetMapping("/{nombreVideojuego}/{nombreConsola}")
	public ResponseEntity<VideojuegoDTO> obtenerUsuario(@PathVariable(value="nombreVideojuego") String nombreVideojuego, @PathVariable(value="nombreConsola") String nombreConsola) {
		return new ResponseEntity<>(videojuegoService.obtenerVideojuego(new VideojuegoPK(nombreVideojuego, nombreConsola)), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ApiResponse> crearVideojuego(@RequestBody VideojuegoDTO videojuegoDTO) {
		videojuegoService.insertarVideojuego(videojuegoDTO);
		return new ResponseEntity<>(new ApiResponse("Videojuego creado."), HttpStatus.OK);
	}
	
	@PutMapping("/{nombreVideojuego}/{nombreConsola}")
	public ResponseEntity<ApiResponse> actualizarUsuario(@PathVariable(value="nombreVideojuego") String nombreVideojuego, @PathVariable(value="nombreConsola") String nombreConsola, @RequestBody VideojuegoDTO videojuegoDTO) {
		videojuegoService.actualizarVideojuego(new VideojuegoPK(nombreVideojuego, nombreConsola), videojuegoDTO);
		return new ResponseEntity<>(new ApiResponse("Videojuego actualizado."), HttpStatus.OK);
	}
	
	@DeleteMapping("/{nombreVideojuego}/{nombreConsola}")
	public ResponseEntity<ApiResponse> eliminarVideojuego(@PathVariable(value="nombreVideojuego") String nombreVideojuego, @PathVariable(value="nombreConsola") String nombreConsola) {
		videojuegoService.eliminarVideojuego(new VideojuegoPK(nombreVideojuego, nombreConsola));
		return new ResponseEntity<>(new ApiResponse("Videojuego eliminado."), HttpStatus.OK);
	}
}

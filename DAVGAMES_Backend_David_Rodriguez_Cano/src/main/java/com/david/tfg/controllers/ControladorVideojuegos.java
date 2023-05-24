package com.david.tfg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.tfg.dto.VideojuegoDTOSalida;
import com.david.tfg.models.service.IVideojuegoService;

@RestController
@RequestMapping("/v0/davgames/api/videojuegos")
public class ControladorVideojuegos {
	
	@Autowired
	private IVideojuegoService videojuegoService;
	
	@GetMapping
	public ResponseEntity<List<VideojuegoDTOSalida>> obtenerVideojuegos() {
		return new ResponseEntity<>(videojuegoService.obtenerVideojuegos(),HttpStatus.OK);
	}
}

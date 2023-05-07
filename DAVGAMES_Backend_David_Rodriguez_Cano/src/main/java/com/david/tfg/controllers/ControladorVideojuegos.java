package com.david.tfg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.tfg.models.entity.Videojuego;
import com.david.tfg.models.service.IVideojuegoService;

@RestController
@RequestMapping("/v0/davgames/api/")
public class ControladorVideojuegos {
	
	@Autowired
	private IVideojuegoService videojuegoService;
	
	@GetMapping(value="/videojuegos")
	public List<Videojuego> videojuegos() {
		return videojuegoService.findAll();
	}
}

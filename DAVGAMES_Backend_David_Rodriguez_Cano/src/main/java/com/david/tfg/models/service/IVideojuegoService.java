package com.david.tfg.models.service;

import java.util.List;

import com.david.tfg.dto.VideojuegoDTOEntrada;
import com.david.tfg.dto.VideojuegoDTOSalida;

public interface IVideojuegoService {
	public List<VideojuegoDTOSalida> obtenerVideojuegos();
	
	public void insertarVideojuego(VideojuegoDTOEntrada videojuego);
	
	public VideojuegoDTOSalida buscarVideojuego(long id, String consola);
	
	public void borrarVideojuego(long id, String consola);
	
	
}

package com.david.tfg.models.service;

import java.util.List;

import com.david.tfg.dto.VideojuegoDTO;
import com.david.tfg.models.entity.VideojuegoPK;

public interface IVideojuegoService {
	public List<VideojuegoDTO> obtenerVideojuegos();
	
	public void insertarVideojuego(VideojuegoDTO videojuego);
	
	public VideojuegoDTO obtenerVideojuego(VideojuegoPK idVideojuego);
	
	public void eliminarVideojuego(VideojuegoPK idVideojuego);

	public void actualizarVideojuego(VideojuegoPK videojuegoPK, VideojuegoDTO videojuegoDTO);

	public List<String> obtenerConsolasPorNombreVideojuego(String nombreVideojuego);
	
	
}

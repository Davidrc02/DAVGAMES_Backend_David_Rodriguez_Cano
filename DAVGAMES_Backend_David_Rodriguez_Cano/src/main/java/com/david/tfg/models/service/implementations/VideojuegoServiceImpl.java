package com.david.tfg.models.service.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.tfg.dto.VideojuegoDTOEntrada;
import com.david.tfg.dto.VideojuegoDTOSalida;
import com.david.tfg.models.repositorios.VideojuegoRepostory;
import com.david.tfg.models.service.IVideojuegoService;
import com.david.tfg.utilities.DTOConverter;

@Service
public class VideojuegoServiceImpl implements IVideojuegoService{
	@Autowired
	private VideojuegoRepostory videojuegoRepository;
	
	@Autowired
	private DTOConverter dtoConverter;

	@Override
	public List<VideojuegoDTOSalida> obtenerVideojuegos() {
		return videojuegoRepository.findAll().stream().map(videojuego -> dtoConverter.convertirADTO(videojuego)).collect(Collectors.toList());
	}

	@Override
	public void insertarVideojuego(VideojuegoDTOEntrada videojuego) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public VideojuegoDTOSalida buscarVideojuego(long id, String consola) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrarVideojuego(long id, String consola) {
		// TODO Auto-generated method stub
		
	}
	
}

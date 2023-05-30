package com.david.tfg.models.service.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.tfg.dto.VideojuegoDTO;
import com.david.tfg.excepciones.ResourceNotFoundException;
import com.david.tfg.models.entity.Videojuego;
import com.david.tfg.models.entity.VideojuegoPK;
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
	public List<VideojuegoDTO> obtenerVideojuegos() {
		return videojuegoRepository.findAll().stream().map(videojuego -> dtoConverter.convertirADTO(videojuego)).collect(Collectors.toList());
	}
	
	@Override
	public VideojuegoDTO obtenerVideojuego(VideojuegoPK idVideojuego) {
		Videojuego v = videojuegoRepository.findById(idVideojuego).orElseThrow(() -> new ResourceNotFoundException("Videojuego"));
		return dtoConverter.convertirADTO(v);
	}

	@Override
	public void insertarVideojuego(VideojuegoDTO videojuego) {
		Videojuego v = dtoConverter.convertirAEntidad(videojuego);
		videojuegoRepository.save(v);
	}

	@Override
	public void eliminarVideojuego(VideojuegoPK idVideojuego) {
		videojuegoRepository.deleteById(idVideojuego);
	}

	@Override
	public void actualizarVideojuego(VideojuegoPK videojuegoPK, VideojuegoDTO videojuegoDTO) {
		videojuegoDTO.setNombreVideojuego(videojuegoPK.getNombreVideojuego());
		videojuegoDTO.setNombreConsola(videojuegoPK.getNombreConsola());
		Videojuego v = dtoConverter.convertirAEntidad(videojuegoDTO);
		videojuegoRepository.save(v);
	}
	
}

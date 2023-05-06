package com.david.tfg.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.david.tfg.excepciones.ResourceNotFoundException;
import com.david.tfg.models.entity.Videojuego;
import com.david.tfg.models.entity.VideojuegoPK;
import com.david.tfg.models.repositorios.VideojuegoRepostory;

@Service
public class VideojuegoServiceImpl implements IVideojuegoService{
	@Autowired
	private VideojuegoRepostory videojuegoRepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Videojuego> findAll(){
		return (List<Videojuego>) videojuegoRepository.findAll();
	}

	@Override
	@Transactional
	public void create(Videojuego v) {
		videojuegoRepository.save(v);
	}

	@Override
	@Transactional(readOnly=true)
	public Videojuego findOne(long id, String consola) {
		VideojuegoPK videojuegoPK = new VideojuegoPK(id, consola);
		return videojuegoRepository.findById(videojuegoPK).orElseThrow(() -> new ResourceNotFoundException("Videojuego"));
	}

	@Override
	@Transactional
	public void delete(long id, String consola) {
		VideojuegoPK videojuegoPK = new VideojuegoPK(id, consola);
		videojuegoRepository.delete(videojuegoRepository.findById(videojuegoPK).orElseThrow(() -> new ResourceNotFoundException("Videojuego")));
		
	}
	
}

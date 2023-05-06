package com.david.tfg.models.service;

import java.util.List;

import com.david.tfg.models.entity.Videojuego;

public interface IVideojuegoService {
	public List<Videojuego> findAll();
	
	public void create(Videojuego v);
	
	public Videojuego findOne(long id, String consola);
	
	public void delete(long id, String consola);
	
}

package com.ejemplos.models.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplos.models.entity.Videojuego;
import com.ejemplos.models.entity.VideojuegoPK;

public interface VideojuegoRepostory extends JpaRepository<Videojuego, VideojuegoPK>{
	
}

package com.david.tfg.models.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.david.tfg.models.entity.Videojuego;
import com.david.tfg.models.entity.VideojuegoPK;

public interface VideojuegoRepostory extends JpaRepository<Videojuego, VideojuegoPK>{
	
}

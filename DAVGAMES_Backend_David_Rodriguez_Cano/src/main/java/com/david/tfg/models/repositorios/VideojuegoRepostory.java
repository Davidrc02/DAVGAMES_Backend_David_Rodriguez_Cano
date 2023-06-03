package com.david.tfg.models.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.david.tfg.models.entity.Videojuego;
import com.david.tfg.models.entity.VideojuegoPK;

public interface VideojuegoRepostory extends JpaRepository<Videojuego, VideojuegoPK>{
	
	@Query("SELECT v.videojuegoPK.nombreConsola FROM Videojuego v WHERE v.videojuegoPK.nombreVideojuego = :nombreVideojuego")
	public List<String> obtenerConsolasPorNombreVideojuego(@Param("nombreVideojuego") String nombreVideojuego);
}

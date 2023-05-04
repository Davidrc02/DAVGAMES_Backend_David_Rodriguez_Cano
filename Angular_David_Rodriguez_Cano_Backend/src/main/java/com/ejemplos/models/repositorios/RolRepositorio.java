package com.ejemplos.models.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplos.models.entity.Rol;

public interface RolRepositorio extends JpaRepository<Rol, Long> {
	
	public Optional<Rol> findByNombre(String nombre);

}

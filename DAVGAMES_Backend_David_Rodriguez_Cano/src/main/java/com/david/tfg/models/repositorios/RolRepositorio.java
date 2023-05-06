package com.david.tfg.models.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.david.tfg.models.entity.Rol;

public interface RolRepositorio extends JpaRepository<Rol, Long> {
	
	public Optional<Rol> findByNombre(String nombre);

}

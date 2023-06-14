package com.david.tfg.models.repositorios;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.david.tfg.models.entity.Factura;
import com.david.tfg.models.entity.Usuario;

public interface FacturaRepositorio extends JpaRepository<Factura, Long>{
	
	public Optional<Factura> findByFechaHora(Date fechaHora);
}

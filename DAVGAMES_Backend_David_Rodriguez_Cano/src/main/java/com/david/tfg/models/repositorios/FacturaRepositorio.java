package com.david.tfg.models.repositorios;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.david.tfg.models.entity.Factura;
import com.david.tfg.models.entity.Usuario;

public interface FacturaRepositorio extends JpaRepository<Factura, Long>{
	
	@Query("SELECT f FROM Factura f WHERE f.usuario = :usuario")
	public List<Factura> obtenerFacturasPorUsuario(@Param("usuario") Usuario usuario);
	
	public Optional<Factura> findByFechaHora(Date fechaHora);
}

package com.david.tfg.models.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.david.tfg.models.entity.Factura;
import com.david.tfg.models.entity.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long>{

	@Query("SELECT p FROM Pedido p WHERE p.factura= :factura")
	public List<Pedido> obtenerPedidosPorFactura(@Param("factura") Factura factura);
}

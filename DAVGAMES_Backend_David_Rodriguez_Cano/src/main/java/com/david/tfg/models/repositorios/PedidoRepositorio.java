package com.david.tfg.models.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.david.tfg.models.entity.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long>{

}

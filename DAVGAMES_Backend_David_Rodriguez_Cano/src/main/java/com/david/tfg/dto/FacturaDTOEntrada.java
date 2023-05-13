package com.david.tfg.dto;

import java.util.Date;
import java.util.List;

public class FacturaDTOEntrada {
	
	private Date fechaHora;
	
    private UsuarioDTOSalida usuario;
    
    private List<PedidoDTOSalida> pedidos;

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public UsuarioDTOSalida getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTOSalida usuario) {
		this.usuario = usuario;
	}

	public List<PedidoDTOSalida> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoDTOSalida> pedidos) {
		this.pedidos = pedidos;
	}

	public FacturaDTOEntrada(Date fechaHora, UsuarioDTOSalida usuario, List<PedidoDTOSalida> pedidos) {
		this.fechaHora = fechaHora;
		this.usuario = usuario;
		this.pedidos = pedidos;
	}

	public FacturaDTOEntrada() {
	}
    
}

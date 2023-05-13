package com.david.tfg.dto;

import java.util.Date;
import java.util.List;

public class FacturaDTOSalida {
private Date fechaHora;
	
	private long id;
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

	public FacturaDTOSalida(long id, Date fechaHora, UsuarioDTOSalida usuario, List<PedidoDTOSalida> pedidos) {
		this.id=id;
		this.fechaHora = fechaHora;
		this.usuario = usuario;
		this.pedidos = pedidos;
	}

	public FacturaDTOSalida() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}

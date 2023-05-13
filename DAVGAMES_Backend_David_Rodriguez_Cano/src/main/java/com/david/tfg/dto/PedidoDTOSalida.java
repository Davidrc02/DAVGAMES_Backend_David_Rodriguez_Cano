package com.david.tfg.dto;

public class PedidoDTOSalida {
	private long id;
	private int cantidad;
	private VideojuegoDTOSalida videojuego;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public VideojuegoDTOSalida getVideojuego() {
		return videojuego;
	}
	public void setVideojuego(VideojuegoDTOSalida videojuego) {
		this.videojuego = videojuego;
	}
	
	public PedidoDTOSalida(long id, int cantidad, VideojuegoDTOSalida videojuego) {
		this.id = id;
		this.cantidad = cantidad;
		this.videojuego = videojuego;
	}
	
	public PedidoDTOSalida() {
	}
	
	
}

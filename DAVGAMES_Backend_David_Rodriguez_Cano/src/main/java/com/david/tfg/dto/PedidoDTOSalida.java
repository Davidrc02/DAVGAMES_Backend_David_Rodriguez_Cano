package com.david.tfg.dto;

public class PedidoDTOSalida {
	private long id;
	private int cantidad;
	private VideojuegoDTO videojuego;
	
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
	public VideojuegoDTO getVideojuego() {
		return videojuego;
	}
	public void setVideojuego(VideojuegoDTO videojuego) {
		this.videojuego = videojuego;
	}
	
	public PedidoDTOSalida(long id, int cantidad, VideojuegoDTO videojuego) {
		this.id = id;
		this.cantidad = cantidad;
		this.videojuego = videojuego;
	}
	
	public PedidoDTOSalida() {
	}
	
	
}

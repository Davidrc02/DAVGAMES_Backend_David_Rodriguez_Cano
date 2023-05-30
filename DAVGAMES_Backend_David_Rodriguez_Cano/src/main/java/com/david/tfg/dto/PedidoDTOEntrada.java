package com.david.tfg.dto;

public class PedidoDTOEntrada {

	private int cantidad;
	private VideojuegoDTO videojuego;
	
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
	
	public PedidoDTOEntrada(int cantidad, VideojuegoDTO videojuego) {
		this.cantidad = cantidad;
		this.videojuego = videojuego;
	}
	
	public PedidoDTOEntrada() {
	}
}

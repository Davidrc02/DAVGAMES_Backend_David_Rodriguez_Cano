package com.david.tfg.dto;

public class PedidoDTOEntrada {

	private int cantidad;
	private VideojuegoDTOSalida videojuego;
	
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
	
	public PedidoDTOEntrada(int cantidad, VideojuegoDTOSalida videojuego) {
		this.cantidad = cantidad;
		this.videojuego = videojuego;
	}
	
	public PedidoDTOEntrada() {
	}
}

package com.david.tfg.dto;

public class PedidoDTOSalida {
	private long id;
	private int cantidad;
	private FacturaDTO factura;
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
	
	public FacturaDTO getFactura() {
		return factura;
	}
	public void setFactura(FacturaDTO factura) {
		this.factura = factura;
	}
	public PedidoDTOSalida(long id, int cantidad, FacturaDTO factura, VideojuegoDTO videojuego) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.factura = factura;
		this.videojuego = videojuego;
	}
	public PedidoDTOSalida() {
	}
	@Override
	public String toString() {
		return "PedidoDTOSalida [id=" + id + ", cantidad=" + cantidad + ", factura=" + factura + ", videojuego="
				+ videojuego + "]";
	}
	
	
}

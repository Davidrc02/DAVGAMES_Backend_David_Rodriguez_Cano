package com.david.tfg.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "cantidad")
	private int cantidad;

	@ManyToOne
	@JoinColumns({ 
		@JoinColumn(name = "nombre_videojuego"),
		@JoinColumn(name = "nombre_consola")
	})
	private Videojuego videojuego;

	@ManyToOne
	@JoinColumn(name = "factura_id")
	private Factura factura;
	
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

	public Videojuego getVideojuego() {
		return videojuego;
	}

	public void setVideojuego(Videojuego videojuego) {
		this.videojuego = videojuego;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Pedido(long id, int cantidad, Videojuego videojuego, Factura factura) {
		this.id = id;
		this.cantidad = cantidad;
		this.videojuego = videojuego;
		this.factura = factura;
	}

	public Pedido() {
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cantidad=" + cantidad + ", videojuego=" + videojuego + ", factura=" + factura
				+ "]";
	}

	
	
}

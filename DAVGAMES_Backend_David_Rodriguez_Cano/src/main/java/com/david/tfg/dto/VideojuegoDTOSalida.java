package com.david.tfg.dto;

import java.util.Date;
import java.util.Set;

import com.david.tfg.models.entity.Pedido;

public class VideojuegoDTOSalida {
	private long idVideojuego;
	
	private String nombreConsola;

	private int clasificacionEdad;

	private String empresa;

	private Date fechaLanzamiento;

	private String franquicia;

	private String nombre;

	private int numJugadores;
	
	private int stock;

	private String genero;

	private String url;

	private Double precio;

	private Set<Pedido> pedidos;

	@Override
	public String toString() {
		return "VideojuegoDTOSalida [idVideojuego=" + idVideojuego + ", nombreConsola=" + nombreConsola
				+ ", clasificacionEdad=" + clasificacionEdad + ", empresa=" + empresa + ", fechaLanzamiento="
				+ fechaLanzamiento + ", franquicia=" + franquicia + ", nombre=" + nombre + ", numJugadores="
				+ numJugadores + ", stock=" + stock + ", genero=" + genero + ", url=" + url + ", precio=" + precio
				+ ", pedidos=" + pedidos + "]";
	}

	public VideojuegoDTOSalida(long idVideojuego, String nombreConsola, int clasificacionEdad, String empresa,
			Date fechaLanzamiento, String franquicia, String nombre, int numJugadores, int stock, String genero,
			String url, Double precio, Set<Pedido> pedidos) {
		this.idVideojuego = idVideojuego;
		this.nombreConsola = nombreConsola;
		this.clasificacionEdad = clasificacionEdad;
		this.empresa = empresa;
		this.fechaLanzamiento = fechaLanzamiento;
		this.franquicia = franquicia;
		this.nombre = nombre;
		this.numJugadores = numJugadores;
		this.stock = stock;
		this.genero = genero;
		this.url = url;
		this.precio = precio;
		this.pedidos = pedidos;
	}

	public VideojuegoDTOSalida() {
	}

	public long getIdVideojuego() {
		return idVideojuego;
	}

	public void setIdVideojuego(long idVideojuego) {
		this.idVideojuego = idVideojuego;
	}

	public String getNombreConsola() {
		return nombreConsola;
	}

	public void setNombreConsola(String nombreConsola) {
		this.nombreConsola = nombreConsola;
	}

	public int getClasificacionEdad() {
		return clasificacionEdad;
	}

	public void setClasificacionEdad(int clasificacionEdad) {
		this.clasificacionEdad = clasificacionEdad;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public String getFranquicia() {
		return franquicia;
	}

	public void setFranquicia(String franquicia) {
		this.franquicia = franquicia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumJugadores() {
		return numJugadores;
	}

	public void setNumJugadores(int numJugadores) {
		this.numJugadores = numJugadores;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	
}
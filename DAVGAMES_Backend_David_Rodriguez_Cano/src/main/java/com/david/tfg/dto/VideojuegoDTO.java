package com.david.tfg.dto;

import java.util.Date;
import java.util.Set;

import com.david.tfg.models.entity.Pedido;

public class VideojuegoDTO{
	private String nombreVideojuego;
	private String nombreConsola;
	private int clasificacionEdad;
	private String empresa;
	private Date fechaLanzamiento;
	private String franquicia;
	private int numJugadores;
	private int stock;
	private String genero;
	private String url;
	private Double precio;

	@Override
	public String toString() {
		return "VideojuegoDTOSalida [nombreVideojuego=" + nombreVideojuego + ", nombreConsola=" + nombreConsola
				+ ", clasificacionEdad=" + clasificacionEdad + ", empresa=" + empresa + ", fechaLanzamiento="
				+ fechaLanzamiento + ", franquicia=" + franquicia + ", numJugadores="
				+ numJugadores + ", stock=" + stock + ", genero=" + genero + ", url=" + url + ", precio=" + precio
				+ "]";
	}

	public VideojuegoDTO(String nombreVideojuego, String nombreConsola, int clasificacionEdad, String empresa,
			Date fechaLanzamiento, String franquicia, int numJugadores, int stock, String genero,
			String url, Double precio) {
		this.nombreVideojuego = nombreVideojuego;
		this.nombreConsola = nombreConsola;
		this.clasificacionEdad = clasificacionEdad;
		this.empresa = empresa;
		this.fechaLanzamiento = fechaLanzamiento;
		this.franquicia = franquicia;
		this.numJugadores = numJugadores;
		this.stock = stock;
		this.genero = genero;
		this.url = url;
		this.precio = precio;
	}

	public VideojuegoDTO() {
	}

	public String getNombreVideojuego() {
		return nombreVideojuego;
	}

	public void setNombreVideojuego(String nombreVideojuego) {
		this.nombreVideojuego = nombreVideojuego;
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
	
}

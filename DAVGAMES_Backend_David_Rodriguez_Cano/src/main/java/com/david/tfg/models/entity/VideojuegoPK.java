package com.david.tfg.models.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class VideojuegoPK implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name = "nombre_videojuego")
	private String nombreVideojuego;
	
	@Column(name="nombre_consola")
	private String nombreConsola;

	public String getNombreConsola() {
		return nombreConsola;
	}

	public void setNombreConsola(String nombreConsola) {
		this.nombreConsola = nombreConsola;
	}

	public String getNombreVideojuego() {
		return nombreVideojuego;
	}

	public void setNombreVideojuego(String nombreVideojuego) {
		this.nombreVideojuego = nombreVideojuego;
	}

	public VideojuegoPK(String nombreVideojuego, String nombreConsola) {
		this.nombreConsola = nombreConsola;
		this.nombreVideojuego=nombreVideojuego;
	}

	public VideojuegoPK() {
	}

	@Override
	public String toString() {
		return "VideojuegoPK [nombreVideojuego=" + nombreVideojuego + ", nombreConsola=" + nombreConsola + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombreVideojuego, nombreConsola);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VideojuegoPK other = (VideojuegoPK) obj;
		return Objects.equals(nombreVideojuego, other.nombreVideojuego) && Objects.equals(nombreConsola, other.nombreConsola);
	}

	
	
}

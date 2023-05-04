package com.ejemplos.models.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class VideojuegoPK implements Serializable{
	
	@Column(name = "id_videojuego")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idVideojuego;
	
	@Column(name="nombre_consola")
	private String nombreConsola;

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

	public VideojuegoPK(long idVideojuego, String nombreConsola) {
		this.idVideojuego = idVideojuego;
		this.nombreConsola = nombreConsola;
	}

	public VideojuegoPK() {
	}

	@Override
	public int hashCode() {
		return Objects.hash(idVideojuego, nombreConsola);
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
		return idVideojuego == other.idVideojuego && Objects.equals(nombreConsola, other.nombreConsola);
	}
	
}

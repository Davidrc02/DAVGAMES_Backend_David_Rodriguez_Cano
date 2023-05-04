package com.ejemplos.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the videojuegos database table.
 * 
 */
@Entity
@Table(name = "videojuegos")
@NamedQuery(name = "Videojuego.findAll", query = "SELECT v FROM Videojuego v")
public class Videojuego implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VideojuegoPK videojuegoPK;

	@Column(name = "clasificacion_edad")
	private int clasificacionEdad;

	@Column(name = "empresa")
	private String empresa;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_lanzamiento")
	private Date fechaLanzamiento;

	@Column(name = "franquicia")
	private String franquicia;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "num_jugadores")
	private int numJugadores;
	
	@Column(name = "stock")
	private int stock;

	@Column(name = "genero")
	private String genero;

	@Column(name = "nombre_url")
	private String url;
	
	@Column(name = "precio")
	private Double precio;

	@OneToMany(mappedBy="videojuego", cascade= CascadeType.ALL)
	private Set<Pedido> pedidos;
	
	public Videojuego() {
	}

	public VideojuegoPK getVideojuegoPK() {
		return videojuegoPK;
	}

	public void setVideojuegoPK(VideojuegoPK videojuegoPK) {
		this.videojuegoPK = videojuegoPK;
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

	public Videojuego(VideojuegoPK videojuegoPK, int clasificacionEdad, String empresa, Date fechaLanzamiento,
			String franquicia, String nombre, int numJugadores, int stock, String genero, String url,
			Double precio) {
		this.videojuegoPK = videojuegoPK;
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
	}	
}

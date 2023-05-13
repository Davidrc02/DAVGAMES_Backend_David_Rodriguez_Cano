package com.david.tfg.dto;

import java.util.Date;
import java.util.List;

public class UsuarioDTOSalida {

	private long id;
	private String nombre;
	private String apellidos;
	private String email;
	private String username;
	private String comunidadAutonoma;
	private Date fechaNac;
	private List<FacturaDTOSalida> facturas;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getComunidadAutonoma() {
		return comunidadAutonoma;
	}

	public void setComunidadAutonoma(String comunidadAutonoma) {
		this.comunidadAutonoma = comunidadAutonoma;
	}

	public List<FacturaDTOSalida> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<FacturaDTOSalida> facturas) {
		this.facturas = facturas;
	}

	public UsuarioDTOSalida(String nombre, String apellidos, String email, String username, 
			String comunidadAutonoma, Date fechaNac, List<FacturaDTOSalida> facturas) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.username = username;
		this.fechaNac=fechaNac;
		this.comunidadAutonoma = comunidadAutonoma;
		this.facturas = facturas;
	}

	public UsuarioDTOSalida() {
	}

	public Date getFechaNac() {
		return this.fechaNac;
	}
	
	public void setFechaNac(Date fechaNac) {
		this.fechaNac=fechaNac;
	}

	
}
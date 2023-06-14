package com.david.tfg.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegistroDTO {

	private String nombre;
	private String apellidos;
	private String email;
	private String username;
	private String password;
	private String comunidadAutonoma;
	private Date fechaNac;
	private List<FacturaDTOSalida> facturas;
	private Double saldo;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public RegistroDTO(String nombre, String apellidos, String email, String username, String password,
			String comunidadAutonoma, Date fechaNac, List<FacturaDTOSalida> facturas, Double saldo) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.username = username;
		this.password = password;
		this.fechaNac=fechaNac;
		this.comunidadAutonoma = comunidadAutonoma;
		this.facturas=facturas;
		this.saldo=saldo;
	}

	public RegistroDTO() {
	}

	public Date getFechaNac() {
		return this.fechaNac;
	}
	
	public void setFechaNac(Date fechaNac) {
		this.fechaNac=fechaNac;
	}

	public List<FacturaDTOSalida> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<FacturaDTOSalida> facturas) {
		this.facturas = facturas;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	
	
}

package com.david.tfg.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="usuarios", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }),
		@UniqueConstraint(columnNames = { "email" }) })
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellidos")
	private String apellidos;
	
	@Column(name="username")
	private String username;
	
	@Column(name="email", unique = true, nullable=false)
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="fecha_nac")
	@Temporal(TemporalType.DATE)
	private Date fechaNac;
	
	@Column(name="comunidad_autonoma")
	private String comunidadAutonoma;
	
	@Column(name="saldo")
	private Double saldo;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuarios_roles",
	joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id"))
	private Set<Rol> roles = new HashSet<>();
	
	@OneToMany(mappedBy = "usuario")
	private List<Factura> facturas = new ArrayList<>();

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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getComunidadAutonoma() {
		return comunidadAutonoma;
	}

	public void setComunidadAutonoma(String comunidadAutonoma) {
		this.comunidadAutonoma = comunidadAutonoma;
	}
	
	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Usuario(long id, String nombre, String apellidos, String username, String email, String password,
			Set<Rol> roles, List<Factura> facturas, String comunidadAutonoma, Date fechaNac, Double saldo) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.facturas = facturas;
		this.comunidadAutonoma = comunidadAutonoma;
		this.fechaNac=fechaNac;
		this.saldo=saldo;
	}

	public Usuario() {
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", username=" + username
				+ ", email=" + email + ", password=" + password + ", fechaNac=" + fechaNac + ", comunidadAutonoma="
				+ comunidadAutonoma + ", saldo=" + saldo + "]";
	}
	
}

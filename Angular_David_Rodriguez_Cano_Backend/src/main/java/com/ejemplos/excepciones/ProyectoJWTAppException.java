package com.ejemplos.excepciones;

import org.springframework.http.HttpStatus;

public class ProyectoJWTAppException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private HttpStatus estado;
	private String mensaje;
	
	public ProyectoJWTAppException(HttpStatus estado, String mensaje) {
		super();
		this.estado = estado;
		this.mensaje = mensaje;
	}
	
	public ProyectoJWTAppException(HttpStatus estado, String mensaje, String mensaje1) {
		super();
		this.estado = estado;
		this.mensaje = mensaje;
		this.mensaje = mensaje1;
	}
	
	

}

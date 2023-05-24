package com.david.tfg.utilities;

public class ApiResponse {
	private String mensaje;

	public ApiResponse(String mensaje) {
		this.setMensaje(mensaje);
	}
	
	public ApiResponse() {}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}

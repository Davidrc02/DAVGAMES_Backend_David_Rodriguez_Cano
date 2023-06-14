package com.david.tfg.dto;

import java.util.Date;
import java.util.List;

public class FacturaDTO {
	
	private Date fechaHora;
	private long id;

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public FacturaDTO(long id, Date fechaHora) {
		this.id=id;
		this.fechaHora = fechaHora;
	}

	public FacturaDTO() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "FacturaDTO [fechaHora=" + fechaHora + ", id=" + id + "]";
	}
	
	
}

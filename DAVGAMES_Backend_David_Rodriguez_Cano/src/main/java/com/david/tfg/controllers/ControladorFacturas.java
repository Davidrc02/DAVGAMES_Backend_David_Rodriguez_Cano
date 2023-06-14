package com.david.tfg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.tfg.dto.FacturaDTOEntrada;
import com.david.tfg.models.repositorios.UsuarioRepositorio;
import com.david.tfg.models.service.IFacturaService;
import com.david.tfg.utilities.ApiResponse;

@RestController
@RequestMapping("/v0/davgames/api/")
public class ControladorFacturas {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private IFacturaService facturaService;
	
	
	@PutMapping("realizarFactura")
	public ResponseEntity<ApiResponse> realizarFactura(@RequestBody FacturaDTOEntrada facturaDTO) {
		if(usuarioRepositorio.existsByUsername(facturaDTO.getUsuario().getUsername()) && facturaDTO.getPedidos().size()!=0) {
			facturaService.realizarFactura(facturaDTO);
			return new ResponseEntity<>(new ApiResponse("Factura realizada con éxito"), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ApiResponse("Factura errónea"), HttpStatus.OK);
	}
}

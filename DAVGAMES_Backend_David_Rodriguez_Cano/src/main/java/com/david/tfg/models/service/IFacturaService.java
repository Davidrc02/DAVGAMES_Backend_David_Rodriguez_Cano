package com.david.tfg.models.service;

import java.util.List;

import com.david.tfg.dto.FacturaDTO;
import com.david.tfg.dto.FacturaDTOEntrada;
import com.david.tfg.dto.PedidoDTOSalida;
import com.david.tfg.models.entity.Usuario;

public interface IFacturaService {
	
	public List<PedidoDTOSalida> obtenerPedidosPorIdFactura(long id);
	
	public List<FacturaDTO> obtenerFacturasPorUsuario(Usuario usuario);

	public void realizarFactura(FacturaDTOEntrada facturaDTO);
}

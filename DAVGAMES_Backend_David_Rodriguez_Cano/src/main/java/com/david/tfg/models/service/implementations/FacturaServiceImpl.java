package com.david.tfg.models.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.tfg.dto.FacturaDTOEntrada;
import com.david.tfg.dto.PedidoDTOSalida;
import com.david.tfg.excepciones.ResourceNotFoundException;
import com.david.tfg.models.entity.Factura;
import com.david.tfg.models.entity.Usuario;
import com.david.tfg.models.entity.Videojuego;
import com.david.tfg.models.entity.VideojuegoPK;
import com.david.tfg.models.repositorios.FacturaRepositorio;
import com.david.tfg.models.repositorios.PedidoRepositorio;
import com.david.tfg.models.repositorios.UsuarioRepositorio;
import com.david.tfg.models.repositorios.VideojuegoRepositorio;
import com.david.tfg.models.service.IFacturaService;
import com.david.tfg.utilities.DTOConverter;

@Service
public class FacturaServiceImpl implements IFacturaService{

	@Autowired
	private VideojuegoRepositorio videojuegoRepositorio;
	
	@Autowired
	private FacturaRepositorio facturaRepositorio;
	
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private DTOConverter dtoConverter;
	
	@Override
	public void realizarFactura(FacturaDTOEntrada facturaDTO) {
		if(usuarioRepositorio.existsByUsername(facturaDTO.getUsuario().getUsername()) && facturaDTO.getPedidos().size()!=0) {
			actualizarSaldoUsuario(facturaDTO);
			Factura factura = dtoConverter.convertirAEntidad(facturaDTO);
			facturaRepositorio.save(factura);
			Factura aux = facturaRepositorio.findByFechaHora(factura.getFechaHora()).orElseThrow(() -> new ResourceNotFoundException("Factura"));
			facturaDTO.getPedidos().forEach(pedido -> pedido.setFactura(dtoConverter.convertirADTOPredeterminada(aux)));
			facturaDTO.getPedidos().forEach(pedido -> pedidoRepositorio.save(dtoConverter.convertirAEntidad(pedido)));
			facturaDTO.getPedidos().forEach(pedido -> actualizarStockVideojuego(pedido));
		}
	}
	
	public void actualizarStockVideojuego(PedidoDTOSalida pedido) {
		Videojuego v = videojuegoRepositorio.findById(new VideojuegoPK(pedido.getVideojuego().getNombreVideojuego(), pedido.getVideojuego().getNombreConsola())).orElseThrow(() -> new ResourceNotFoundException("Videojuego"));
		v.setStock(v.getStock()-pedido.getCantidad());
		videojuegoRepositorio.save(v);
	}
	
	public void actualizarSaldoUsuario(FacturaDTOEntrada facturaDTO) {
		double totalFactura;
		totalFactura = sacarTotal(facturaDTO.getPedidos());
		Usuario u = usuarioRepositorio.findById(facturaDTO.getUsuario().getId()).orElseThrow(() -> new ResourceNotFoundException("Usuario"));
		u.setSaldo(u.getSaldo()-totalFactura);
		usuarioRepositorio.save(u);
	}
	
	public Double sacarTotal(List<PedidoDTOSalida> pedidos) {
		return pedidos.stream()
	            .mapToDouble(pedido -> pedido.getCantidad() * pedido.getVideojuego().getPrecio()*10)
	            .sum();
	}

}

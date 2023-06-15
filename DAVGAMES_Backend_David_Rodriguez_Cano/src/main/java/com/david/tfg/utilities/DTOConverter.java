package com.david.tfg.utilities;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.david.tfg.dto.FacturaDTO;
import com.david.tfg.dto.FacturaDTOEntrada;
import com.david.tfg.dto.FacturaDTOSalida;
import com.david.tfg.dto.PedidoDTOSalida;
import com.david.tfg.dto.RegistroDTO;
import com.david.tfg.dto.UsuarioDTOSalida;
import com.david.tfg.dto.VideojuegoDTO;
import com.david.tfg.models.entity.Factura;
import com.david.tfg.models.entity.Pedido;
import com.david.tfg.models.entity.Usuario;
import com.david.tfg.models.entity.Videojuego;
import com.david.tfg.models.entity.VideojuegoPK;

@Component
public class DTOConverter {
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper;
	}
	
	public UsuarioDTOSalida convertirADTO(Usuario user) {
		UsuarioDTOSalida userDTO = modelMapper().map(user, UsuarioDTOSalida.class);
		return userDTO;
	}
	
	public Usuario convertirAEntidad(RegistroDTO userDTOEntrada) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		userDTOEntrada.setPassword(passwordEncoder.encode(userDTOEntrada.getPassword()));
		Usuario user = modelMapper().map(userDTOEntrada, Usuario.class);
		return user;
	}
	
	public FacturaDTOSalida convertirADTO(Factura factura) {
		FacturaDTOSalida facturaDTO = modelMapper().map(factura, FacturaDTOSalida.class);
		return facturaDTO;
	}
	
	public Factura convertirAEntidad(FacturaDTOEntrada facturaDTOEntrada) {
		Factura factura = modelMapper().map(facturaDTOEntrada, Factura.class);
		Usuario u = modelMapper().map(facturaDTOEntrada.getUsuario(), Usuario.class);
		factura.setUsuario(u);
		return factura;
	}
	
	public FacturaDTO convertirADTOPredeterminada(Factura factura) {
		FacturaDTO facturaDTO = modelMapper().map(factura, FacturaDTO.class);
		return facturaDTO;
	}
	
	public Factura convertirAEntidadPredeterminada(FacturaDTO facturaDTO) {
		Factura factura = modelMapper().map(facturaDTO, Factura.class);
		System.out.println("*****convertirAEntidadPredeterminada*****");
		System.out.println(factura);
		System.out.println(factura.getPedidos());
		System.out.println("******");
		return factura;
	}
	
	public Pedido convertirAEntidad(PedidoDTOSalida pedidoDTOSalida) {
		System.out.println("*******convertirAEntidad********");
		System.out.println(pedidoDTOSalida);
		Pedido p = modelMapper().map(pedidoDTOSalida, Pedido.class);
		Videojuego v = convertirAEntidad(pedidoDTOSalida.getVideojuego());
		p.setVideojuego(v);
		p.setFactura(convertirAEntidadPredeterminada(pedidoDTOSalida.getFactura()));
		System.out.println(p);
		System.out.println("********");
		return p;
	}
	
	public VideojuegoDTO convertirADTO(Videojuego videojuego) {
		VideojuegoDTO videojuegoDTO = new VideojuegoDTO();
		videojuegoDTO.setNombreVideojuego(videojuego.getVideojuegoPK().getNombreVideojuego());
		videojuegoDTO.setNombreConsola(videojuego.getVideojuegoPK().getNombreConsola());
		videojuegoDTO.setClasificacionEdad(videojuego.getClasificacionEdad());
		videojuegoDTO.setEmpresa(videojuego.getEmpresa());
		videojuegoDTO.setFechaLanzamiento(videojuego.getFechaLanzamiento());
		videojuegoDTO.setFranquicia(videojuego.getFranquicia());
		videojuegoDTO.setGenero(videojuego.getGenero());
		videojuegoDTO.setNumJugadores(videojuego.getNumJugadores());
		videojuegoDTO.setPrecio(videojuego.getPrecio());
		videojuegoDTO.setStock(videojuego.getStock());
		videojuegoDTO.setUrl(videojuego.getUrl());
		return videojuegoDTO;
	}
	
	public Videojuego convertirAEntidad(VideojuegoDTO videojuegoDTO) {
		Videojuego videojuego = new Videojuego();
		videojuego.setVideojuegoPK(new VideojuegoPK(videojuegoDTO.getNombreVideojuego(), videojuegoDTO.getNombreConsola()));
		videojuego.setClasificacionEdad(videojuegoDTO.getClasificacionEdad());
		videojuego.setEmpresa(videojuegoDTO.getEmpresa());
		videojuego.setFechaLanzamiento(videojuegoDTO.getFechaLanzamiento());
		videojuego.setFranquicia(videojuegoDTO.getFranquicia());
		videojuego.setGenero(videojuegoDTO.getGenero());
		videojuego.setNumJugadores(videojuegoDTO.getNumJugadores());
		videojuego.setPrecio(videojuegoDTO.getPrecio());
		videojuego.setStock(videojuegoDTO.getStock());
		videojuego.setUrl(videojuegoDTO.getUrl());
		System.out.println(videojuego);
		return videojuego;
	}
	
}

package com.david.tfg.controllers;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.tfg.dto.FacturaDTO;
import com.david.tfg.dto.FacturaDTOEntrada;
import com.david.tfg.dto.PedidoDTOSalida;
import com.david.tfg.excepciones.ResourceNotFoundException;
import com.david.tfg.models.entity.Factura;
import com.david.tfg.models.entity.Pedido;
import com.david.tfg.models.entity.Usuario;
import com.david.tfg.models.entity.Videojuego;
import com.david.tfg.models.repositorios.FacturaRepositorio;
import com.david.tfg.models.repositorios.PedidoRepositorio;
import com.david.tfg.models.repositorios.UsuarioRepositorio;
import com.david.tfg.models.service.IFacturaService;
import com.david.tfg.utilities.ApiResponse;

@RestController
@RequestMapping("/v0/davgames/api/facturas")
public class ControladorFacturas {

	@Autowired
    private JavaMailSender mailSender;
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private IFacturaService facturaService;
	
	@Autowired
	private FacturaRepositorio facturaRepositorio;
	
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	
	@GetMapping("/{email}")
	public ResponseEntity<List<FacturaDTO>> obtenerFacturas(@PathVariable(value="email") String email){
		Usuario u = usuarioRepositorio.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Factura"));
		if(u!=null) {
			return new ResponseEntity<>(facturaService.obtenerFacturasPorUsuario(u), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/obtenerPedidos/{id}")
	public ResponseEntity<List<PedidoDTOSalida>> obtenerPedidos(@PathVariable(value="id") long id){
		return new ResponseEntity<>(facturaService.obtenerPedidosPorIdFactura(id), HttpStatus.OK);
	}
	
	@PutMapping("/realizarFactura")
	public ResponseEntity<ApiResponse> realizarFactura(@RequestBody FacturaDTOEntrada facturaDTO) {
		if(usuarioRepositorio.existsByUsername(facturaDTO.getUsuario().getUsername()) && facturaDTO.getPedidos().size()!=0) {
			facturaService.realizarFactura(facturaDTO);
			Factura factura = facturaRepositorio.findByFechaHora(facturaDTO.getFechaHora()).orElseThrow(() -> new ResourceNotFoundException("Factura"));
			enviarCorreoFactura(factura);
			return new ResponseEntity<>(new ApiResponse("Factura realizada con éxito"), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ApiResponse("Factura errónea"), HttpStatus.OK);
	}
	
	public void enviarCorreoFactura(Factura factura) {
	    MimeMessage message = mailSender.createMimeMessage();

	    try {
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        helper.setTo(factura.getUsuario().getEmail());
	        helper.setSubject("Detalles de la factura Nº" + factura.getId());

	        StringBuilder cuerpoMail = new StringBuilder();
	        cuerpoMail.append("<strong>Fecha de la factura: ").append(factura.getFechaHora()).append("</strong><br>");
	        cuerpoMail.append("<strong>Numero de factura: ").append(factura.getId()).append("</strong><br>");
	        cuerpoMail.append("<strong>Precio total: ").append(Math.round(sacarTotal(factura.getPedidos())*100)/100).append("</strong><br><br>");
	        cuerpoMail.append("<caption style='text-align:center;min-width:100%; width:100%; display:flex; align-items:center; justify-content:center;'>Factura Nº ").append(factura.getId()).append(" a ").append(factura.getFechaHora()).append("</caption><br>");
	        cuerpoMail.append("<table border='1'>");
	        cuerpoMail.append("<thead><tr><th>Videojuego</th><th>Cantidad</th><th>Precio unitario</th><th>Precio total</th></tr></thead>");
	        cuerpoMail.append("<tbody>");

	        List<Pedido> pedidosFactura = pedidoRepositorio.obtenerPedidosPorFactura(factura);
	        System.out.println(pedidosFactura);
	        for (Pedido pedido : pedidosFactura) {
	            Videojuego videojuego = pedido.getVideojuego();
	            cuerpoMail.append("<tr>");
	            cuerpoMail.append("<td>").append(videojuego.getVideojuegoPK().getNombreVideojuego()).append(" (").append(videojuego.getVideojuegoPK().getNombreConsola()).append(")</td>");
	            cuerpoMail.append("<td>").append(pedido.getCantidad()).append("</td>");
	            cuerpoMail.append("<td>").append(Math.round(videojuego.getPrecio() * 10* 100)/100).append(" Davcoins</td>");
	            cuerpoMail.append("<td>").append(Math.round(pedido.getCantidad() * videojuego.getPrecio() * 10 * 100)/100).append(" Davcoins</td>");
	            cuerpoMail.append("</tr>");
	        }

	        cuerpoMail.append("</tbody>");
	        cuerpoMail.append("</table></br><br>");
	        cuerpoMail.append("<strong>Precio total de la factura: ").append(Math.round(sacarTotal(pedidosFactura)*100)/100).append("</strong>");

	        cuerpoMail.append("<br>");
	        
	        cuerpoMail.append("<caption style='text-align:center;min-width:100%; width:100%; display:flex; align-items:center; justify-content:center;'>Factura Nº ").append("Codigos de los pedidos").append("</caption><br>");
	        cuerpoMail.append("<table border='1'>");
	        cuerpoMail.append("<thead><tr><th>Videojuego</th><th>Codigo</th></tr></thead>");
	        cuerpoMail.append("<tbody>");
	        
	        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	        for (Pedido pedido : pedidosFactura) {
	            Videojuego videojuego = pedido.getVideojuego();
	            cuerpoMail.append("<tr>");
	            cuerpoMail.append("<td>").append(videojuego.getVideojuegoPK().getNombreVideojuego()).append(" (").append(videojuego.getVideojuegoPK().getNombreConsola()).append(")</td>");
	            cuerpoMail.append("<td>").append(passwordEncoder.encode(videojuego.getVideojuegoPK().getNombreVideojuego()+videojuego.getVideojuegoPK().getNombreConsola()+factura.getFechaHora())).append("</td>");
	            cuerpoMail.append("</tr>");
	        }

	        cuerpoMail.append("</tbody>");
	        cuerpoMail.append("</table></br><br>");
	        
	        
	        helper.setText(cuerpoMail.toString(), true); // Establecer el contenido como HTML

	        // Envía el correo electrónico
	        mailSender.send(message);
	    } catch (MessagingException e) {
	        // Manejar el error de envío del correo electrónico
	        e.printStackTrace();
	    }
	}
	
	public Double sacarTotal(List<Pedido> pedidos) {
		return pedidos.stream()
	            .mapToDouble(pedido -> pedido.getCantidad() * pedido.getVideojuego().getPrecio()*10)
	            .sum();
	}
}

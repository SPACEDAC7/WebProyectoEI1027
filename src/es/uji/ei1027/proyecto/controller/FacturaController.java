package es.uji.ei1027.proyecto.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.proyecto.dao.DireccionDao;
import es.uji.ei1027.proyecto.dao.FacturaDao;
import es.uji.ei1027.proyecto.dao.PropiedadDao;
import es.uji.ei1027.proyecto.dao.ReservaDao;
import es.uji.ei1027.proyecto.dao.UsuarioDao;
import es.uji.ei1027.proyecto.domain.Credencial;
import es.uji.ei1027.proyecto.domain.Direccion;
import es.uji.ei1027.proyecto.domain.Factura;
import es.uji.ei1027.proyecto.domain.Propiedad;
import es.uji.ei1027.proyecto.domain.Reserva;
import es.uji.ei1027.proyecto.domain.Usuario;
import es.uji.ei1027.proyecto.validator.FacturaValidator;

@Controller
@RequestMapping("/factura")
public class FacturaController {
	private FacturaDao facturaDao;

	@Autowired
	private ReservaDao reservaDao;
	
	@Autowired
	private PropiedadDao propiedadDao;
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private DireccionDao direccionDao;
	
	@Autowired
	public void setFacturaDao( FacturaDao facturaDao){
		this.facturaDao = facturaDao;
	}
	//Listar
	@RequestMapping("/list")
	public String listFacturas(Model model, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:factura/list.html");
			retorno =  "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				model.addAttribute("facturas", facturaDao.getFacturas());
				retorno = "factura/list";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}

	//A�adir	
	@RequestMapping(value="/add") 
	public String addFactura(Model model, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:factura/add.html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				Factura factura = new Factura();
				factura.setId_factura(facturaDao.nuevoIdFactura());
				model.addAttribute("factura", factura);
				retorno = "factura/add";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}

	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("factura") Factura factura,
			BindingResult bindingResult) { 
		FacturaValidator facturaValidator = new FacturaValidator();
		facturaValidator.setReservaDao(reservaDao);
		facturaValidator.validate(factura, bindingResult); 
		if (bindingResult.hasErrors())
			return "factura/add";
		factura.crearFecha();
		facturaDao.addFactura(factura);
		return "redirect:list.html";
	}
	//Actualizar	
	@RequestMapping(value="/update/{id_factura}", method = RequestMethod.GET)
	public String editFactura(HttpSession session, Model model, @PathVariable int id_factura) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:factura/update/" + id_factura + ".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				Factura factura = facturaDao.getFactura(id_factura);
				factura.convertirDateADiaMesAno();
				session.setAttribute("ivaFactura", factura.getIva());
				model.addAttribute("factura", factura);
				retorno = "factura/update";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}

	@RequestMapping(value="/update/{id_factura}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable int id_factura, 
			@ModelAttribute("factura") Factura factura, 
			BindingResult bindingResult) {
		FacturaValidator facturaValidator = new FacturaValidator();
		facturaValidator.setReservaDao(reservaDao);
		facturaValidator.validate(factura, bindingResult); 
		if (bindingResult.hasErrors())
			return "factura/update";
		factura.crearFecha();
		facturaDao.updateFactura(factura);
		return "redirect:../list.html"; 
	}

	//Borrar	
	@RequestMapping(value="/delete/{id_factura}")
	public String processDelete(HttpSession session, Model model, @PathVariable int id_factura) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:factura/delete/" + id_factura + ".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				facturaDao.deleteFactura(id_factura);
			    retorno = "redirect:../list.html";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;  
	}
	
	@RequestMapping(value="/misFacturas")
	public String listarMisFacturas(Model model, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if (usuario != null) {
			System.out.println("He entrado en mis facturas");
			
			Map<Factura, Reserva> mapFacturaReserva = new HashMap<Factura, Reserva>();
			Map<Reserva,Propiedad> mapReservaPropiedad = new HashMap<Reserva,Propiedad>();
			
			for(Factura factura: facturaDao.obtenerFacturaPorUsuario(usuario.getId_usuario())){
				mapFacturaReserva.put(factura, reservaDao.getReserva(factura.getId_reserva()));
				System.out.println("Factura: " + factura.toString());
			}
			
			for (Reserva reserva: reservaDao.obtenerReservaPorUsuario(usuario.getId_usuario())) {
					mapReservaPropiedad.put(reserva, propiedadDao.getPropiedad(reserva.getId_propiedad()));
					System.out.println("Reserva: " + reserva.toString());
			}
						
			model.addAttribute("listaFacturaReserva", mapFacturaReserva);
			model.addAttribute("listaReservaPropiedad", mapReservaPropiedad);
			System.out.println("salgo de mis facturas");
			return "factura/misFacturas";
			
		} else {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:factura/misFacturas.html");
			return "login";
		}
	}
	
	@RequestMapping(value="/single/{id_factura}")
	public String processDetails(@PathVariable int id_factura, HttpSession session, Model model){
		Factura factura = facturaDao.getFactura(id_factura);
		Reserva reserva = reservaDao.getReserva(factura.getId_reserva());
		Usuario usuarioReserva = usuarioDao.getUsuario(reserva.getId_usuario());
		Direccion direccionUsuario = direccionDao.getDireccion(usuarioReserva.getId_direccion());
		Propiedad propiedad = propiedadDao.getPropiedad(reserva.getId_propiedad());
		Usuario propietario = usuarioDao.getUsuario(propiedad.getId_usuario());
		Direccion direccionUsuarioPropiedad = direccionDao.getDireccion(usuarioDao.getUsuario(propietario.getId_usuario()).getId_direccion());
		double diasReserva = this.diasEntreFechas(reserva.getFecha_checkin(), reserva.getFecha_checkout());
		
		model.addAttribute("factura", factura);
		model.addAttribute("reserva", reserva);
		model.addAttribute("usuarioReserva", usuarioReserva);
		model.addAttribute("direccionUsuario", direccionUsuario);
		model.addAttribute("propiedad", propiedad);
		model.addAttribute("propietario", propietario);
		model.addAttribute("direccionUsuarioPropiedad", direccionUsuarioPropiedad);
		model.addAttribute("diasReserva", diasReserva);
		return "factura/single";
	}
	
	private double diasEntreFechas(Date inicio, Date fin){
		long fechaInicial = inicio.getTime(); //Tanto fecha inicial como fecha final son Date. 
		long fechaFinal = fin.getTime(); 
		long diferencia = fechaFinal - fechaInicial; 
		double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
		return dias;
	}
}

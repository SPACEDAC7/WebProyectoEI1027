package es.uji.ei1027.proyecto.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
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

import es.uji.ei1027.proyecto.dao.FacturaDao;
import es.uji.ei1027.proyecto.dao.MensajeDao;
import es.uji.ei1027.proyecto.dao.PeriodoDao;
import es.uji.ei1027.proyecto.dao.PropiedadDao;
import es.uji.ei1027.proyecto.dao.ReservaDao;
import es.uji.ei1027.proyecto.domain.Credencial;
import es.uji.ei1027.proyecto.domain.Direccion;
import es.uji.ei1027.proyecto.domain.Factura;
import es.uji.ei1027.proyecto.domain.Mensaje;
import es.uji.ei1027.proyecto.domain.MensajeError;
import es.uji.ei1027.proyecto.domain.Periodo;
import es.uji.ei1027.proyecto.domain.Propiedad;
import es.uji.ei1027.proyecto.domain.Reserva;
import es.uji.ei1027.proyecto.domain.Usuario;
import es.uji.ei1027.proyecto.validator.ReservaValidator;

@Controller
@RequestMapping("/reserva")
public class ReservaController {
private ReservaDao reservaDao;
private PropiedadDao propiedadDao;
private PeriodoDao periodoDao;
private MensajeDao mensajeDao;
private FacturaDao facturaDao;
	
	@Autowired
	public void setReservaDao( ReservaDao reservaDao){
		this.reservaDao = reservaDao;
	}

	@Autowired
	public void setFacturaDao( FacturaDao reservaDao){
		this.facturaDao = reservaDao;
	}
	@Autowired
	public void setMensajeDao( MensajeDao reservaDao){
		this.mensajeDao = reservaDao;
	}
	
	@Autowired
	public void setPropiedadDao(PropiedadDao propiedadDao){
		this.propiedadDao = propiedadDao;
	}
	
	@Autowired
	public void setPeriodoDao(PeriodoDao periodoDao){
		this.periodoDao = periodoDao;
	}
	//Listar
	@RequestMapping("/list")
	public String listReservas(Model model, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:reserva/list.html");
			retorno =  "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				model.addAttribute("reservas", reservaDao.getReservas());
				retorno = "reserva/list";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}
	
	//A�adir	
	@RequestMapping(value="/add") 
	public String addReserva(Model model, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:reserva/add.html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				Reserva reserva = new Reserva();
				reserva.setId_reserva(reservaDao.nuevoIdReserva());
				model.addAttribute("reserva", reserva);
				retorno = "reserva/add";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}

	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("reserva") Reserva reserva,
			BindingResult bindingResult) { 
		ReservaValidator reservaValidator = new ReservaValidator();
		reservaValidator.validate(reserva, bindingResult); 
		if (bindingResult.hasErrors())
			return "reserva/add";
		reserva.crearFechas();
		reservaDao.addReserva(reserva);
		return "redirect:list.html";
	}
	//Actualizar	
	@RequestMapping(value="/update/{id_reserva}", method = RequestMethod.GET)
	public String editReserva(Model model, @PathVariable int id_reserva, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:reserva/update/" + id_reserva + ".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				Reserva reserva = reservaDao.getReserva(id_reserva);
				//Convierto fechas de tipo Date a tipo dd/mm/aaaa para que se muestren en la página de update
				reserva.convertirDateADiaMesAno();
				model.addAttribute("reserva", reserva);
				retorno = "reserva/update";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}

	@RequestMapping(value="/update/{id_reserva}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable int id_reserva, 
			@ModelAttribute("reserva") Reserva reserva, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) 
			return "reserva/update";
		reserva.crearFechas();
		reservaDao.updateReserva(reserva);
		return "redirect:../list.html"; 
	}

	//Borrar	
	@RequestMapping(value="/delete/{id_reserva}")
	public String processDelete(@PathVariable int id_reserva, HttpSession session, Model model) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:reserva/delete/" + id_reserva + ".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			Reserva reservaBorrar = reservaDao.getReserva(id_reserva);
			if ( rol.equals("administrador") ) {
				reservaDao.deleteReserva(id_reserva);
			    retorno = "redirect:../list.html";
			} else if ( rol.equals("inquilino") && reservaBorrar.getId_usuario() == usuario.getId_usuario() ) {
				reservaDao.deleteReserva(id_reserva);
				retorno = "redirect:../misReservas.html";
			}else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../../cabecera/inicio.html";
			}
		}
		return retorno;  
	}
	
	@RequestMapping("/misReservas")
	public String listarMisReservas(Model model, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if (usuario != null) {
			Map<Reserva, Propiedad> mapReservasPropiedad = new HashMap<Reserva, Propiedad>();
			for (Reserva reserva: reservaDao.obtenerReservaPorUsuario(usuario.getId_usuario())) {
				mapReservasPropiedad.put(reserva, propiedadDao.getPropiedad(reserva.getId_propiedad()));
			}
			model.addAttribute("listaReservaPropiedades", mapReservasPropiedad);
			return "reserva/misReservas";
		} else {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:propiedad/add.html");
			return "login";
		}
	}
	
	@RequestMapping(value="/reservar/{id_propiedad}")
	public String reservar(@PathVariable int id_propiedad,Model model, HttpSession session){
		
		System.out.println("Entramos");
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:reserva/reservar/"+id_propiedad+".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("inquilino") ) {
				System.out.println("SOMO INQUILINOS");
				Reserva reserva = new Reserva();
				reserva.setId_reserva(reservaDao.nuevoIdReserva());
				reserva.setId_propiedad(id_propiedad);
				reserva.setId_usuario(usuario.getId_usuario());
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				reserva.setFechaReserva(sdf.format(this.fechaDeHoy()));
				reserva.setFecha_reserva(this.fechaDeHoy());
				reserva.setPrecio_reserva(propiedadDao.getPropiedad(id_propiedad).getPrecio_propiedad());
				model.addAttribute("reserva", reserva);
				session.setAttribute("reserva", reserva);
				System.out.println("Salimos");
				retorno = "reserva/reservar";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}
	
	@RequestMapping(value="/reservar/{id_propiedad}", method=RequestMethod.POST) 
	public String processReservaSubmit(HttpSession session, @ModelAttribute("reserva") Reserva reservaModificada,
			BindingResult bindingResult) { 
		System.out.println("Hemos entrado");
		ReservaValidator reservaValidator = new ReservaValidator();
		reservaModificada.setEstado("pendiente");
		reservaValidator.validate(reservaModificada, bindingResult);
		if (bindingResult.hasErrors()){
			System.out.println("Hay un error");
			return "reserva/reservar";
		}
		Reserva reserva = (Reserva) session.getAttribute("reserva");
		reserva.setFecha_checkin(reservaModificada.getFecha_checkin());
		reserva.setFecha_checkout(reservaModificada.getFecha_checkout());
		reserva.setFechaCheckIn(reservaModificada.getFechaCheckIn());
		reserva.setFechaCheckOut(reservaModificada.getFechaCheckOut());
		reserva.setPrecio_reserva(reservaModificada.getPrecio_reserva());
		reserva.setEstado(reservaModificada.getEstado());
		
		reserva.crearFechas();
		double diasReservados = this.diasEntreFechas(reserva.getFecha_checkin(), reserva.getFecha_checkout());
		double precioReserva = reserva.getPrecio_reserva() * diasReservados;
		System.out.println("Dias reservados " + diasReservados);
		System.out.println("Precio reserva " + reserva.getPrecio_reserva());
		System.out.println("Precio final " + precioReserva );
		reserva.setPrecio_reserva((float)precioReserva);
		List<Periodo> listaPeriodos = periodoDao.getPeriodosDePropiedad(reserva.getId_propiedad());
		Date fechaInicio = reserva.getFecha_checkin();
		Date fechaFin = reserva.getFecha_checkout();
		for(Periodo periodo: listaPeriodos){
			if((!fechaInicio.before(periodo.getInicio()) && !fechaFin.before(periodo.getInicio()))&&(!fechaInicio.after(periodo.getFin()) && !fechaFin.after(periodo.getFin()))){
				MensajeError mensajeError = new MensajeError("La propiedad ya tiene una reserva en las fecha solicitadas. Perdone las molestias");
				mensajeError.setMensaje(mensajeError.getMensaje().toUpperCase());
				MensajeError m = new MensajeError("../reserva/misReservas.html");
				session.setAttribute("nextURL", m);
				session.setAttribute("mensajeError", mensajeError);
				return "redirect:../../error/mostrarError.html";
			}
		}
		System.out.println("Si que se ha podido");
		periodoDao.addPeriodo(new Periodo(periodoDao.nuevoIdPeriodo(),reserva.getId_propiedad(),reserva.getFecha_checkin(),reserva.getFecha_checkout()));
		reservaDao.addReserva(reserva);
		session.removeAttribute("reserva");
		return "redirect:../list.html";
	}
	
	@RequestMapping(value="reservaPropietario/{id_usuario}")
	public String verPeticiones(@PathVariable int id_usuario,Model model, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:reserva/reservaPropietario/"+id_usuario+".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("propietario") ) {
				Map<Reserva, Propiedad> mapReservasPropiedad = new HashMap<Reserva, Propiedad>();
				for (Reserva reserva: reservaDao.obtenerPeticiones(id_usuario)) {
					mapReservasPropiedad.put(reserva, propiedadDao.getPropiedad(reserva.getId_propiedad()));
				}
				model.addAttribute("listaReservaPropiedades", mapReservasPropiedad);
				retorno = "reserva/reservasPropietario";
			}else{
				retorno = "redirect:../list.html";
			}
		}
		return retorno;
	}
	
	@RequestMapping(value="aceptar/{id_reserva}")
	public String aceptarReserva(@PathVariable int id_reserva,Model model, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:../index.jsp");
			retorno = "login";
		} else {
			reservaDao.confirmarReserva(id_reserva);
			Reserva reservaConfirm = reservaDao.getReserva(id_reserva);
			mensajeDao.addMensaje(new Mensaje(mensajeDao.nuevoIdMensaje(),reservaConfirm.getId_usuario(),0,"Confirmacion de la reserva", "Tu reserva realizada en la fecha de " +reservaConfirm.getFechaReserva().toString()+" ha sido confirmada",3,this.fechaDeHoy()));
			facturaDao.addFactura(new Factura(facturaDao.nuevoIdFactura(),id_reserva,this.fechaDeHoy(),reservaConfirm.getPrecio_reserva()*1.21f,21));
			return "redirect:../list.html";
		}
		return retorno;
	}
	
	@RequestMapping(value="rechazar/{id_reserva}")
	public String rechazarReserva(@PathVariable int id_reserva,Model model, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:../index.jsp");
			retorno = "login";
		} else {
			reservaDao.rechazarReserva(id_reserva);
			mensajeDao.addMensaje(new Mensaje(mensajeDao.nuevoIdMensaje(),reservaDao.getReserva(id_reserva).getId_usuario(),0,"Rechazo de la reserva", "Tu reserva realizada en la fecha de " +reservaDao.getReserva(id_reserva).getFechaReserva().toString()+" ha sido rechazada",3,this.fechaDeHoy()));
			periodoDao.eliminarPeriodo(reservaDao.getReserva(id_reserva));
			return "redirect:../list.html";
		}
		return retorno;
	}
	
	private Date fechaDeHoy() {
		java.util.Date fecha = new java.util.Date();
		Date fechaSQL = new Date(fecha.getTime());
		return fechaSQL;
		
	}
	
	private double diasEntreFechas(Date inicio, Date fin){
		long fechaInicial = inicio.getTime(); //Tanto fecha inicial como fecha final son Date. 
		long fechaFinal = fin.getTime(); 
		long diferencia = fechaFinal - fechaInicial; 
		double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
		return dias;
	}
	
}

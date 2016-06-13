package es.uji.ei1027.proyecto.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.proyecto.dao.ReservaDao;
import es.uji.ei1027.proyecto.domain.Credencial;
import es.uji.ei1027.proyecto.domain.Reserva;
import es.uji.ei1027.proyecto.domain.Usuario;
import es.uji.ei1027.proyecto.validator.ReservaValidator;

@Controller
@RequestMapping("/reserva")
public class ReservaController {
private ReservaDao reservaDao;
	
	@Autowired
	public void setReservaDao( ReservaDao reservaDao){
		this.reservaDao = reservaDao;
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
			if ( rol.equals("administrador") ) {
				reservaDao.deleteReserva(id_reserva);
			    retorno = "redirect:../list.html";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;  
	}
}

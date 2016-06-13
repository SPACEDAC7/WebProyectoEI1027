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

import es.uji.ei1027.proyecto.dao.ServicioDao;
import es.uji.ei1027.proyecto.domain.Credencial;
import es.uji.ei1027.proyecto.domain.Direccion;
import es.uji.ei1027.proyecto.domain.Servicio;
import es.uji.ei1027.proyecto.domain.Usuario;
import es.uji.ei1027.proyecto.validator.ServicioValidator;

@Controller
@RequestMapping("/servicio")
public class ServicioController {
	private ServicioDao servicioDao;
	
	@Autowired
	public void setServicioDao( ServicioDao servicioDao){
		this.servicioDao = servicioDao;
	}
	
	//Listar
	@RequestMapping("/list")
	public String listServicios(Model model, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:servicio/list.html");
			retorno =  "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				model.addAttribute("servicios", servicioDao.getServicios());
				retorno = "servicio/list";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}
	
	//Anadir	
	@RequestMapping(value="/add") 
	public String addServicio(Model model, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:servicio/add.html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				Servicio servicio = new Servicio();
				servicio.setIdServicio(servicioDao.nuevoIdServicio());
				model.addAttribute("servicio", servicio);
				retorno = "servicio/add";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}

	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("servicio") Servicio servicio,
			BindingResult bindingResult) { 
		ServicioValidator servicioValidator = new ServicioValidator();
		servicioValidator.validate(servicio, bindingResult); 
		if (bindingResult.hasErrors())
			return "servicio/add";
		servicioDao.addServicio(servicio);
		return "redirect:list.html";
	}
	//Actualizar	
	@RequestMapping(value="/update/{id_servicio}", method = RequestMethod.GET)
	public String editServicio(Model model, @PathVariable int id_servicio, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:servicio/update/" + id_servicio + ".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				Servicio servicio = servicioDao.getServicio(id_servicio);
				model.addAttribute("servicio", servicio);
				retorno = "servicio/update";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}

	@RequestMapping(value="/update/{id_servicio}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable int id_servicio, 
			@ModelAttribute("servicio") Servicio servicio, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) 
			return "servicio/update";
		servicioDao.updateServicio(servicio);
		return "redirect:../list.html"; 
	}

	//Borrar	
	@RequestMapping(value="/delete/{id_servicio}")
	public String deleteServicio(@PathVariable int id_servicio, HttpSession session, Model model) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:servicio/delete/" + id_servicio + ".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				servicioDao.deleteServicio(id_servicio);
			    retorno = "redirect:../list.html";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}

}

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

import es.uji.ei1027.proyecto.dao.MensajeDao;
import es.uji.ei1027.proyecto.domain.Credencial;
import es.uji.ei1027.proyecto.domain.Mensaje;
import es.uji.ei1027.proyecto.domain.Reserva;
import es.uji.ei1027.proyecto.domain.Usuario;
import es.uji.ei1027.proyecto.validator.MensajeValidator;

@Controller
@RequestMapping("/mensaje")
public class MensajeController {
	private MensajeDao mensajeDao;
	
	@Autowired
	public void setMensajeDao( MensajeDao mensajeDao){
		this.mensajeDao = mensajeDao;
	}
	
	//Listar
	@RequestMapping("/list")
	public String listMensajes(Model model, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:mensaje/list.html");
			retorno =  "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				model.addAttribute("mensajes", mensajeDao.getMensajes());
				retorno = "mensaje/list";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}
	
	//A�adir	
	@RequestMapping(value="/add") 
	public String addMensaje(Model model, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:mensaje/add.html");
			retorno = "login";
		} else {
			System.out.println("Entramos en el add");
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				Mensaje mensaje = new Mensaje();
				System.out.println("SOMOS ADMINS");
				mensaje.setId_mensaje(mensajeDao.nuevoIdMensaje());
				model.addAttribute("mensaje", mensaje);
				retorno = "mensaje/add";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}

	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("mensaje") Mensaje mensaje,
			BindingResult bindingResult) { 
		MensajeValidator mensajeValidator = new MensajeValidator();
		mensajeValidator.validate(mensaje, bindingResult); 
		if (bindingResult.hasErrors()){
			return "mensaje/add";
		}
		mensajeDao.addMensaje(mensaje);
		return "redirect:list.html";
	}
	
	//Actualizar	
		@RequestMapping(value="/update/{id_mensaje}", method = RequestMethod.GET)
		public String editMensaje(Model model, @PathVariable int id_mensaje, HttpSession session) {
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			String retorno;
			if (usuario == null) {
				model.addAttribute("credencial", new Credencial());
				session.setAttribute("nextURL", "redirect:mensaje/update/" + id_mensaje + ".html");
				retorno = "login";
			} else {
				String rol = (String) session.getAttribute("rol");
				if ( rol.equals("administrador") ) {
					Mensaje mensaje = mensajeDao.getMensaje(id_mensaje);
					//Convierto fechas de tipo Date a tipo dd/mm/aaaa para que se muestren en la página de update
					model.addAttribute("mensaje", mensaje);
					retorno = "mensaje/update";
				} else {
					//Acceso no autorizado porque el rol del usuario no es administrador
					retorno = "redirect:../index.jsp";
				}
			}
			return retorno;
		}

		@RequestMapping(value="/update/{id_mensaje}", method = RequestMethod.POST) 
		public String processUpdateSubmit(@PathVariable int id_mensaje, 
				@ModelAttribute("mensaje") Mensaje mensaje, 
				BindingResult bindingResult) {
			System.out.println("Comprobamos los errores");
			if (bindingResult.hasErrors()) 
				return "mensaje/update";
			System.out.println("No hay errores");
			mensajeDao.updateMensaje(mensaje);
			return "redirect:../list.html"; 
		}

		//Borrar	
		@RequestMapping(value="/delete/{id_mensaje}")
		public String processDelete(@PathVariable int id_mensaje, HttpSession session, Model model) {
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			String retorno;
			if (usuario == null) {
				model.addAttribute("credencial", new Credencial());
				session.setAttribute("nextURL", "redirect:mensaje/delete/" + id_mensaje + ".html");
				retorno = "login";
			} else {
				String rol = (String) session.getAttribute("rol");
				if ( rol.equals("administrador") ) {
					mensajeDao.deleteMensaje(id_mensaje);
				    retorno = "redirect:../list.html";
				} else {
					//Acceso no autorizado porque el rol del usuario no es administrador
					retorno = "redirect:../index.jsp";
				}
			}
			return retorno;
		}
}

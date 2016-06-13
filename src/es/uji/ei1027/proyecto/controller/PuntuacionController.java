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

import es.uji.ei1027.proyecto.dao.PuntuacionDao;
import es.uji.ei1027.proyecto.domain.Credencial;
import es.uji.ei1027.proyecto.domain.Direccion;
import es.uji.ei1027.proyecto.domain.Puntuacion;
import es.uji.ei1027.proyecto.domain.Usuario;
import es.uji.ei1027.proyecto.validator.PuntuacionValidator;

@Controller
@RequestMapping("/puntuacion")
public class PuntuacionController {
private PuntuacionDao puntuacionDao;
	
	@Autowired
	public void setPuntuacionDao( PuntuacionDao puntuacionDao){
		this.puntuacionDao = puntuacionDao;
	}
	//Listar
	@RequestMapping("/list")
	public String listPuntuaciones(Model model, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:puntuacion/list.html");
			retorno =  "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				model.addAttribute("puntuaciones", puntuacionDao.getPuntuaciones());
				retorno = "puntuacion/list";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}
	
	//A�adir	
	@RequestMapping(value="/add") 
	public String addPuntuacion(Model model, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:puntuacion/add.html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				Puntuacion puntuacion = new Puntuacion();
				puntuacion.setId_puntuacion(puntuacionDao.nuevoIdPuntuacion());
				model.addAttribute("puntuacion", puntuacion);
				retorno = "puntuacion/add";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("puntuacion") Puntuacion puntuacion,
			BindingResult bindingResult) { 
		PuntuacionValidator puntuacionValidator = new PuntuacionValidator();
		puntuacionValidator.validate(puntuacion, bindingResult); 
		if (bindingResult.hasErrors())
			return "puntuacion/add";
		puntuacionDao.addPuntuacion(puntuacion);
		return "redirect:list.html";
	}
	//Actualizar	
	@RequestMapping(value="/update/{id_puntuacion}", method = RequestMethod.GET)
	public String editPuntuacion(Model model, @PathVariable int id_puntuacion, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:puntuacion/update/" + id_puntuacion + ".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				model.addAttribute("puntuacion", puntuacionDao.getPuntuacion(id_puntuacion));
				retorno = "puntuacion/update";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}
	
	@RequestMapping(value="/update/{id_puntuacion}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable int id_puntuacion, 
			@ModelAttribute("puntuacion") Puntuacion puntuacion, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) 
			return "puntuacion/update";
		puntuacionDao.updatePuntuacion(puntuacion);
		return "redirect:../list.html"; 
	}
	
	//Borrar	
	@RequestMapping(value="/delete/{id_puntuacion}")
	public String processDelete(@PathVariable int id_puntuacion, HttpSession session, Model model) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:puntuacion/delete/" + id_puntuacion + ".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				puntuacionDao.deletePuntuacion(id_puntuacion);
			    retorno = "redirect:../list.html";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno; 
	}
}

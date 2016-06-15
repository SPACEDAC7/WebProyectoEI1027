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

import es.uji.ei1027.proyecto.dao.PropiedadDao;
import es.uji.ei1027.proyecto.dao.PropiedadServicioDao;
import es.uji.ei1027.proyecto.domain.Credencial;
import es.uji.ei1027.proyecto.domain.PropiedadServicio;
import es.uji.ei1027.proyecto.domain.Usuario;
import es.uji.ei1027.proyecto.validator.PropiedadServicioValidator;

@Controller
@RequestMapping("/propiedadServicio")
public class PropiedadServicioController {
private PropiedadServicioDao propiedadServicioDao;
	
	@Autowired
	PropiedadDao pripiedadDao;

	@Autowired
	public void setPropiedadServicioDao( PropiedadServicioDao propiedadPuntuacionDao){
		this.propiedadServicioDao = propiedadPuntuacionDao;
	}
	//Listar
	@RequestMapping("/list")
	public String listPropiedadesServicios(Model model, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:propiedadServicio/list.html");
			retorno =  "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				model.addAttribute("propiedadesServicios", propiedadServicioDao.getPropiedadesServicios());
				retorno = "propiedadServicio/list";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}
	
	//A�adir	
	@RequestMapping(value="/add") 
	public String addPropiedadServicio(Model model, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:propiedadServicio/add.html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				model.addAttribute("propiedadServicio", new PropiedadServicio());
				model.addAttribute("propiedades", pripiedadDao.getPropiedades());
				retorno = "propiedadServicio/add";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}

	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("propiedadServicio") PropiedadServicio propiedadServicio,
			BindingResult bindingResult) { 
		PropiedadServicioValidator propiedadServicioValidator = new PropiedadServicioValidator();
		propiedadServicioValidator.validate(propiedadServicio, bindingResult); 
		if (bindingResult.hasErrors())
			return "propiedadServicio/add";
		propiedadServicioDao.addPropiedadServicio(propiedadServicio);
		return "redirect:list.html";
	}
	//Actualizar	
	@RequestMapping(value="/update/{id_propiedad}&{id_servicio}", method = RequestMethod.GET)
	public String editPropiedadServicio(Model model, @PathVariable int id_propiedad, @PathVariable int id_servicio, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:propiedadServicio/update/" + id_propiedad + "&" + id_servicio + ".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				model.addAttribute("propiedadServicio", propiedadServicioDao.getPropiedadServicio(id_propiedad, id_servicio));
				retorno = "propiedadServicio/update";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}

	@RequestMapping(value="/update/{id_propiedad}&{id_servicio}", method = RequestMethod.POST) 
	public String processUpdateSubmit( @PathVariable int id_propiedad, @PathVariable int id_servicio, 
			@ModelAttribute("propiedadServicio") PropiedadServicio propiedadServicio, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) 
			return "propiedadServicio/update";
		propiedadServicioDao.updatePropiedadServicio(propiedadServicio);
		return "redirect:../list.html"; 
	}

	//Borrar	
	@RequestMapping(value="/delete/{id_propiedad}&{id_servicio}")
	public String processDelete(@PathVariable int id_propiedad,@PathVariable int id_servicio, HttpSession session, Model model) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:propiedadServicio/delete/" + id_propiedad + "&" + id_servicio + ".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				propiedadServicioDao.deletePropiedadServicio(id_propiedad, id_servicio);
			    retorno = "redirect:../list.html";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno; 
	}
}

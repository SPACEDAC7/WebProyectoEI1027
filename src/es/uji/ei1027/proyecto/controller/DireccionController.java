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

import es.uji.ei1027.proyecto.dao.DireccionDao;
import es.uji.ei1027.proyecto.domain.Credencial;
import es.uji.ei1027.proyecto.domain.Direccion;
import es.uji.ei1027.proyecto.domain.Usuario;
import es.uji.ei1027.proyecto.validator.DireccionValidator;

@Controller
@RequestMapping("/direccion")
public class DireccionController {
	private DireccionDao direccionDao;
	
	@Autowired
	public void setDireccionDao( DireccionDao direccionDao){
		this.direccionDao=direccionDao;
	}
	
	//Listar
	@RequestMapping("/list")
	public String listCredenciales(Model model, HttpSession session){
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:direccion/list.html");
			retorno =  "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				model.addAttribute("direcciones", direccionDao.getDirecciones());
				retorno = "direccion/list";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}
		
	//A�adir	
	@RequestMapping(value="/add") 
	public String addDireccion(Model model, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:direccion/add.html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				Direccion dir = new Direccion();
				dir.setId_direccion(direccionDao.nuevoIdDireccion());
				model.addAttribute("direccion", dir);
				retorno = "direccion/add";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}

	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("direccion") Direccion direccion,
	                                BindingResult bindingResult) { 
		DireccionValidator direccionValidator = new DireccionValidator();
		direccionValidator.validate(direccion, bindingResult); 
		if (bindingResult.hasErrors())
				return "direccion/add";
		 direccionDao.addDireccion(direccion);
		 return "redirect:list.html";
	 }
	
	//Actualizar	
	@RequestMapping(value="/update/{id_direccion}", method = RequestMethod.GET)
	public String editDireccion(Model model, @PathVariable int id_direccion, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:direccion/update/" + id_direccion + ".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				model.addAttribute("direccion", direccionDao.getDireccion(id_direccion));
				retorno = "direccion/update";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}
			
	@RequestMapping(value="/update/{id_direccion}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable int id_direccion, 
                            @ModelAttribute("direccion") Direccion direccion, 
                            BindingResult bindingResult) {
		 if (bindingResult.hasErrors()) 
			 return "direccion/update";
		 direccionDao.updateDireccion(direccion);
		 return "redirect:../list.html"; 
	  }
			
	//Borrar	
	@RequestMapping(value="/delete/{id_direccion}")
	 public String processDelete(@PathVariable int id_direccion, HttpSession session, Model model) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:direccion/delete/" + id_direccion + ".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				direccionDao.deleteDireccion(id_direccion);
			    retorno = "redirect:../list.html";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;  
	 }	 
}

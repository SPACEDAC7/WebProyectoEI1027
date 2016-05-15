package es.uji.ei1027.proyecto.controller;

import javax.servlet.http.HttpSession;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.proyecto.dao.CredencialDao;
import es.uji.ei1027.proyecto.domain.Credencial;
import es.uji.ei1027.proyecto.domain.Usuario;
import es.uji.ei1027.proyecto.validator.CredencialValidator;

@Controller
@RequestMapping("/credencial")
public class CredencialController {
	private CredencialDao credencialDao;
	
	@Autowired
	public void setCredencialDao( CredencialDao credencialDao){
		this.credencialDao = credencialDao;
	}
	//Listar
	@RequestMapping("/list")
	public String listCredenciales(HttpSession session, Model model){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:credencial/list.html");
			retorno =  "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				model.addAttribute("credenciales", credencialDao.getCredenciales());
				retorno = "credencial/list";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}
	
	//A�adir	
	@RequestMapping(value="/add") 
	public String addCredencial(HttpSession session, Model model) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:credencial/add.html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				Credencial credencial = new Credencial();
				credencial.setId_credencial(credencialDao.nuevoIdCredencial());
				model.addAttribute("credencial", credencial);
				retorno = "credencial/add";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}

	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("credencial") Credencial credencial,
			BindingResult bindingResult) { 
		CredencialValidator credencialValidator = new CredencialValidator();
		credencialValidator.validate(credencial, bindingResult); 
		if (bindingResult.hasErrors())
			return "credencial/add";
		BasicPasswordEncryptor passwordEncrypter = new BasicPasswordEncryptor();
		credencial.setPassword(passwordEncrypter.encryptPassword(credencial.getPassword()));
		credencialDao.addCredencial(credencial);
		return "redirect:list.html";
	}
	//Actualizar	
	@RequestMapping(value="/update/{id_credencial}", method = RequestMethod.GET)
	public String editCredencial(HttpSession session, Model model, @PathVariable int id_credencial) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:credencial/update/" + id_credencial + ".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				model.addAttribute("credencial", credencialDao.getCredencial(id_credencial));
				retorno = "credencial/update";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}

	@RequestMapping(value="/update/{id_credencial}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable int id_credencial, 
			@ModelAttribute("credencial") Credencial credencial, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) 
			return "credencial/update";
		credencialDao.updateCredencial(credencial);
		return "redirect:../list.html"; 
	}

	//Borrar	
	@RequestMapping(value="/delete/{id_credencial}")
	public String processDelete(@PathVariable int id_credencial, HttpSession session, Model model) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:credencial/delete/" + id_credencial + ".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				credencialDao.deleteCredencial(id_credencial);
				retorno = "redirect:../list.html";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno; 
	}
}

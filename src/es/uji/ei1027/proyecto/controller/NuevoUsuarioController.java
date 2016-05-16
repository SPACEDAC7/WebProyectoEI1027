package es.uji.ei1027.proyecto.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.proyecto.dao.CredencialDao;
import es.uji.ei1027.proyecto.dao.UsuarioDao;
import es.uji.ei1027.proyecto.domain.Credencial;
import es.uji.ei1027.proyecto.domain.Usuario;


@RequestMapping("/signup")
@Controller
public class NuevoUsuarioController {
	@Autowired
	private CredencialDao credencialDao;
	@Autowired
	private UsuarioDao usuarioDao;
	
	
	@Autowired
	public void setCredencialDao( CredencialDao credencialDao, UsuarioDao usuarioDao ){
		this.credencialDao = credencialDao;
		this.usuarioDao = usuarioDao;
	}
	
	@RequestMapping("/addUser")
	public String addNuevoUsuarioYCredencial(HttpSession session, Model model){
		model.addAttribute("nuevoUsuario", new Usuario());
		model.addAttribute("credencial", new Credencial());
		return "signup/signup";
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("nuevoUsuario") Usuario usuario,
			BindingResult bindingResult) {
		
	}

}

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

import es.uji.ei1027.proyecto.domain.Credencial;
import es.uji.ei1027.proyecto.domain.Usuario;

@Controller
@RequestMapping("/gestiones")
public class GestionesController {

	
	@RequestMapping("/listGestiones")
	public String listGestiones(HttpSession session,Model model){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:gestiones/listGestiones.html");
			retorno =  "login";
		} else {
			retorno = "gestiones/listGestiones";
		}
		return retorno;
	}
}

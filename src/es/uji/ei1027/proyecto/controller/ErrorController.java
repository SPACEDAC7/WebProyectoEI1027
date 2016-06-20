package es.uji.ei1027.proyecto.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import es.uji.ei1027.proyecto.domain.MensajeError;



@Controller
@RequestMapping("/error")
public class ErrorController {
	
	//Listar
	@RequestMapping(value="/mostrarError")
	public String mostrarError(Model model, HttpSession session){
		String retorno;	
		retorno = "error/error";
		MensajeError m = (MensajeError)session.getAttribute("mensajeError");
		model.addAttribute("mensajeError", m);
		return retorno;
	}
	
}

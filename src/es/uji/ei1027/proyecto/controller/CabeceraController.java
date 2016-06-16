package es.uji.ei1027.proyecto.controller;

import javax.servlet.http.HttpSession;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cabecera")
public class CabeceraController {
    
	@RequestMapping("/inicio")
	public String iniciar(Model model){
		return "cabecera/inicio";
	}
	
	@RequestMapping("/contacta")
	public String contactar(Model model){
		return "cabecera/contacta";
	}
	
	@RequestMapping("/nosotros")
	public String nosotros(Model model){
		return "cabecera/nosotros";
	}
}

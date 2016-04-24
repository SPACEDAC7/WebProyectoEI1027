package es.uji.ei1027.proyecto.controller;

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
	public String listCredenciales(Model model){
		model.addAttribute("credenciales", credencialDao.getCredenciales());
		return "credencial/list";
	}
	
	//Añadir	
		@RequestMapping(value="/add") 
		public String addNadador(Model model) {
			model.addAttribute("credencial", new Credencial());
			return "credencial/add";
		}

		@RequestMapping(value="/add", method=RequestMethod.POST) 
		public String processAddSubmit(@ModelAttribute("credencial") Credencial credencial,
		                                BindingResult bindingResult) { 
			CredencialValidator credencialValidator = new CredencialValidator();
			credencialValidator.validate(credencial, bindingResult); 
			if (bindingResult.hasErrors())
					return "credencial/add";
			 credencialDao.addCredencial(credencial);
			 return "redirect:list.html";
		 }
		//Actualizar	
		@RequestMapping(value="/update/{id_credencial}", method = RequestMethod.GET)
		public String editNadador(Model model, @PathVariable int id_credencial) {
			model.addAttribute("credencial", credencialDao.getCredencial(id_credencial));
			return "credencial/update"; 
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
		 public String processDelete(@PathVariable int id_credencial) {
		           credencialDao.deleteCredencial(id_credencial);
		           return "redirect:../list.html"; 
		 }
		 
}

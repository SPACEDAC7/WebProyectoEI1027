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
	
/*	//Añadir	
		@RequestMapping(value="/add") 
		public String addNadador(Model model) {
			model.addAttribute("nadador", new Nadador());
			return "nadador/add";
		}

//		@RequestMapping(value="/add", method=RequestMethod.POST) 
//		public String processAddSubmit(@ModelAttribute("nadador") Nadador nadador,
//		                                BindingResult bindingResult) { 
//			 if (bindingResult.hasErrors())
//					return "nadador/add";
//			 nadadorDao.addNadador(nadador);
//			 return "redirect:list.html";
//		 }
	//Actualizar	
		@RequestMapping(value="/update/{nom}", method = RequestMethod.GET)
		public String editNadador(Model model, @PathVariable String nom) {
			model.addAttribute("nadador", nadadorDao.getNadador(nom));
			return "nadador/update"; 
		}
		
		@RequestMapping(value="/update/{nom}", method = RequestMethod.POST) 
		public String processUpdateSubmit(@PathVariable String nom, 
	                            @ModelAttribute("nadador") Nadador nadador, 
	                            BindingResult bindingResult) {
			 if (bindingResult.hasErrors()) 
				 return "nadador/update";
			 nadadorDao.updateNadador(nadador);
			 return "redirect:../list.html"; 
		  }
	//Borrar	
		@RequestMapping(value="/delete/{nom}")
		 public String processDelete(@PathVariable String nom) {
		           nadadorDao.deleteNadador(nom);
		           return "redirect:../list.html"; 
		 }
	//Correccion
		@RequestMapping(value="/add", method=RequestMethod.POST) 
		public String processAddSubmit(@ModelAttribute("nadador") Nadador nadador,BindingResult bindingResult) {
			 NadadorValidator nadadorValidator = new NadadorValidator();
			 nadadorValidator.validate(nadador, bindingResult);
			 if (bindingResult.hasErrors()) 
				return "nadador/add";
			 nadadorDao.addNadador(nadador);
			 return "redirect:list.html";
		 }*/
}

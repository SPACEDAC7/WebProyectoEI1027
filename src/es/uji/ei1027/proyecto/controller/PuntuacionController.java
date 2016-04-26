package es.uji.ei1027.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.proyecto.dao.PuntuacionDao;
import es.uji.ei1027.proyecto.domain.Puntuacion;
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
	public String listPuntuaciones(Model model){
		model.addAttribute("puntuaciones", puntuacionDao.getPuntuaciones());
		return "puntuacion/list";
	}
	
	//Añadir	
	@RequestMapping(value="/add") 
	public String addPuntuacion(Model model) {
		model.addAttribute("puntuacion", new Puntuacion());
		return "puntuacion/add";
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
	public String editPuntuacion(Model model, @PathVariable int id_puntuacion) {
		model.addAttribute("puntuacion", puntuacionDao.getPuntuacion(id_puntuacion));
		return "puntuacion/update"; 
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
	public String processDelete(@PathVariable int id_puntuacion) {
		puntuacionDao.deletePuntuacion(id_puntuacion);
		return "redirect:../list.html"; 
	}
}

package es.uji.ei1027.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.proyecto.dao.RespuestaPuntuacionDao;
import es.uji.ei1027.proyecto.domain.RespuestaPuntuacion;
import es.uji.ei1027.proyecto.validator.RespuestaPuntuacionValidator;

@Controller
@RequestMapping("/respuestaPuntuacion")
public class RespuestaPuntuacionController {
	private RespuestaPuntuacionDao respuestaPuntuacionDao;
	
	@Autowired
	public void setRespuestaPuntuacionDao( RespuestaPuntuacionDao respuesaPuntuacionDao){
		this.respuestaPuntuacionDao = respuesaPuntuacionDao;
	}
	//Listar
	@RequestMapping("/list")
	public String listRespuestasPuntuaciones(Model model){
		model.addAttribute("respuestasPuntuaciones", respuestaPuntuacionDao.getRespuestasPuntuaciones());
		return "respuestaPuntuacion/list";
	}
	
	//A�adir	
	@RequestMapping(value="/add") 
	public String addRespuestaPuntuacion(Model model) {
		RespuestaPuntuacion respuesta = new RespuestaPuntuacion();
		respuesta.setId_respuesta(respuestaPuntuacionDao.nuevoIdRespuestaPuntuacion());
		model.addAttribute("respuestaPuntuacion", respuesta);
		return "respuestaPuntuacion/add";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("respuestaPuntuacion") RespuestaPuntuacion respuesta_puntuacion,
			BindingResult bindingResult) { 
		RespuestaPuntuacionValidator respuestaPuntuacionValidator = new RespuestaPuntuacionValidator();
		respuestaPuntuacionValidator.validate(respuesta_puntuacion, bindingResult); 
		if (bindingResult.hasErrors())
			return "respuestaPuntuacion/add";
		respuestaPuntuacionDao.addRespuestaPuntuacion(respuesta_puntuacion);
		return "redirect:list.html";
	}
	//Actualizar	
	@RequestMapping(value="/update/{id_respuesta}", method = RequestMethod.GET)
	public String editRespuestaPuntuacion(Model model, @PathVariable int id_respuesta) {
		model.addAttribute("respuestaPuntuacion", respuestaPuntuacionDao.getRespuestaPuntuacion(id_respuesta));
		return "respuestaPuntuacion/update"; 
	}

	@RequestMapping(value="/update/{id_respuesta}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable int id_respuesta, 
			@ModelAttribute("respuestaPuntuacion") RespuestaPuntuacion respuesta_puntuacion, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) 
			return "respuestaPuntuacion/update";
		respuestaPuntuacionDao.updateRespuestaPuntuacion(respuesta_puntuacion);
		return "redirect:../list.html"; 
	}

	//Borrar	
	@RequestMapping(value="/delete/{id_respuesta}")
	public String processDelete(@PathVariable int id_respuesta) {
		respuestaPuntuacionDao.deleteRespuestaPuntuacion(id_respuesta);
		return "redirect:../list.html"; 
	}
}

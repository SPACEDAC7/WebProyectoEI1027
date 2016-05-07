package es.uji.ei1027.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.proyecto.dao.ServicioDao;
import es.uji.ei1027.proyecto.dao.UsuarioDao;
import es.uji.ei1027.proyecto.domain.Servicio;
import es.uji.ei1027.proyecto.domain.Usuario;
import es.uji.ei1027.proyecto.validator.ServicioValidator;
import es.uji.ei1027.proyecto.validator.UsuarioValidator;

@Controller
@RequestMapping("/servicio")
public class ServicioController {
	private ServicioDao servicioDao;
	
	@Autowired
	public void setServicioDao( ServicioDao servicioDao){
		this.servicioDao = servicioDao;
	}
	
	//Listar
	@RequestMapping("/list")
	public String listServicios(Model model){
		model.addAttribute("servicios", servicioDao.getServicios());
		return "servicio/list";
	}
	
	//Anadir	
	@RequestMapping(value="/add") 
	public String addServicio(Model model) {
		Servicio servicio = new Servicio();
		servicio.setIdServicio(servicioDao.nuevoIdServicio());
		model.addAttribute("servicio", servicio);
		return "servicio/add";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("servicio") Servicio servicio,
			BindingResult bindingResult) { 
		ServicioValidator servicioValidator = new ServicioValidator();
		servicioValidator.validate(servicio, bindingResult); 
		if (bindingResult.hasErrors())
			return "servicio/add";
		servicioDao.addServicio(servicio);
		return "redirect:list.html";
	}
	//Actualizar	
	@RequestMapping(value="/update/{id_servicio}", method = RequestMethod.GET)
	public String editServicio(Model model, @PathVariable int id_servicio) {
		Servicio servicio = servicioDao.getServicio(id_servicio);
		model.addAttribute("servicio", servicio);
		return "servicio/update"; 
	}

	@RequestMapping(value="/update/{id_servicio}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable int id_servicio, 
			@ModelAttribute("servicio") Servicio servicio, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) 
			return "servicio/update";
		servicioDao.updateServicio(servicio);
		return "redirect:../list.html"; 
	}

	//Borrar	
	@RequestMapping(value="/delete/{id_servicio}")
	public String deleteServicio(@PathVariable int id_servicio) {
		servicioDao.deleteServicio(id_servicio);
		return "redirect:../list.html"; 
	}

}

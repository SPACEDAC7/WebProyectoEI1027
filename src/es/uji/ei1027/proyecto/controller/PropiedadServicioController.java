package es.uji.ei1027.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.proyecto.dao.PropiedadServicioDao;
import es.uji.ei1027.proyecto.domain.PropiedadServicio;
import es.uji.ei1027.proyecto.validator.PropiedadServicioValidator;

@Controller
@RequestMapping("/propiedadServicio")
public class PropiedadServicioController {
private PropiedadServicioDao propiedadServicioDao;
	
	@Autowired
	public void setPropiedadServicioDao( PropiedadServicioDao propiedadPuntuacionDao){
		this.propiedadServicioDao = propiedadPuntuacionDao;
	}
	//Listar
	@RequestMapping("/list")
	public String listPropiedadesServicios(Model model){
		model.addAttribute("propiedadesServicios", propiedadServicioDao.getPropiedadesServicios());
		return "propiedadServicio/list";
	}
	
	//A�adir	
	@RequestMapping(value="/add") 
	public String addPropiedadServicio(Model model) {
		model.addAttribute("propiedadServicio", new PropiedadServicio());
		return "propiedadServicio/add";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("propiedadServicio") PropiedadServicio propiedadServicio,
			BindingResult bindingResult) { 
		PropiedadServicioValidator propiedadServicioValidator = new PropiedadServicioValidator();
		propiedadServicioValidator.validate(propiedadServicio, bindingResult); 
		if (bindingResult.hasErrors())
			return "propiedadServicio/add";
		propiedadServicioDao.addPropiedadServicio(propiedadServicio);
		return "redirect:list.html";
	}
	//Actualizar	
	@RequestMapping(value="/update/{id_propiedad}&{id_servicio}", method = RequestMethod.GET)
	public String editPropiedadServicio(Model model, @PathVariable int id_propiedad, @PathVariable int id_servicio) {
		model.addAttribute("propiedadServicio", propiedadServicioDao.getPropiedadServicio(id_propiedad, id_servicio));
		return "propiedadServicio/update"; 
	}

	@RequestMapping(value="/update/{id_propiedad}&{id_servicio}", method = RequestMethod.POST) 
	public String processUpdateSubmit( @PathVariable int id_propiedad, @PathVariable int id_servicio, 
			@ModelAttribute("propiedadServicio") PropiedadServicio propiedadServicio, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) 
			return "propiedadServicio/update";
		propiedadServicioDao.updatePropiedadServicio(propiedadServicio);
		return "redirect:../list.html"; 
	}

	//Borrar	
	@RequestMapping(value="/delete/{id_propiedad}&{id_servicio}")
	public String processDelete(@PathVariable int id_propiedad,@PathVariable int id_servicio) {
		propiedadServicioDao.deletePropiedadServicio(id_propiedad, id_servicio);
		return "redirect:../list.html"; 
	}
}

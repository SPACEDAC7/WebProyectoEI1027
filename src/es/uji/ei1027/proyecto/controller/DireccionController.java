package es.uji.ei1027.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.proyecto.dao.DireccionDao;
import es.uji.ei1027.proyecto.domain.Direccion;
import es.uji.ei1027.proyecto.validator.DireccionValidator;

@Controller
@RequestMapping("/direccion")
public class DireccionController {
	private DireccionDao direccionDao;
	
	@Autowired
	public void setDireccionDao( DireccionDao direccionDao){
		this.direccionDao=direccionDao;
	}
	
	//Listar
	@RequestMapping("/list")
	public String listCredenciales(Model model){
		model.addAttribute("direcciones", direccionDao.getDirecciones());
		return "direccion/list";
	}
		
	//A�adir	
	@RequestMapping(value="/add") 
	public String addNadador(Model model) {
		Direccion dir = new Direccion();
		dir.setId_direccion(direccionDao.nuevoIdDireccion());
		model.addAttribute("direccion", dir);
		return "direccion/add";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("direccion") Direccion direccion,
	                                BindingResult bindingResult) { 
		DireccionValidator direccionValidator = new DireccionValidator();
		direccionValidator.validate(direccion, bindingResult); 
		if (bindingResult.hasErrors())
				return "direccion/add";
		 direccionDao.addDireccion(direccion);
		 return "redirect:list.html";
	 }
	
	//Actualizar	
	@RequestMapping(value="/update/{id_direccion}", method = RequestMethod.GET)
	public String editDireccion(Model model, @PathVariable int id_direccion) {
		model.addAttribute("direccion", direccionDao.getDireccion(id_direccion));
		return "direccion/update"; 
	}
			
	@RequestMapping(value="/update/{id_direccion}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable int id_direccion, 
                            @ModelAttribute("direccion") Direccion direccion, 
                            BindingResult bindingResult) {
		 if (bindingResult.hasErrors()) 
			 return "direccion/update";
		 direccionDao.updateDireccion(direccion);
		 return "redirect:../list.html"; 
	  }
			
	//Borrar	
	@RequestMapping(value="/delete/{id_direccion}")
	 public String processDelete(@PathVariable int id_direccion) {
		direccionDao.deleteDireccion(id_direccion);
	    return "redirect:../list.html"; 
	 }
			 
	
}

package es.uji.ei1027.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.proyecto.dao.PeriodoDao;
import es.uji.ei1027.proyecto.domain.Periodo;
import es.uji.ei1027.proyecto.validator.PeriodoValidator;

@Controller
@RequestMapping("/periodo")
public class PeriodoController {
	private PeriodoDao periodoDao;
	
	@Autowired
	public void setPeriodoDao( PeriodoDao periodoDao){
		this.periodoDao = periodoDao;
	}
	
	//Listar
	@RequestMapping("/list")
	public String listPeriodo(Model model){
		model.addAttribute("periodos", periodoDao.getPeriodos());
		return "periodo/list";
	}
	
	//Añadir	
	@RequestMapping(value="/add") 
	public String addPeriodo(Model model) {
		model.addAttribute("periodo", new Periodo());
		return "periodo/add";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("periodo") Periodo periodo,
			BindingResult bindingResult) { 
		PeriodoValidator periodoValidator = new PeriodoValidator();
		periodoValidator.validate(periodo, bindingResult); 
		if (bindingResult.hasErrors())
			return "periodo/add";
		periodoDao.addPeriodo(periodo);
		return "redirect:list.html";
	}
	//Actualizar	
	@RequestMapping(value="/update/{id_periodo}", method = RequestMethod.GET)
	public String editPeriodo(Model model, @PathVariable int id_periodo) {
		model.addAttribute("periodo", periodoDao.getPeriodo(id_periodo));
		return "periodo/update"; 
	}

	@RequestMapping(value="/update/{id_periodo}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable int id_periodo, 
			@ModelAttribute("periodo") Periodo periodo, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) 
			return "periodo/update";
		periodoDao.updatePeriodo(periodo);
		return "redirect:../list.html"; 
	}

	//Borrar	
	@RequestMapping(value="/delete/{id_periodo}")
	public String processDelete(@PathVariable int id_periodo) {
		periodoDao.deletePeriodo(id_periodo);
		return "redirect:../list.html"; 
	}
}

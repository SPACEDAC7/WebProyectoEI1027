package es.uji.ei1027.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.proyecto.dao.FacturaDao;
import es.uji.ei1027.proyecto.domain.Factura;
import es.uji.ei1027.proyecto.validator.FacturaValidator;

@Controller
@RequestMapping("/factura")
public class FacturaController {
	private FacturaDao facturaDao;

	@Autowired
	public void setFacturaDao( FacturaDao facturaDao){
		this.facturaDao = facturaDao;
	}
	//Listar
	@RequestMapping("/list")
	public String listFacturas(Model model){
		model.addAttribute("facturas", facturaDao.getFacturas());
		return "factura/list";
	}

	//A�adir	
	@RequestMapping(value="/add") 
	public String addFactura(Model model) {
		Factura factura = new Factura();
		factura.setId_factura(facturaDao.nuevoIdFactura());
		model.addAttribute("factura", factura);
		return "factura/add";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("factura") Factura factura,
			BindingResult bindingResult) { 
		FacturaValidator facturaValidator = new FacturaValidator();
		facturaValidator.validate(factura, bindingResult); 
		if (bindingResult.hasErrors())
			return "factura/add";
		factura.crearFecha(factura.getDia(), factura.getMes()-1, factura.getAno());
		facturaDao.addFactura(factura);
		return "redirect:list.html";
	}
	//Actualizar	
	@RequestMapping(value="/update/{id_factura}", method = RequestMethod.GET)
	public String editFactura(Model model, @PathVariable int id_factura) {
		model.addAttribute("factura", facturaDao.getFactura(id_factura));
		return "factura/update"; 
	}

	@RequestMapping(value="/update/{id_factura}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable int id_factura, 
			@ModelAttribute("factura") Factura factura, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) 
			return "factura/update";
		factura.crearFecha(factura.getDia(), factura.getMes()-1, factura.getAno());
		facturaDao.updateFactura(factura);
		return "redirect:../list.html"; 
	}

	//Borrar	
	@RequestMapping(value="/delete/{id_factura}")
	public String processDelete(@PathVariable int id_factura) {
		facturaDao.deleteFactura(id_factura);
		return "redirect:../list.html"; 
	}
}

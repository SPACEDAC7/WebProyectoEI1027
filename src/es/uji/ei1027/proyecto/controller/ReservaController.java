package es.uji.ei1027.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.proyecto.dao.ReservaDao;
import es.uji.ei1027.proyecto.domain.Reserva;
import es.uji.ei1027.proyecto.validator.ReservaValidator;

@Controller
@RequestMapping("/reserva")
public class ReservaController {
private ReservaDao reservaDao;
	
	@Autowired
	public void setReservaDao( ReservaDao reservaDao){
		this.reservaDao = reservaDao;
	}
	//Listar
	@RequestMapping("/list")
	public String listReservas(Model model){
		model.addAttribute("reservas", reservaDao.getReservas());
		return "reserva/list";
	}
	
	//A�adir	
	@RequestMapping(value="/add") 
	public String addReserva(Model model) {
		model.addAttribute("reserva", new Reserva());
		return "reserva/add";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("reserva") Reserva reserva,
			BindingResult bindingResult) { 
		ReservaValidator reservaValidator = new ReservaValidator();
		reservaValidator.validate(reserva, bindingResult); 
		if (bindingResult.hasErrors())
			return "reserva/add";
		reservaDao.addReserva(reserva);
		return "redirect:list.html";
	}
	//Actualizar	
	@RequestMapping(value="/update/{id_reserva}", method = RequestMethod.GET)
	public String editReserva(Model model, @PathVariable int id_reserva) {
		model.addAttribute("reserva", reservaDao.getReserva(id_reserva));
		return "reserva/update"; 
	}

	@RequestMapping(value="/update/{id_reserva}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable int id_reserva, 
			@ModelAttribute("reserva") Reserva reserva, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) 
			return "reserva/update";
		reservaDao.updateReserva(reserva);
		return "redirect:../list.html"; 
	}

	//Borrar	
	@RequestMapping(value="/delete/{id_reserva}")
	public String processDelete(@PathVariable int id_reserva) {
		reservaDao.deleteReserva(id_reserva);
		return "redirect:../list.html"; 
	}
}

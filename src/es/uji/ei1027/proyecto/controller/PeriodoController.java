package es.uji.ei1027.proyecto.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.proyecto.dao.PeriodoDao;
import es.uji.ei1027.proyecto.domain.Credencial;
import es.uji.ei1027.proyecto.domain.Direccion;
import es.uji.ei1027.proyecto.domain.Periodo;
import es.uji.ei1027.proyecto.domain.Usuario;
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
	public String listPeriodo(Model model, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:periodo/list.html");
			retorno =  "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				model.addAttribute("periodos", periodoDao.getPeriodos());
				retorno = "periodo/list";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}
	
	//A�adir	
	@RequestMapping(value="/add") 
	public String addPeriodo(Model model, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:periodo/add.html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				Periodo periodo = new Periodo();
				periodo.setId_periodo(periodoDao.nuevoIdPeriodo());
				model.addAttribute("periodo", periodo);
				model.addAttribute("fechas");
				retorno = "periodo/add";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}

	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("periodo") Periodo periodo,
			BindingResult bindingResult) { 
		PeriodoValidator periodoValidator = new PeriodoValidator();
		periodoValidator.validate(periodo, bindingResult);
		if (bindingResult.hasErrors())
			return "periodo/add";
		periodo.crearFechas();
		periodoDao.addPeriodo(periodo);
		return "redirect:list.html";
	}
	//Actualizar	
	@RequestMapping(value="/update/{id_periodo}", method = RequestMethod.GET)
	public String editPeriodo(Model model, @PathVariable int id_periodo, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:periodo/update/" + id_periodo + ".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				Periodo periodo = periodoDao.getPeriodo(id_periodo);
				//Convierto fechas de tipo Date a tipo dd/mm/aaaa para que se muestren en la página de update
				periodo.convertirDateADiaMesAno();
				model.addAttribute("periodo", periodo);
				retorno = "periodo/update";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}

	@RequestMapping(value="/update/{id_periodo}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable int id_periodo, 
			@ModelAttribute("periodo") Periodo periodo, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) 
			return "periodo/update";
		periodo.crearFechas();
		periodoDao.updatePeriodo(periodo);
		return "redirect:../list.html"; 
	}

	//Borrar	
	@RequestMapping(value="/delete/{id_periodo}")
	public String processDelete(@PathVariable int id_periodo, HttpSession session, Model model) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:periodo/delete/" + id_periodo + ".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				periodoDao.deletePeriodo(id_periodo);
			    retorno = "redirect:../list.html";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}
}

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

import es.uji.ei1027.proyecto.dao.FacturaDao;
import es.uji.ei1027.proyecto.domain.Credencial;
import es.uji.ei1027.proyecto.domain.Factura;
import es.uji.ei1027.proyecto.domain.Usuario;
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
	public String listFacturas(Model model, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:factura/list.html");
			retorno =  "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				model.addAttribute("facturas", facturaDao.getFacturas());
				retorno = "factura/list";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}

	//A�adir	
	@RequestMapping(value="/add") 
	public String addFactura(Model model, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:factura/add.html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				Factura factura = new Factura();
				factura.setId_factura(facturaDao.nuevoIdFactura());
				model.addAttribute("factura", factura);
				retorno = "factura/add";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}

	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("factura") Factura factura,
			BindingResult bindingResult) { 
		FacturaValidator facturaValidator = new FacturaValidator();
		facturaValidator.validate(factura, bindingResult); 
		if (bindingResult.hasErrors())
			return "factura/add";
		System.out.println("Fecha que recoge del string " + factura.getFechaString());
		factura.crearFecha();
		//factura.crearFecha(factura.getDia(), factura.getMes()-1, factura.getAno());
		facturaDao.addFactura(factura);
		return "redirect:list.html";
	}
	//Actualizar	
	@RequestMapping(value="/update/{id_factura}", method = RequestMethod.GET)
	public String editFactura(HttpSession session, Model model, @PathVariable int id_factura) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:factura/update/" + id_factura + ".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				model.addAttribute("factura", facturaDao.getFactura(id_factura));
				retorno = "factura/update";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}

	@RequestMapping(value="/update/{id_factura}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable int id_factura, 
			@ModelAttribute("factura") Factura factura, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) 
			return "factura/update";
		factura.crearFecha();
		facturaDao.updateFactura(factura);
		return "redirect:../list.html"; 
	}

	//Borrar	
	@RequestMapping(value="/delete/{id_factura}")
	public String processDelete(HttpSession session, Model model, @PathVariable int id_factura) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:factura/delete/" + id_factura + ".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				facturaDao.deleteFactura(id_factura);
			    retorno = "redirect:../list.html";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;  
	}
}

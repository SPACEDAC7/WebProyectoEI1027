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

import es.uji.ei1027.proyecto.dao.DireccionDao;
import es.uji.ei1027.proyecto.dao.PropiedadDao;
import es.uji.ei1027.proyecto.domain.Buscador;
import es.uji.ei1027.proyecto.domain.Credencial;
import es.uji.ei1027.proyecto.domain.Direccion;
import es.uji.ei1027.proyecto.domain.Propiedad;
import es.uji.ei1027.proyecto.domain.Usuario;
import es.uji.ei1027.proyecto.validator.PropiedadValidator;


@Controller
@RequestMapping("/buscador")
public class BuscadorController {
private PropiedadDao propiedadDao;
	
	@Autowired
	public void setPropiedadDao( PropiedadDao propiedadDao){
		this.propiedadDao = propiedadDao;
	}
	//Listar
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String listPropiedades(Model model, HttpSession session){
		String retorno;	
		Propiedad propiedad = new Propiedad();
		Buscador buscador = new Buscador();
		model.addAttribute("buscador", buscador);
		model.addAttribute("propiedades", propiedadDao.getPropiedades());
		retorno = "buscador/list";
		return retorno;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public String listPropiedadesFiltradas(@ModelAttribute("buscador") Buscador buscador, Model model, HttpSession session) {
		String retorno;	
		Propiedad propiedad = new Propiedad();
		model.addAttribute("buscador", buscador);
		model.addAttribute("propiedades", propiedadDao.obtenerPropiedadesPorFiltro(buscador));
		retorno = "buscador/list";
		return retorno;
	}
}

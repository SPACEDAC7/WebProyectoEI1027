package es.uji.ei1027.proyecto.controller;

import javax.servlet.http.HttpSession;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.proyecto.dao.PropiedadDao;
import es.uji.ei1027.proyecto.domain.Buscador;
import es.uji.ei1027.proyecto.domain.Propiedad;

@Controller
@RequestMapping("/cabecera")
public class CabeceraController {
   
private PropiedadDao propiedadDao;
	
	@Autowired
	public void setPropiedadDao( PropiedadDao propiedadDao){
		this.propiedadDao = propiedadDao;
	}
	@RequestMapping("/inicio")
	public String iniciar(Model model){
		model.addAttribute("buscador",new Buscador());
		return "cabecera/inicio";
	}
	
	@RequestMapping(value="/inicio", method = RequestMethod.POST)
	public String buscar(@ModelAttribute("buscador") Buscador buscador, Model model, HttpSession session){
		String retorno;	
		Propiedad propiedad = new Propiedad();
		model.addAttribute("buscador", buscador);
		model.addAttribute("propiedades", propiedadDao.obtenerPropiedadesPorFiltro(buscador));
		retorno = "buscador/list";
		return retorno;
	}
	
	@RequestMapping("/contacta")
	public String contactar(Model model){
		return "cabecera/contacta";
	}
	
	@RequestMapping("/nosotros")
	public String nosotros(Model model){
		return "cabecera/nosotros";
	}
}

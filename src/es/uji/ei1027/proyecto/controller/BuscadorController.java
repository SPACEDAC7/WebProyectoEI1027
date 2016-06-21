package es.uji.ei1027.proyecto.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
import es.uji.ei1027.proyecto.dao.ImagenDao;
import es.uji.ei1027.proyecto.dao.PropiedadDao;
import es.uji.ei1027.proyecto.domain.Buscador;
import es.uji.ei1027.proyecto.domain.Credencial;
import es.uji.ei1027.proyecto.domain.Direccion;
import es.uji.ei1027.proyecto.domain.Imagen;
import es.uji.ei1027.proyecto.domain.Propiedad;
import es.uji.ei1027.proyecto.domain.Usuario;
import es.uji.ei1027.proyecto.validator.PropiedadValidator;


@Controller
@RequestMapping("/buscador")
public class BuscadorController {
private PropiedadDao propiedadDao;
private ImagenDao imagenDao;
private DireccionDao direccionDao;
	
	@Autowired
	public void setPropiedadDao( PropiedadDao propiedadDao){
		this.propiedadDao = propiedadDao;
	}
	
	@Autowired
	public void setImagenDao( ImagenDao propiedadDao){
		this.imagenDao = propiedadDao;
	}
	
	@Autowired
	public void setDireccionDao( DireccionDao propiedadDao){
		this.direccionDao = propiedadDao;
	}
	//Listar
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String listPropiedades(Model model, HttpSession session){
		String retorno;	
		Propiedad propiedad = new Propiedad();
		Buscador buscador = new Buscador();
		List<Direccion> direccionesFinales = new LinkedList<Direccion>();
		List<Imagen> imagenesFinales = new LinkedList<Imagen>();
		for(Propiedad p : propiedadDao.getPropiedades()){
			List<Imagen> aux = imagenDao.getImagenesPropiedad(p.getId_propiedad());
			direccionesFinales.add(direccionDao.getDireccion(p.getId_direccion()));
			if(aux.size()!= 0){
				imagenesFinales.add(aux.get(0));
			}
		}
		model.addAttribute("buscador", buscador);
		model.addAttribute("propiedades", propiedadDao.getPropiedades());
		model.addAttribute("direccion", direccionesFinales);
		model.addAttribute("imagenPropiedad", imagenesFinales);
		retorno = "buscador/list";
		return retorno;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public String listPropiedadesFiltradas(@ModelAttribute("buscador") Buscador buscador, Model model, HttpSession session) {
		String retorno;	
		Propiedad propiedad = new Propiedad();
		List<Direccion> direccionesFinales = new LinkedList<Direccion>();
		List<Imagen> imagenesFinales = new LinkedList<Imagen>();
		for(Propiedad p : propiedadDao.obtenerPropiedadesPorFiltro(buscador)){
			List<Imagen> aux = imagenDao.getImagenesPropiedad(p.getId_propiedad());
			direccionesFinales.add(direccionDao.getDireccion(p.getId_direccion()));
			if(aux.size()!= 0){
				imagenesFinales.add(aux.get(0));
			}
		}
		model.addAttribute("buscador", buscador);
		model.addAttribute("propiedades", propiedadDao.obtenerPropiedadesPorFiltro(buscador));
		model.addAttribute("direccion", direccionesFinales);
		model.addAttribute("imagenPropiedad", imagenesFinales);
		retorno = "buscador/list";
		return retorno;
	}
}

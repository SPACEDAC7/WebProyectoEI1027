package es.uji.ei1027.proyecto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
import es.uji.ei1027.proyecto.dao.UsuarioDao;
import es.uji.ei1027.proyecto.domain.Credencial;
import es.uji.ei1027.proyecto.domain.Direccion;
import es.uji.ei1027.proyecto.domain.MensajeError;
import es.uji.ei1027.proyecto.domain.Propiedad;
import es.uji.ei1027.proyecto.domain.Usuario;
import es.uji.ei1027.proyecto.validator.PropiedadValidator;

@Controller
@RequestMapping("/propiedad")
public class PropiedadController {
private PropiedadDao propiedadDao;
private DireccionDao direccionDao;
private UsuarioDao usuarioDao;
	
	@Autowired
	public void setPropiedadDao( PropiedadDao propiedadDao){
		this.propiedadDao = propiedadDao;
	}
	
	@Autowired
	public void setDireccionDao(DireccionDao direccionDao){
		this.direccionDao = direccionDao;
	}
	
	@Autowired
	public void setUsuarioDao(UsuarioDao usuarioDao){
		this.usuarioDao = usuarioDao;
	}
	//Listar
	@RequestMapping("/list")
	public String listPropiedades(Model model, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:propiedad/list.html");
			retorno =  "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				model.addAttribute("propiedades", propiedadDao.getPropiedades());
				retorno = "propiedad/list";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}
	
	@RequestMapping("/misPropiedades")
	public String listarMisPropiedades(Model model, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		Map<Propiedad, Direccion> mapPropiedadesDirecciones = new HashMap<Propiedad, Direccion>();
		for (Propiedad propiedad: propiedadDao.obtenerPropiedadesPorUsuario(usuario.getId_usuario())) {
			mapPropiedadesDirecciones.put(propiedad, direccionDao.getDireccion(propiedad.getId_direccion()));
		}
		model.addAttribute("listaPropiedadesDirecciones", mapPropiedadesDirecciones);
		return "propiedad/misPropiedades";
	}
	
	//A�adir	
	@RequestMapping(value="/add") 
	public String addPropiedad(Model model, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:propiedad/add.html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				Propiedad propiedad = new Propiedad();
				propiedad.setId_propiedad(propiedadDao.nuevoIdPropiedad());
				model.addAttribute("propiedad", propiedad);
				retorno = "propiedad/add";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}

	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("propiedad") Propiedad propiedad,
			BindingResult bindingResult) { 
		PropiedadValidator propiedadValidator = new PropiedadValidator();
		propiedadValidator.validate(propiedad, bindingResult); 
		if (bindingResult.hasErrors())
			return "propiedad/add";
		propiedadDao.addPropiedad(propiedad);
		return "redirect:list.html";
	}
	//Actualizar	
	@RequestMapping(value="/update/{id_propiedad}", method = RequestMethod.GET)
	public String editPropiedad(Model model, @PathVariable int id_propiedad, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:propiedad/update/" + id_propiedad + ".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				model.addAttribute("propiedad", propiedadDao.getPropiedad(id_propiedad));
				retorno = "propiedad/update";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno; 
	}

	@RequestMapping(value="/update/{id_propiedad}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable int id_propiedad, 
			@ModelAttribute("propiedad") Propiedad propiedad, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) 
			return "propiedad/update";
		propiedadDao.updatePropiedad(propiedad);
		return "redirect:../list.html"; 
	}

	//Borrar	
	@RequestMapping(value="/delete/{id_propiedad}")
	public String processDelete(@PathVariable int id_propiedad, HttpSession session, Model model) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:propiedad/delete/" + id_propiedad + ".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				propiedadDao.deletePropiedad(id_propiedad);
			    retorno = "redirect:../list.html";
			} else if (rol.equals("propietario")){
				int idUsuarioAutenticado = usuario.getId_usuario();
				Propiedad supuestaPropiedadUsuario = propiedadDao.getPropiedad(id_propiedad);
				if (supuestaPropiedadUsuario.getId_usuario() == idUsuarioAutenticado) {
					int estadoBorradoPropiedad = propiedadDao.deletePropiedad(id_propiedad);
					if (estadoBorradoPropiedad != 0) {
						MensajeError mensajeError = new MensajeError("Error al eliminar la propiedad porqué está asociada a una o más reservas");
						session.setAttribute("mensajeError", mensajeError);
						retorno = "redirect:../../error/mostrarError.html";
					}
					else
						retorno = "redirect:../misPropiedades.html";
				} else {
					retorno = "redirect:../cabecera/inicio.jsp";
				}
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../cabecera/inicio.jsp";
			}
		}
		return retorno; 
	}
	
	@RequestMapping(value="/single/{id_propiedad}")
	public String processDetails(@PathVariable int id_propiedad , HttpSession session, Model model){
		model.addAttribute("propiedad", propiedadDao.getPropiedad(id_propiedad));
		model.addAttribute("direccion", direccionDao.getDireccion(propiedadDao.getPropiedad(id_propiedad).getId_direccion()));
		model.addAttribute("usuarioPropiedad", usuarioDao.getUsuario(propiedadDao.getPropiedad(id_propiedad).getId_propiedad()));
		return "propiedad/single";
	}
	
	
	
	
}

package es.uji.ei1027.proyecto.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.proyecto.dao.CredencialDao;
import es.uji.ei1027.proyecto.dao.DireccionDao;
import es.uji.ei1027.proyecto.dao.ImagenDao;
import es.uji.ei1027.proyecto.dao.PropiedadDao;
import es.uji.ei1027.proyecto.dao.UsuarioDao;
import es.uji.ei1027.proyecto.domain.Credencial;
import es.uji.ei1027.proyecto.domain.Direccion;
import es.uji.ei1027.proyecto.domain.MensajeError;
import es.uji.ei1027.proyecto.domain.Propiedad;
import es.uji.ei1027.proyecto.domain.Usuario;
import es.uji.ei1027.proyecto.validator.DireccionValidator;
import es.uji.ei1027.proyecto.validator.PropiedadValidator;

@Controller
@RequestMapping("/propiedad")
public class PropiedadController {
private PropiedadDao propiedadDao;
private DireccionDao direccionDao;
private UsuarioDao usuarioDao;
private ImagenDao imagenDao;
private CredencialDao credencialDao;
	
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
	
	@Autowired
	public void setImagenDao(ImagenDao imagenDao){
		this.imagenDao = imagenDao;
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
		if (usuario != null) {
			String rol = (String) session.getAttribute("rol");
			if (rol.equals("administrador") || rol.equals("propietario")) {
				Map<Propiedad, Direccion> mapPropiedadesDirecciones = new HashMap<Propiedad, Direccion>();
				for (Propiedad propiedad: propiedadDao.obtenerPropiedadesPorUsuario(usuario.getId_usuario())) {
					mapPropiedadesDirecciones.put(propiedad, direccionDao.getDireccion(propiedad.getId_direccion()));
				}
				model.addAttribute("listaPropiedadesDirecciones", mapPropiedadesDirecciones);
				return "propiedad/misPropiedades";
			}
		}
		model.addAttribute("credencial", new Credencial());
		session.setAttribute("nextURL", "redirect:propiedad/add.html");
		return "login";
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
	
	@RequestMapping(value="/anadirPropiedadPropietario")
	public String addPropiedadPropietario(Model model, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:propiedad/anadirPropiedadPropietario.html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("propietario") ) {
				Propiedad propiedad = new Propiedad();
				model.addAttribute("nuevaPropiedadPropietario", propiedad);
				retorno = "propiedad/addPropietario";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}
	
	@RequestMapping(value="/anadirDireccionAPropiedad", method=RequestMethod.POST)
	public String addDireccionAPropiedad(Model model, @ModelAttribute("nuevaPropiedadPropietario") Propiedad propiedad,
			BindingResult bindingResult, HttpSession session) {
		PropiedadValidator propiedadValidator = new PropiedadValidator();
		propiedadValidator.validate(propiedad, bindingResult); 
		if (bindingResult.hasErrors())
			return "propiedad/addPropietario";
		session.setAttribute("nuevaPropiedadPropietario", propiedad);
		Direccion direccion = new Direccion();
		model.addAttribute("nuevaDireccionPropietario", direccion);
		return "propiedad/addDireccionPropiedad";
	}
	
	@RequestMapping(value="/finalizarAnadirPropiedad", method=RequestMethod.POST)
	public String finalizarAnadirPropiedad(@ModelAttribute("nuevaDireccionPropietario") Direccion direccion, BindingResult bindingResult, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		DireccionValidator direccionValidator = new DireccionValidator();
		direccionValidator.validate(direccion, bindingResult);
		if (bindingResult.hasErrors())
			return "propiedad/addDireccionPropiedad";
		Propiedad propiedad = (Propiedad) session.getAttribute("nuevaPropiedadPropietario");
		propiedad.setId_propiedad(propiedadDao.nuevoIdPropiedad());
		propiedad.setId_usuario(usuario.getId_usuario());
		int nuevoIdDireccion = direccionDao.nuevoIdDireccion();
		direccion.setId_direccion(nuevoIdDireccion);
		propiedad.setId_direccion(nuevoIdDireccion);
		direccionDao.addDireccion(direccion);
		propiedadDao.addPropiedad(propiedad);
		return "redirect:misPropiedades.html";
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
			} else if (rol.equals("propietario")){
				int idUsuarioAutenticado = usuario.getId_usuario();
				Propiedad supuestaPropiedadUsuario = propiedadDao.getPropiedad(id_propiedad);
				if (supuestaPropiedadUsuario.getId_usuario() == idUsuarioAutenticado) {
					model.addAttribute("propiedadAModificar", supuestaPropiedadUsuario);
					Direccion direccion = direccionDao.getDireccion(supuestaPropiedadUsuario.getId_direccion());
					model.addAttribute("direccionAModificar", direccion);
					retorno = "propiedad/formModificarPropiedadUsuario";
				} else {
					retorno = "propiedad/misPropiedades";
				}
			} else {
				retorno = "redirect:../../cabecera/inicio.html";
			}
		}
		return retorno; 
	}
	
	@RequestMapping(value="/updatePropietario/{id_propiedad}", method = RequestMethod.GET)
	public String editPropiedadPropietario(Model model, @PathVariable int id_propiedad, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:propiedad/updatePropietario/" + id_propiedad + ".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("propietario") ) {
				
				Propiedad propiedadAModificar = (Propiedad) session.getAttribute("propiedadAModificar");
				if (propiedadAModificar == null) {
					propiedadAModificar = propiedadDao.getPropiedad(id_propiedad);
				} 
				model.addAttribute("propiedadAModificar", propiedadAModificar);
				Direccion direccionAModificar = direccionDao.getDireccion(propiedadAModificar.getId_direccion());
				session.setAttribute("propiedadAModificar", propiedadAModificar);
				session.setAttribute("direccionAModificar", direccionAModificar);
				retorno = "propiedad/formModificarPropiedadUsuario";
			} else {
				retorno = "redirect:../../cabecera/inicio.html";
			}
		}
		return retorno;
	}
	
	
	@RequestMapping(value="/updateDireccionPropietario", method = RequestMethod.POST)
	public String editDireccionPropiedadPropietario(Model model, HttpSession session,
			@ModelAttribute("propiedadAModificar") Propiedad propiedadModificada,
			BindingResult bindingResult) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:propiedad/misPropiedades.html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("propietario") ) {
				
				Propiedad propiedadSinModificar = (Propiedad) session.getAttribute("propiedadAModificar");
				propiedadModificada.setId_propiedad(propiedadSinModificar.getId_propiedad());
				propiedadModificada.setId_direccion(propiedadSinModificar.getId_direccion());
				propiedadModificada.setId_usuario(propiedadSinModificar.getId_usuario());
				
				PropiedadValidator propiedadValidator = new PropiedadValidator();
				propiedadValidator.validate(propiedadModificada, bindingResult); 
				if (bindingResult.hasErrors())
					return "propiedad/formModificarPropiedadUsuario";
				
				session.setAttribute("propiedadAModificar", propiedadModificada);
				
				//Cojo la direccion de la sesión y la mando a la vista
				Direccion direccionAModificar = (Direccion) session.getAttribute("direccionAModificar");
				model.addAttribute("direccionAModificar", direccionAModificar);
				retorno = "propiedad/formModificarDireccionPropiedad";
			} else {
				retorno = "redirect:../../cabecera/inicio.html";
			}
		}
		return retorno;
	}
	
	@RequestMapping(value="/finalizarModificarPropiedad", method=RequestMethod.POST)
	public String finalizarModificarPropiedad(@ModelAttribute("direccionAModificar") Direccion direccionModificada, 
			BindingResult bindingResult, HttpSession session) {
		Direccion direccionSinModificar = (Direccion) session.getAttribute("direccionAModificar");
		direccionModificada.setId_direccion(direccionSinModificar.getId_direccion());
		DireccionValidator direccionValidator = new DireccionValidator();
		direccionValidator.validate(direccionModificada, bindingResult);
		if (bindingResult.hasErrors())
			return "propiedad/formModificarDireccionPropiedad";
		
		
		
		Propiedad propiedadModificada = (Propiedad) session.getAttribute("propiedadAModificar");
		direccionDao.updateDireccion(direccionModificada);
		propiedadDao.updatePropiedad(propiedadModificada);
		session.removeAttribute("propiedadAModificar");
		session.removeAttribute("direccionAModificar");
		return "redirect:misPropiedades.html";
	}
	
	
	@RequestMapping(value="/updatePropietario/{id_propiedad}", method = RequestMethod.POST)
	public String processUpdateSubmitPropitario(Model model, @PathVariable int id_propiedad, HttpSession session,
			@ModelAttribute("propiedadAModificar") Propiedad propiedad, BindingResult bindingResult) {
		propiedad.setId_propiedad(id_propiedad);
		
		PropiedadValidator propiedadValidator = new PropiedadValidator();
		propiedadValidator.validate(propiedad, bindingResult); 
		if (bindingResult.hasErrors())
			return "propiedad/formModificarPropiedadUsuario";
		
		Propiedad propiedadModificada = propiedadDao.getPropiedad(id_propiedad);
		propiedadModificada.setArea(propiedad.getArea());
		propiedadModificada.setCapacidad(propiedad.getCapacidad());
		propiedadModificada.setDescripcion(propiedad.getDescripcion());
		propiedadModificada.setNum_camas(propiedad.getNum_camas());
		propiedadModificada.setNum_habitaciones(propiedad.getNum_habitaciones());
		propiedadModificada.setPrecio_propiedad(propiedad.getPrecio_propiedad());
		propiedadModificada.setTipo(propiedad.getTipo());
		propiedadModificada.setTitulo(propiedad.getTitulo());
		propiedadModificada.setUrl_mapa(propiedad.getUrl_mapa());
		
		propiedadDao.updatePropiedad(propiedadModificada);
		return "redirect:../misPropiedades.html";
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
						mensajeError.setMensaje(mensajeError.getMensaje().toUpperCase());
						MensajeError m = new MensajeError("../propiedad/misPropiedades.html");
						session.setAttribute("nextURL", m);
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
		model.addAttribute("imagenes", imagenDao.getImagenesPropiedad(id_propiedad));
		return "propiedad/single";
	}
	
	
	
	
}

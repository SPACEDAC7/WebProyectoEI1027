package es.uji.ei1027.proyecto.controller;

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

import es.uji.ei1027.proyecto.dao.PuntuacionDao;
import es.uji.ei1027.proyecto.dao.RespuestaPuntuacionDao;
import es.uji.ei1027.proyecto.dao.UsuarioDao;
import es.uji.ei1027.proyecto.domain.Credencial;
import es.uji.ei1027.proyecto.domain.Direccion;
import es.uji.ei1027.proyecto.domain.RespuestaPuntuacion;
import es.uji.ei1027.proyecto.domain.Usuario;
import es.uji.ei1027.proyecto.validator.RespuestaPuntuacionValidator;

@Controller
@RequestMapping("/respuestaPuntuacion")
public class RespuestaPuntuacionController {
	private RespuestaPuntuacionDao respuestaPuntuacionDao;
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private PuntuacionDao puntuacionDao;
	
	
	@Autowired
	public void setRespuestaPuntuacionDao( RespuestaPuntuacionDao respuesaPuntuacionDao){
		this.respuestaPuntuacionDao = respuesaPuntuacionDao;
	}
	//Listar
	@RequestMapping("/list")
	public String listRespuestasPuntuaciones(Model model, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:respuestaPuntuacion/list.html");
			retorno =  "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				model.addAttribute("respuestasPuntuaciones", respuestaPuntuacionDao.getRespuestasPuntuaciones());
				retorno = "respuestaPuntuacion/list";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}
	
	//A�adir	
	@RequestMapping(value="/add") 
	public String addRespuestaPuntuacion(Model model, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:respuestaPuntuacion/add.html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				RespuestaPuntuacion respuesta = new RespuestaPuntuacion();
				respuesta.setId_respuesta(respuestaPuntuacionDao.nuevoIdRespuestaPuntuacion());
				model.addAttribute("respuestaPuntuacion", respuesta);
				retorno = "respuestaPuntuacion/add";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}

	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("respuestaPuntuacion") RespuestaPuntuacion respuesta_puntuacion,
			BindingResult bindingResult) { 
		RespuestaPuntuacionValidator respuestaPuntuacionValidator = new RespuestaPuntuacionValidator();
		respuestaPuntuacionValidator.validate(respuesta_puntuacion, bindingResult); 
		if (bindingResult.hasErrors())
			return "respuestaPuntuacion/add";
		respuestaPuntuacionDao.addRespuestaPuntuacion(respuesta_puntuacion);
		return "redirect:list.html";
	}
	//Actualizar	
	@RequestMapping(value="/update/{id_respuesta}", method = RequestMethod.GET)
	public String editRespuestaPuntuacion(Model model, @PathVariable int id_respuesta, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:respuestaPuntuacion/update/" + id_respuesta + ".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				model.addAttribute("respuestaPuntuacion", respuestaPuntuacionDao.getRespuestaPuntuacion(id_respuesta));
				retorno = "respuestaPuntuacion/update";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}

	@RequestMapping(value="/update/{id_respuesta}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable int id_respuesta, 
			@ModelAttribute("respuestaPuntuacion") RespuestaPuntuacion respuesta_puntuacion, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) 
			return "respuestaPuntuacion/update";
		respuestaPuntuacionDao.updateRespuestaPuntuacion(respuesta_puntuacion);
		return "redirect:../list.html"; 
	}

	//Borrar	
	@RequestMapping(value="/delete/{id_respuesta}")
	public String processDelete(@PathVariable int id_respuesta, HttpSession session, Model model) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:respuestaPuntuacion/delete/" + id_respuesta + ".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				respuestaPuntuacionDao.deleteRespuestaPuntuacion(id_respuesta);
			    retorno = "redirect:../list.html";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}
	
	@RequestMapping(value="/listarPuntuacion/{id_puntuacion}")
	public String listarPuntuacion(@PathVariable int id_puntuacion, HttpSession session, Model model){
		List <RespuestaPuntuacion> respuestas = respuestaPuntuacionDao.getRespuestas(id_puntuacion);
		model.addAttribute("respuestas", respuestas);
		model.addAttribute("puntuacion",id_puntuacion);
		return "respuestaPuntuacion/listarPuntuacion";
	}
	
	//A�adir	
		@RequestMapping(value="/anadirRespuesta/{id_puntuacion}") 
		public String anadirRespuestaPuntuacion(@PathVariable int id_puntuacion, Model model, HttpSession session) {
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			String retorno;
			if (usuario == null) {
				model.addAttribute("credencial", new Credencial());
				session.setAttribute("nextURL", "redirect:respuestaPuntuacion/anadirRespuesta/" +id_puntuacion +".html");
				retorno = "login";
			} else {
				String rol = (String) session.getAttribute("rol");
				Usuario uProp = usuarioDao.getUsuario(puntuacionDao.getPuntuacion(id_puntuacion).getId_usuario());
				if ( rol.equals("inquilino") || usuario.getId_usuario() == uProp.getId_usuario()) {
					RespuestaPuntuacion respuesta = new RespuestaPuntuacion();
					respuesta.setId_respuesta(respuestaPuntuacionDao.nuevoIdRespuestaPuntuacion());
					respuesta.setId_puntuacion(id_puntuacion);
					model.addAttribute("respuestaPuntuacion", respuesta);
					retorno = "respuestaPuntuacion/anadirRespuesta";
				} else {
					//Acceso no autorizado porque el rol del usuario no es administrador
					retorno = "redirect:../index.jsp";
				}
			}
			return retorno;
		}

		@RequestMapping(value="/anadirRespuesta/{id_puntuacion}", method=RequestMethod.POST) 
		public String processAnadirSubmit(@PathVariable int id_puntuacion,@ModelAttribute("respuestaPuntuacion") RespuestaPuntuacion respuesta_puntuacion,
				BindingResult bindingResult) { 
			RespuestaPuntuacionValidator respuestaPuntuacionValidator = new RespuestaPuntuacionValidator();
			respuestaPuntuacionValidator.validate(respuesta_puntuacion, bindingResult); 
			if (bindingResult.hasErrors())
				return "respuestaPuntuacion/anadirRespuesta";
			respuestaPuntuacionDao.addRespuestaPuntuacion(respuesta_puntuacion);
			return "redirect:../list.html";
		}
}

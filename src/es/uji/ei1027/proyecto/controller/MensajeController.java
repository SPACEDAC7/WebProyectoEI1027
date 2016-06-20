package es.uji.ei1027.proyecto.controller;

import java.util.HashMap;
import java.util.List;
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
import es.uji.ei1027.proyecto.dao.MensajeDao;
import es.uji.ei1027.proyecto.dao.UsuarioDao;
import es.uji.ei1027.proyecto.domain.Credencial;
import es.uji.ei1027.proyecto.domain.Mensaje;
import es.uji.ei1027.proyecto.domain.Reserva;
import es.uji.ei1027.proyecto.domain.Usuario;
import es.uji.ei1027.proyecto.validator.MensajeValidator;

@Controller
@RequestMapping("/mensaje")
public class MensajeController {
	private MensajeDao mensajeDao;
	
	private UsuarioDao usuarioDao;
	private CredencialDao credencialDao;
	
	@Autowired
	public void setMensajeDao( MensajeDao mensajeDao){
		this.mensajeDao = mensajeDao;
	}
	
	@Autowired
	public void setUsuarioDao(UsuarioDao usuarioDao){
		this.usuarioDao = usuarioDao;
	}
	
	@Autowired
	public void setCredencialDao(CredencialDao credencialDao){
		this.credencialDao = credencialDao;
	}
	
	//Listar
	@RequestMapping("/list")
	public String listMensajes(Model model, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:mensaje/list.html");
			retorno =  "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				model.addAttribute("mensajes", mensajeDao.getMensajes());
				retorno = "mensaje/list";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}
	
	//A�adir	
	@RequestMapping(value="/add") 
	public String addMensaje(Model model, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:mensaje/add.html");
			retorno = "login";
		} else {
			System.out.println("Entramos en el add");
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				Mensaje mensaje = new Mensaje();
				System.out.println("SOMOS ADMINS");
				mensaje.setId_mensaje(mensajeDao.nuevoIdMensaje());
				model.addAttribute("mensaje", mensaje);
				retorno = "mensaje/add";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}

	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("mensaje") Mensaje mensaje,
			BindingResult bindingResult) { 
		MensajeValidator mensajeValidator = new MensajeValidator();
		mensajeValidator.validate(mensaje, bindingResult); 
		if (bindingResult.hasErrors()){
			return "mensaje/add";
		}
		mensajeDao.addMensaje(mensaje);
		return "redirect:list.html";
	}
	
	//Actualizar	
		@RequestMapping(value="/update/{id_mensaje}", method = RequestMethod.GET)
		public String editMensaje(Model model, @PathVariable int id_mensaje, HttpSession session) {
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			String retorno;
			if (usuario == null) {
				model.addAttribute("credencial", new Credencial());
				session.setAttribute("nextURL", "redirect:mensaje/update/" + id_mensaje + ".html");
				retorno = "login";
			} else {
				String rol = (String) session.getAttribute("rol");
				if ( rol.equals("administrador") ) {
					Mensaje mensaje = mensajeDao.getMensaje(id_mensaje);
					//Convierto fechas de tipo Date a tipo dd/mm/aaaa para que se muestren en la página de update
					model.addAttribute("mensaje", mensaje);
					retorno = "mensaje/update";
				} else {
					//Acceso no autorizado porque el rol del usuario no es administrador
					retorno = "redirect:../index.jsp";
				}
			}
			return retorno;
		}

		@RequestMapping(value="/update/{id_mensaje}", method = RequestMethod.POST) 
		public String processUpdateSubmit(@PathVariable int id_mensaje, 
				@ModelAttribute("mensaje") Mensaje mensaje, 
				BindingResult bindingResult) {
			System.out.println("Comprobamos los errores");
			if (bindingResult.hasErrors()) 
				return "mensaje/update";
			System.out.println("No hay errores");
			mensajeDao.updateMensaje(mensaje);
			return "redirect:../list.html"; 
		}

		//Borrar	
		@RequestMapping(value="/delete/{id_mensaje}")
		public String processDelete(@PathVariable int id_mensaje, HttpSession session, Model model) {
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			String retorno;
			if (usuario == null) {
				model.addAttribute("credencial", new Credencial());
				session.setAttribute("nextURL", "redirect:mensaje/delete/" + id_mensaje + ".html");
				retorno = "login";
			} else {
				String rol = (String) session.getAttribute("rol");
				if ( rol.equals("administrador") ) {
					mensajeDao.deleteMensaje(id_mensaje);
				    retorno = "redirect:../list.html";
				} else {
					//Acceso no autorizado porque el rol del usuario no es administrador
					retorno = "redirect:../index.jsp";
				}
			}
			return retorno;
		}
		
		@RequestMapping("/bandejaEntrada")
		public String processMensajesEntrada(Model model, HttpSession session){
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			if (usuario != null) {
				Map<Mensaje,Usuario> mapMensajeEmisor = new HashMap<Mensaje, Usuario>();
				Map<Usuario,Credencial> mapEmisorCredencial = new HashMap<Usuario,Credencial>();
				for(Mensaje mensaje: mensajeDao.obtenerMensajesReceptor(usuario.getId_usuario())){
					Usuario emisor = usuarioDao.getUsuario(mensaje.getId_emisor());
					Credencial credencialEmisor = credencialDao.getCredencial(emisor.getId_credencial());
					if(mensaje.getEstado_vision() == 1 || mensaje.getEstado_vision()==3){
						mapMensajeEmisor.put(mensaje, emisor);
						mapEmisorCredencial.put(emisor, credencialEmisor);
					}
				}
				model.addAttribute("listaMensajeEmisor", mapMensajeEmisor);
				model.addAttribute("listaEmisorCredencial", mapEmisorCredencial);
				return "mensaje/bandejaEntrada";
			} else {
				model.addAttribute("credencial", new Credencial());
				session.setAttribute("nextURL", "redirect:mensaje/bandejaEntrada.html");
				return "login";
			}
		}
		
		@RequestMapping("/bandejaSalida")
		public String processMensajesSalida(Model model, HttpSession session){
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			if (usuario != null) {
				Map<Mensaje,Usuario> mapMensajeReceptor = new HashMap<Mensaje, Usuario>();
				Map<Usuario,Credencial> mapReceptorCredencial = new HashMap<Usuario,Credencial>();
				for(Mensaje mensaje: mensajeDao.obtenerMensajesEmisor(usuario.getId_usuario())){
					Usuario receptor = usuarioDao.getUsuario(mensaje.getId_receptor());
					Credencial credencialReceptor = credencialDao.getCredencial(receptor.getId_credencial());
					if(mensaje.getEstado_vision() == 1 || mensaje.getEstado_vision()==2){
						mapMensajeReceptor.put(mensaje, usuarioDao.getUsuario(mensaje.getId_receptor()));
						mapReceptorCredencial.put(receptor, credencialReceptor);
					}
				}
				model.addAttribute("listaMensajeReceptor", mapMensajeReceptor);
				model.addAttribute("listaReceptorCredencial", mapReceptorCredencial);
				return "mensaje/bandejaSalida";
			} else {
				model.addAttribute("credencial", new Credencial());
				session.setAttribute("nextURL", "redirect:mensaje/bandejaSalida.html");
				return "login";
			}
		}
		
		@RequestMapping(value="/single/{id_mensaje}&{id_usuario}")
		public String processMensaje(@PathVariable int id_mensaje,@PathVariable int id_usuario,HttpSession session, Model model){
			model.addAttribute("mensaje", mensajeDao.getMensaje(id_mensaje));
			model.addAttribute("usuarioMen", usuarioDao.getUsuario(id_usuario));
			return "mensaje/single";
		}
		
		@RequestMapping(value="/redactar")
		public String redactar(HttpSession session, Model model){
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			String retorno;
			if (usuario == null) {
				model.addAttribute("credencial", new Credencial());
				session.setAttribute("nextURL", "redirect:mensaje/add.html");
				return "login";
			} else {
				Mensaje mensaje = new Mensaje();
				mensaje.setId_emisor(usuario.getId_usuario());
				mensaje.setId_mensaje(mensajeDao.nuevoIdMensaje());
				List<Usuario> usuarios = usuarioDao.getUsuarios();
				model.addAttribute("usuarios", usuarios);
				model.addAttribute("mensaje", mensaje);
				return "/mensaje/redactar";
			}
		}
		
		@RequestMapping(value="/redactar" , method=RequestMethod.POST)
		public String redactarMen(@ModelAttribute("mensaje") Mensaje mensaje,
				BindingResult bindingResult, HttpSession session, Model model){
			MensajeValidator mensajeValidator = new MensajeValidator();
			mensajeValidator.validate(mensaje, bindingResult); 
			if (bindingResult.hasErrors()){
				return "mensaje/redactar";
			}
			mensajeDao.addMensaje(mensaje);
			return "redirect:bandejaEntrada.html";
		}
	}

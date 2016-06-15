package es.uji.ei1027.proyecto.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.proyecto.dao.UsuarioDao;
import es.uji.ei1027.proyecto.domain.Credencial;
import es.uji.ei1027.proyecto.domain.Usuario;
import es.uji.ei1027.proyecto.validator.UsuarioValidator;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	private UsuarioDao usuarioDao;
	
	@Autowired
	public void setUsuarioDao( UsuarioDao usuarioDao){
		this.usuarioDao = usuarioDao;
	}
	//Listar
	@RequestMapping("/list")
	public String listUsuarios(Model model, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:usuario/list.html");
			retorno =  "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				model.addAttribute("usuarios", usuarioDao.getUsuarios());
				retorno = "usuario/list";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}
	
	//A�adir	
	@RequestMapping(value="/add") 
	public String addUsuario(Model model, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:usuario/add.html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				Usuario u = new Usuario();
				u.setId_usuario(usuarioDao.nuevoIdUsuario());
				model.addAttribute("usuario", u);
				retorno = "usuario/add";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}

	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("usuario") Usuario usuario,
			BindingResult bindingResult) { 
		UsuarioValidator usuarioValidator = new UsuarioValidator();
		usuario.setFecha_registro(this.fechaDeHoy());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		usuario.setFechaRegistro(sdf.format(this.fechaDeHoy()));
		usuarioValidator.validate(usuario, bindingResult); 
		if (bindingResult.hasErrors())
			return "usuario/add";
		usuario.crearFechas();
		usuarioDao.addUsuario(usuario);
		return "redirect:list.html";
	}
	//Actualizar	
	@RequestMapping(value="/update/{id_usuario}", method = RequestMethod.GET)
	public String editCredencial(Model model, @PathVariable int id_usuario, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:usuario/update/" + id_usuario + ".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				Usuario u = usuarioDao.getUsuario(id_usuario);
				u.convertirDateADiaMesAno();
				model.addAttribute("usuario", u);
				retorno = "usuario/update";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno; 
	}

	@RequestMapping(value="/update/{id_usuario}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable int id_usuario, 
			@ModelAttribute("usuario") Usuario usuario, 
			BindingResult bindingResult) {
		UsuarioValidator usuarioValidator = new UsuarioValidator();
		usuarioValidator.validate(usuario, bindingResult); 
		if (bindingResult.hasErrors())
			return "usuario/update";
		usuario.crearFechas();
		usuarioDao.updateUsuario(usuario);
		return "redirect:../list.html"; 
	}

	//Borrar	
	@RequestMapping(value="/delete/{id_usuario}")
	public String processDelete(@PathVariable int id_usuario, HttpSession session, Model model) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:usuario/delete/" + id_usuario + ".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				usuarioDao.deleteUsuario(id_usuario);
			    retorno = "redirect:../list.html";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}
	
	private Date fechaDeHoy() {
		java.util.Date fecha = new java.util.Date();
		Date fechaSQL = new Date(fecha.getTime());
		return fechaSQL;
		
	}
	
}

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

import es.uji.ei1027.proyecto.dao.ImagenDao;
import es.uji.ei1027.proyecto.domain.Credencial;
import es.uji.ei1027.proyecto.domain.Direccion;
import es.uji.ei1027.proyecto.domain.Imagen;
import es.uji.ei1027.proyecto.domain.Usuario;
import es.uji.ei1027.proyecto.validator.ImagenValidator;

@Controller
@RequestMapping("/imagen")
public class ImagenController {
	private ImagenDao imagenDao;
	
	@Autowired
	public void setImagenDao( ImagenDao imagenDao){
		this.imagenDao = imagenDao;
	}
	
	//Listar
	@RequestMapping("/list")
	public String listImagenes(Model model, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:imagen/list.html");
			retorno =  "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				model.addAttribute("imagenes", imagenDao.getImagenes());
				retorno = "imagen/list";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}
	
	//A�adir	
	@RequestMapping(value="/add") 
	public String addImagen(Model model, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:imagen/add.html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				Imagen img = new Imagen();
				img.setId_imagen(imagenDao.nuevoIdImagen());
				model.addAttribute("imagen", img);
				retorno = "imagen/add";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}

	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("imagen") Imagen imagen,
			BindingResult bindingResult) { 
		ImagenValidator imagenValidator = new ImagenValidator();
		imagenValidator.validate(imagen, bindingResult); 
		if (bindingResult.hasErrors())
			return "imagen/add";
		imagenDao.addImagen(imagen);
		return "redirect:list.html";
	}
	
	//Actualizar	
	@RequestMapping(value="/update/{id_imagen}", method = RequestMethod.GET)
	public String editImagen(Model model, @PathVariable int id_imagen, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:imagen/update/" + id_imagen + ".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				model.addAttribute("imagen", imagenDao.getImagen(id_imagen));
				retorno = "imagen/update";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}

	@RequestMapping(value="/update/{id_imagen}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable int id_imagen, 
			@ModelAttribute("imagen") Imagen imagen, 
			BindingResult bindingResult) {
		ImagenValidator imagenValidator = new ImagenValidator();
		imagenValidator.validate(imagen, bindingResult); 
		if (bindingResult.hasErrors()) 
			return "imagen/update";
		imagenDao.updateImagen(imagen);
		return "redirect:../list.html"; 
	}
	
	//Borrar	
	@RequestMapping(value="/delete/{id_imagen}")
	public String processDelete(@PathVariable int id_imagen, HttpSession session, Model model) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String retorno;
		if (usuario == null) {
			model.addAttribute("credencial", new Credencial());
			session.setAttribute("nextURL", "redirect:imagen/delete/" + id_imagen + ".html");
			retorno = "login";
		} else {
			String rol = (String) session.getAttribute("rol");
			if ( rol.equals("administrador") ) {
				imagenDao.deleteImagen(id_imagen);
			    retorno = "redirect:../list.html";
			} else {
				//Acceso no autorizado porque el rol del usuario no es administrador
				retorno = "redirect:../index.jsp";
			}
		}
		return retorno;
	}
	
}

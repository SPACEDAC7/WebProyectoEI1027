package es.uji.ei1027.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.proyecto.dao.UsuarioDao;
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
	public String listUsuarios(Model model){
		model.addAttribute("usuarios", usuarioDao.getUsuarios());
		return "usuario/list";
	}
	
	//A�adir	
	@RequestMapping(value="/add") 
	public String addUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuario/add";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("usuario") Usuario usuario,
			BindingResult bindingResult) { 
		UsuarioValidator usuarioValidator = new UsuarioValidator();
		usuarioValidator.validate(usuario, bindingResult); 
		if (bindingResult.hasErrors())
			return "usuario/add";
		usuario.crearFechas();
		usuarioDao.addUsuario(usuario);
		return "redirect:list.html";
	}
	//Actualizar	
	@RequestMapping(value="/update/{id_usuario}", method = RequestMethod.GET)
	public String editCredencial(Model model, @PathVariable int id_usuario) {
		Usuario usuario = usuarioDao.getUsuario(id_usuario);
		usuario.convertirDateADiaMesAno();
		model.addAttribute("usuario", usuario);
		return "usuario/update"; 
	}

	@RequestMapping(value="/update/{id_usuario}", method = RequestMethod.POST) 
	public String processUpdateSubmit(@PathVariable int id_usuario, 
			@ModelAttribute("usuario") Usuario usuario, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) 
			return "usuario/update";
		usuario.crearFechas();
		usuarioDao.updateUsuario(usuario);
		return "redirect:../list.html"; 
	}

	//Borrar	
	@RequestMapping(value="/delete/{id_usuario}")
	public String processDelete(@PathVariable int id_usuario) {
		usuarioDao.deleteUsuario(id_usuario);
		return "redirect:../list.html"; 
	}
}

package es.uji.ei1027.proyecto.controller;

import java.sql.Date;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.proyecto.dao.CredencialDao;
import es.uji.ei1027.proyecto.dao.DireccionDao;
import es.uji.ei1027.proyecto.dao.UsuarioDao;
import es.uji.ei1027.proyecto.domain.Credencial;
import es.uji.ei1027.proyecto.domain.Direccion;
import es.uji.ei1027.proyecto.domain.Usuario;
import es.uji.ei1027.proyecto.validator.CredencialValidator;
import es.uji.ei1027.proyecto.validator.DireccionValidator;
import es.uji.ei1027.proyecto.validator.LoginValidator;
import es.uji.ei1027.proyecto.validator.UsuarioValidator;


@RequestMapping("/signup")
@Controller
public class NuevoUsuarioController {
	@Autowired
	private CredencialDao credencialDao;
	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private DireccionDao direccionDao;
	
	
	@Autowired
	public void setCredencialDao( CredencialDao credencialDao, UsuarioDao usuarioDao ){
		this.credencialDao = credencialDao;
		this.usuarioDao = usuarioDao;
	}
	
	@RequestMapping("/addUser")
	public String addNuevoUsuarioYCredencial(HttpSession session, Model model){
		model.addAttribute("nuevoUsuario", new Usuario());
		model.addAttribute("nuevaDireccion", new Direccion());
		return "signup/signup";
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("nuevoUsuario") Usuario usuario,
			@ModelAttribute("nuevaDireccion") Direccion direccion, BindingResult bindingResult) {
		CredencialValidator credencialValidator = new CredencialValidator();
		DireccionValidator direccionValidator = new DireccionValidator();
		UsuarioValidator usuarioValidator = new UsuarioValidator();
		
		//Conseguimos los nuevos ids para añadir los datos a las tablas
		int idDireccion = direccionDao.nuevoIdDireccion();
		int idCredencial = credencialDao.nuevoIdCredencial();
		int idUsuario = usuarioDao.nuevoIdUsuario();
		
		BasicPasswordEncryptor passwordEncrypter = new BasicPasswordEncryptor();
		
		//Crear y anadir la credencial
		String nickUsuario = usuario.getNickUsuario();
		String rol = usuario.getRol();
		String passwordEncriptado = passwordEncrypter.encryptPassword(usuario.getPasswordUsuario());
		Credencial credencial = new Credencial(idCredencial, nickUsuario, passwordEncriptado, rol);
		
		credencialValidator.validate(credencial, bindingResult);
		if (bindingResult.hasErrors()) {
            return "addUser";
        }
		
		
				
		//Crear y anadir la direccion
		direccion.setId_direccion(idDireccion);
		direccionValidator.validate(direccion, bindingResult);
		if (bindingResult.hasErrors()) {
            return "addUser";
        }
		
		
		
		//Anadir el usuario
		usuario.setId_usuario(idUsuario);
		usuario.setId_direccion(idDireccion);
		usuario.setId_credencial(idCredencial);
		usuario.setUrl_imagen_perfil("urlImagen");
		
		usuario.setFecha_registro(this.fechaDeHoy());
		usuario.setEstado_usuario(true);
		usuarioValidator.validate(usuario, bindingResult);
		if (bindingResult.hasErrors()) {
			return "addUser";
		}
		
		
		credencialDao.addCredencial(credencial);
		direccionDao.addDireccion(direccion);
		usuarioDao.addUsuario(usuario);
		
		return "redirect:../index.jsp";
	}
	
	private Date fechaDeHoy() {
		java.util.Date fecha = new java.util.Date();
		Date fechaSQL = new Date(fecha.getTime());
		return fechaSQL;
		
	}
		
		
		
	

}

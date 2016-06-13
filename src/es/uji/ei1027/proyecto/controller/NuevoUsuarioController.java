package es.uji.ei1027.proyecto.controller;

import java.sql.Date;

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
	
	private Direccion dir;
	private Credencial cre;
	
	
	@Autowired
	public void setCredencialDao( CredencialDao credencialDao, UsuarioDao usuarioDao ){
		this.credencialDao = credencialDao;
		this.usuarioDao = usuarioDao;
	}
	
	@RequestMapping("/addDireccion")
	public String addNuevaDireccion(HttpSession session, Model model){
		model.addAttribute("nuevaDireccion", new Direccion());
		return "signup/signupdireccion";
	}
	
	@RequestMapping(value="/addDireccion", method=RequestMethod.POST)
	public String processAddDirectionSubmit(@ModelAttribute("nuevaDireccion") Direccion direccion, 
			BindingResult bindingResult, Model model) {
		int idDireccion = direccionDao.nuevoIdDireccion();
		direccion.setId_direccion(idDireccion);
		DireccionValidator direccionValidator = new DireccionValidator();
		direccionValidator.validate(direccion, bindingResult);
		if (bindingResult.hasErrors()) {
			System.out.println("Algo ha fallado al crear la direccion");
            return "signup/signupdireccion";
        }
		//direccionDao.addDireccion(direccion);
		model.addAttribute("nuevoUsuario", new Usuario());
		dir = direccion;
		return "signup/signupusuario";
	}
	
	@RequestMapping(value="/addUsuario", method=RequestMethod.POST)
	public String processAddUsuarioSubmit(@ModelAttribute("nuevoUsuario") Usuario usuario, 
			BindingResult bindingResult, Model model) {
		int idUsuario = usuarioDao.nuevoIdUsuario();
		usuario.setId_usuario(idUsuario);
		usuario.setId_credencial(cre.getId_credencial());
		usuario.setId_direccion(dir.getId_direccion());
		UsuarioValidator usuarioValidator = new UsuarioValidator();
		usuarioValidator.validate(usuario, bindingResult);
		if (bindingResult.hasErrors()) {
			System.out.println("Algo ha fallado al crear el usuario");
            return "signup/signupusuario";
        }
		
		direccionDao.addDireccion(dir);
		credencialDao.addCredencial(cre);
		usuario.setEstado_usuario(true);
		usuarioDao.addUsuario(usuario);
		return "signup/usuariocreado";
	}
	
	
	
	@RequestMapping("/addUser")
	public String addNuevoUsuarioYCredencial(HttpSession session, Model model){
		model.addAttribute("nuevaCredencial", new Credencial());
		return "signup/signup";
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST) 
	public String processAddSubmit(@ModelAttribute("nuevoUsuario") Usuario usuario, @ModelAttribute("nuevaCredencial") Credencial credencial, BindingResult bindingResult, HttpSession session, Model model) {
		
		//Conseguimos los nuevos ids para añadir los datos a las tablas
		int idCredencial = credencialDao.nuevoIdCredencial();
		
		
		//Crear y anadir la credencial
		BasicPasswordEncryptor passwordEncrypter = new BasicPasswordEncryptor();
		System.out.println(credencial.getNick_usuario());
		credencial.setId_credencial(idCredencial);		
		CredencialValidator credencialValidator = new CredencialValidator();
		credencialValidator.setCredencialDao(credencialDao);
		credencialValidator.validate(credencial, bindingResult);
		if (bindingResult.hasErrors()) {
			System.out.println("Algo ha fallado al crear la credencial");
            return "signup/signup";
        }
		credencial.setPassword(passwordEncrypter.encryptPassword(credencial.getPassword()));
		model.addAttribute("nuevaDireccion", new Direccion());
		cre = credencial;
		return "/signup/signupdireccion";
		
		/*UsuarioValidator usuarioValidator = new UsuarioValidator();
		
		usuario.setId_usuario(idUsuario);
		
		
		/*direccionValidator.validate(direccion, bindingResult);
		if (bindingResult.hasErrors()) {
			System.out.println("Algo ha fallado al crear la direccion");
            return "signup/signup";
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
			System.out.println("Algo ha fallado al crear el usuario");
			return "signup/signup";
		}
		
		
		credencialDao.addCredencial(credencial);
		usuarioDao.addUsuario(usuario);
		
		return "redirect:../index.jsp";*/
	}
	
	private Date fechaDeHoy() {
		java.util.Date fecha = new java.util.Date();
		Date fechaSQL = new Date(fecha.getTime());
		return fechaSQL;
		
	}
}

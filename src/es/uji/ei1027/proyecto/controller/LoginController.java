package es.uji.ei1027.proyecto.controller;

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
import es.uji.ei1027.proyecto.dao.UsuarioDao;
import es.uji.ei1027.proyecto.domain.Credencial;
import es.uji.ei1027.proyecto.domain.Usuario;
import es.uji.ei1027.proyecto.validator.CredencialValidator;
import es.uji.ei1027.proyecto.validator.UsuarioValidator;

@Controller
public class LoginController {
    @Autowired
    private CredencialDao credencialDao;
    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("credencial", new Credencial());
        return "login";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String checkLogin(@ModelAttribute("credencial") Credencial credencial,          
                BindingResult bindingResult, HttpSession session) {
    	//CredencialValidator credencialValidator = new CredencialValidator();
    	//credencialValidator.validate(credencial, bindingResult); 
        if (bindingResult.hasErrors()) {
            return "login";
        }
        // Comprova que el login siga correcte 
        // intentant carregar les dades de l'usuari
        String nombre = credencial.getNick_usuario();
        String password = credencial.getPassword();
        String retorno = "redirect:index.jsp";
        String passwordDeLaBaseDeDatos = credencialDao.getPassword(nombre);
        if (passwordDeLaBaseDeDatos == null) {
        	//Mala autenticación
        	bindingResult.rejectValue("password", "badpw", "El usuario o la contraseña no coinciden");
        	//Vuelve a la página de login porque el usuario y password no són válidos
        } else {
        	BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
            if (passwordEncryptor.checkPassword(password, passwordDeLaBaseDeDatos)) {
            	System.out.println("Password introducido coincide con el encriptado");
            	int idCredencial = credencialDao.getIdCredencialAPartirDeNombre(nombre);
            	Usuario usuario = usuarioDao.getUsuarioPorIdCredencial(idCredencial);
            	//Guardamos el usuario que ha hecho login en la sesión
            	session.setAttribute("usuario", usuario);
            	session.setAttribute("rol", credencialDao.getRolPorIdCredencial(idCredencial));
            	//Vuelve a la página principal
            	if (session.getAttribute("nextURL") != null) {
            		retorno = (String) session.getAttribute("nextURL");
            	}
            	
            } else {
            	bindingResult.rejectValue("password", "badpw", "El usuario o la contraseña no coinciden");
            	System.out.println("Password introducido NO coincide con el encriptado");
            }
        }
        
        return retorno;
    }

    @RequestMapping("/logout") 
    public String logout(HttpSession session) {
        session.invalidate(); 
        return "redirect:index.jsp";
    }
}

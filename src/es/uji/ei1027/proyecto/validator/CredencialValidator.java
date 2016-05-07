package es.uji.ei1027.proyecto.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.uji.ei1027.proyecto.domain.Credencial;

public class CredencialValidator implements Validator{
	@Override
	public boolean supports(Class<?> cls){
		return Credencial.class.equals(cls);
		
		 // o, si volguérem tractar també les subclasses: 
		 // return Credencial.class.isAssignableFrom(cls);
	}
	
	@Override
	public void validate(Object obj, Errors errors){
		Credencial credencial = (Credencial)obj;
		if( credencial.getId_credencial()<0)
			errors.rejectValue("id_credencial", "obligatori", "Hay que introducir un valor");
		//Aqui todas las cosas que queramos validar
		if ( credencial.getNick_usuario().equals("") )
			errors.rejectValue("nick_usuario", "obligatori", "Hay que introducir un valor");
		if (credencial.getPassword().equals(""))
			errors.rejectValue("password", "obligatori", "Hay que introducir un valor");
	}
}

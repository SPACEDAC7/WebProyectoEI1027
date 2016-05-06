package es.uji.ei1027.proyecto.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import es.uji.ei1027.proyecto.domain.Usuario;

public class UsuarioValidator implements Validator {
	@Override
	public boolean supports(Class<?> cls){
		return Usuario.class.equals(cls);
		
		 // o, si volguérem tractar també les subclasses: 
		 // return Credencial.class.isAssignableFrom(cls);
	}
	
	@Override
	public void validate(Object obj, Errors errors){
		Usuario usuario = (Usuario)obj;
		if( usuario.getId_credencial()<0)
			errors.rejectValue("id_credencial", "obligatori", "Hay que introducir un valor");
		//Aqui todas las cosas que queramos validar
		if( usuario.getId_usuario()<0)
			errors.rejectValue("id_usuario", "obligatori", "Hay que introducir un valor");
	}
}

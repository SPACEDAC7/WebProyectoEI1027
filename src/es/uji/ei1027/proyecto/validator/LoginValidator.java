package es.uji.ei1027.proyecto.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.uji.ei1027.proyecto.domain.Credencial;

public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		// TODO Auto-generated method stub
		return Credencial.class.equals(cls);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Credencial credencial = (Credencial)obj;
		//Aqui todas las cosas que queramos validar
		if ( credencial.getNick_usuario().equals("") )
			errors.rejectValue("nick_usuario", "obligatori", "Hay que introducir un valor");
		if (credencial.getPassword().equals(""))
			errors.rejectValue("password", "obligatori", "Hay que introducir un valor");
	}
	
	public void validateStateUser(boolean state, Errors errors) {
		if ( !state ) {
			errors.rejectValue("nick_usuario", "Usuario dado de baja", "El usuario está dado de baja");
		}
	}

}

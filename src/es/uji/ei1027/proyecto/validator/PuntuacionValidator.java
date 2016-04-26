package es.uji.ei1027.proyecto.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.uji.ei1027.proyecto.domain.Puntuacion;

public class PuntuacionValidator implements Validator {
	@Override
	public boolean supports(Class<?> cls){
		return Puntuacion.class.equals(cls);
		
		 // o, si volguérem tractar també les subclasses: 
		 // return Credencial.class.isAssignableFrom(cls);
	}
	
	@Override
	public void validate(Object obj, Errors errors){
		Puntuacion credencial = (Puntuacion)obj;
		if( credencial.getId_puntuacion()<0)
			errors.rejectValue("id_puntuacion", "obligatori", "Hay que introducir un valor");
		//Aqui todas las cosas que queramos validar
		if( credencial.getId_propiedad()<0)
			errors.rejectValue("id_propiedad", "obligatori", "Hay que introducir un valor");
		if( credencial.getId_usuario()<0)
			errors.rejectValue("id_usuario", "obligatori", "Hay que introducir un valor");
	}
}

package es.uji.ei1027.proyecto.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.uji.ei1027.proyecto.domain.RespuestaPuntuacion;

public class RespuestaPuntuacionValidator implements Validator{
	@Override
	public boolean supports(Class<?> cls){
		return RespuestaPuntuacion.class.equals(cls);
		
		 // o, si volguérem tractar també les subclasses: 
		 // return Credencial.class.isAssignableFrom(cls);
	}
	
	@Override
	public void validate(Object obj, Errors errors){
		RespuestaPuntuacion respuesta_puntuacion = (RespuestaPuntuacion)obj;
		if( respuesta_puntuacion.getId_respuesta()<0)
			errors.rejectValue("id_respuesta", "obligatori", "Hay que introducir un valor");
		//Aqui todas las cosas que queramos validar
		if( respuesta_puntuacion.getId_puntuacion()<0)
			errors.rejectValue("id_puntuacion", "obligatori", "Hay que introducir un valor");
	}
}

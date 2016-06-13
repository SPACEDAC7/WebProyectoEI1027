package es.uji.ei1027.proyecto.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.uji.ei1027.proyecto.domain.Servicio;

public class ServicioValidator implements Validator {
	@Override
	public boolean supports(Class<?> cls){
		return Servicio.class.equals(cls);
		
		 // o, si volguérem tractar també les subclasses: 
		 // return Credencial.class.isAssignableFrom(cls);
	}
	
	@Override
	public void validate(Object obj, Errors errors){
		Servicio servicio = (Servicio) obj;
		if( servicio.getIdServicio() < 0 )
			errors.rejectValue("id_servicio", "obligatori", "Hay que introducir un valor");
		//Aqui todas las cosas que queramos validar
		if( servicio.getIdServicio()<0)
			errors.rejectValue("id_servicio", "obligatori", "Hay que introducir un valor");
	}
}

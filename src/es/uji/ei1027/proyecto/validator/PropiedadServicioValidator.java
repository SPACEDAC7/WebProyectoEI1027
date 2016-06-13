package es.uji.ei1027.proyecto.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.uji.ei1027.proyecto.domain.PropiedadServicio;

public class PropiedadServicioValidator implements Validator{

	@Override
	public boolean supports(Class<?> cls){
		return PropiedadServicio.class.equals(cls);
		
		 // o, si volguérem tractar també les subclasses: 
		 // return Credencial.class.isAssignableFrom(cls);
	}
	
	@Override
	public void validate(Object obj, Errors errors){
		PropiedadServicio propiedad_servicio = (PropiedadServicio)obj;
		if( propiedad_servicio.getId_servicio()<0)
			errors.rejectValue("id_servicio", "obligatori", "Hay que introducir un valor");
		//Aqui todas las cosas que queramos validar
		
		if( propiedad_servicio.getId_propiedad()<0)
			errors.rejectValue("id_propiedad", "obligatori", "Hay que introducir un valor");
	}
}

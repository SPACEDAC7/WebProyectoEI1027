package es.uji.ei1027.proyecto.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.uji.ei1027.proyecto.domain.Imagen;

public class ImagenValidator implements Validator {
	@Override
	public boolean supports(Class<?> cls){
		return Imagen.class.equals(cls);
		
		 // o, si volguérem tractar també les subclasses: 
		 // return Credencial.class.isAssignableFrom(cls);
	}
	
	@Override
	public void validate(Object obj, Errors errors){
		Imagen credencial = (Imagen)obj;
		if( credencial.getId_imagen()<0)
			errors.rejectValue("id_imagen", "obligatori", "Hay que introducir un valor");
		if( credencial.getId_propiedad()<0)
			errors.rejectValue("id_propiedad", "obligatori", "Hay que introducir un valor");
	}
}

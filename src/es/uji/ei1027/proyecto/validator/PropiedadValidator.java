package es.uji.ei1027.proyecto.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.uji.ei1027.proyecto.domain.Propiedad;

public class PropiedadValidator implements Validator {
	@Override
	public boolean supports(Class<?> cls){
		return Propiedad.class.equals(cls);
		
		 // o, si volguérem tractar també les subclasses: 
		 // return Credencial.class.isAssignableFrom(cls);
	}
	
	@Override
	public void validate(Object obj, Errors errors){
		Propiedad propiedad = (Propiedad)obj;
		if( propiedad.getId_propiedad()<0)
			errors.rejectValue("id_propiedad", "obligatori", "Hay que introducir un valor");
		//Aqui todas las cosas que queramos validar
		if( propiedad.getId_usuario()<0)
			errors.rejectValue("id_usuario", "obligatori", "Hay que introducir un valor");
		if( propiedad.getTitulo().equals(""))
			errors.rejectValue("titulo", "obligatori", "Hay que introducir un valor");
	}
}

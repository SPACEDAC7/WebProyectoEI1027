package es.uji.ei1027.proyecto.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.uji.ei1027.proyecto.domain.Periodo;

public class PeriodoValidator implements Validator {
	@Override
	public boolean supports(Class<?> cls){
		return Periodo.class.equals(cls);
		
		 // o, si volguérem tractar també les subclasses: 
		 // return Credencial.class.isAssignableFrom(cls);
	}
	
	@Override
	public void validate(Object obj, Errors errors){
		Periodo periodo = (Periodo)obj;
		if( periodo.getId_periodo()<0)
			errors.rejectValue("id_periodo", "obligatori", "Hay que introducir un valor");
		//Aqui todas las cosas que queramos validar
		
		if( periodo.getId_propiedad()<0)
			errors.rejectValue("id_propiedad", "obligatori", "Hay que introducir un valor");
	}
}

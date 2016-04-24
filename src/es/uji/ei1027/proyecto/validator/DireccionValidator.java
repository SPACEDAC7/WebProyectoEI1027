package es.uji.ei1027.proyecto.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.uji.ei1027.proyecto.domain.Direccion;

public class DireccionValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls){
		return Direccion.class.equals(cls);
	}
	
	@Override
	public void validate(Object obj, Errors errors){
		Direccion direccion = (Direccion) obj;
		if(direccion.getId_direccion()<0){
			errors.rejectValue("id_direccion", "obligatori", "Has de introducir un valor superior a 0");
		}
	}
}

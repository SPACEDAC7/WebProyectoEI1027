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
		if ( direccion.getNumero() <= 0 ) {
			errors.rejectValue("numero", "obligatori", "N�mero de direcci�n inv�lido");
		}
		if ( direccion.getCodigo_postal() <= 0 ) {
			errors.rejectValue("codigo_postal", "obligatori", "C�digo postal inv�lido");
		}
		if (direccion.getProvincia().equals("")) {
			errors.rejectValue("provincia", "obligatori", "El campo provincia no puede estar en blanco");
		}
		if (direccion.getCalle().equals("")) {
			errors.rejectValue("calle", "obligatori", "El campo calle no puede estar en blanco");
		}
		if (direccion.getLocalidad().equals("")) {
			errors.rejectValue("localidad", "obligatori", "El campo localidad no puede estar en blanco");
		}
	}
}

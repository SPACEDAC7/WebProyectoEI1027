package es.uji.ei1027.proyecto.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.uji.ei1027.proyecto.domain.Factura;

public class FacturaValidator implements Validator {
	@Override
	public boolean supports(Class<?> cls){
		return Factura.class.equals(cls);
		
		 // o, si volguérem tractar també les subclasses: 
		 // return Credencial.class.isAssignableFrom(cls);
	}
	
	@Override
	public void validate(Object obj, Errors errors){
		Factura factura = (Factura)obj;
		if( factura.getId_factura()<0)
			errors.rejectValue("id_factura", "obligatori", "Hay que introducir un valor");
		//Aqui todas las cosas que queramos validar
	}
	
}

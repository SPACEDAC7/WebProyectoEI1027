package es.uji.ei1027.proyecto.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import es.uji.ei1027.proyecto.domain.Mensaje;

public class MensajeValidator implements Validator{
	@Override
	public boolean supports(Class<?> cls){
		return Mensaje.class.equals(cls);
		
		 // o, si volguérem tractar també les subclasses: 
		 // return Credencial.class.isAssignableFrom(cls);
	}
	
	@Override
	public void validate(Object obj, Errors errors){
		Mensaje mensaje = (Mensaje)obj;
		if( mensaje.getId_mensaje()<0){
			errors.rejectValue("id_mensaje", "obligatori", "Hay que introducir un valor");
		//Aqui todas las cosas que queramos validar
		}
		System.out.println("El id_mensaje est bien");
		if( mensaje.getId_emisor()<0){
			errors.rejectValue("id_emisor", "obligatori", "Hay que introducir un valor");
		//Aqui todas las cosas que queramos validar
		}
		System.out.println("El id_emisor est bien");
		if( mensaje.getId_receptor()<0){
			errors.rejectValue("id_receptor", "obligatori", "Hay que introducir un valor");
		//Aqui todas las cosas que queramos validar
		}
		System.out.println("El id_receptor est bien");
		if(mensaje.getEstado_vision() > 3 || mensaje.getEstado_vision() < 0){
			errors.rejectValue("estado_vision", "obligatori", "Hay que introducir un valor entre 0 y 3");
		}
		System.out.println("El estao_vision est bien");
	}
}

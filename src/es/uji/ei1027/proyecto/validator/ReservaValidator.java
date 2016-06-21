package es.uji.ei1027.proyecto.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.uji.ei1027.proyecto.domain.Reserva;

public class ReservaValidator implements Validator {
	@Override
	public boolean supports(Class<?> cls){
		return Reserva.class.equals(cls);
		
		 // o, si volguérem tractar també les subclasses: 
		 // return Credencial.class.isAssignableFrom(cls);
	}
	
	@Override
	public void validate(Object obj, Errors errors){
		Reserva reserva = (Reserva)obj;
		if( reserva.getId_reserva()<0)
			errors.rejectValue("id_reserva", "obligatori", "Hay que introducir un valor");
		//Aqui todas las cosas que queramos validar
		if( reserva.getId_propiedad()<0)
			errors.rejectValue("id_propiedad", "obligatori", "Hay que introducir un valor");
		if( reserva.getId_usuario()<0)
			errors.rejectValue("id_usuario", "obligatori", "Hay que introducir un valor");
		if(!reserva.getEstado().equals("pendiente") && !reserva.getEstado().equals("denegada")&& !reserva.getEstado().equals("confirmada")){
			errors.rejectValue("estado", "obligatori", "Solo puede ser pendiente, confirmada o denegada");
		}
		if(reserva.getPrecio_reserva()<0.0){
			errors.rejectValue("precio_reserva", "obligatori", "El precio ha de ser positivo");
		}
		if(reserva.getFecha_checkin().after(reserva.getFecha_checkout())){
			errors.rejectValue("fechaCheckIn", "obligatori", "La fecha del check in debe ser anterior al check out");
		}
	}
}

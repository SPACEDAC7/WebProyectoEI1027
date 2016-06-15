package es.uji.ei1027.proyecto.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.uji.ei1027.proyecto.dao.ReservaDao;
import es.uji.ei1027.proyecto.domain.Factura;

public class FacturaValidator implements Validator {
	
	private ReservaDao reservaDao;
	
	public void setReservaDao(ReservaDao r) {
		reservaDao = r;
	}
	
	@Override
	public boolean supports(Class<?> cls){
		return Factura.class.equals(cls);
		
		 // o, si volguérem tractar també les subclasses: 
		 // return Credencial.class.isAssignableFrom(cls);
	}
	
	@Override
	public void validate(Object obj, Errors errors){
		Factura factura = (Factura)obj;
		if( factura.getId_factura() <= 0 )
			errors.rejectValue("id_factura", "obligatori", "Hay que introducir un valor");
		if ( ! reservaDao.existeReserva(factura.getId_reserva()) )
			errors.rejectValue("id_reserva", "obligatori", "La reserva que has introducido no existe");
		if ( factura.getFechaString() == "" )
			errors.rejectValue("fechaString", "obligatori", "Es obligatorio introducir una fecha");
	}
	
}

package es.uji.ei1027.proyecto.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.uji.ei1027.proyecto.dao.PropiedadDao;
import es.uji.ei1027.proyecto.domain.Periodo;

public class PeriodoValidator implements Validator {
	
	private PropiedadDao propiedadDao;
	
	public void setPropiedadDao(PropiedadDao p) {
		propiedadDao = p;
	}
	
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
		if ( ! propiedadDao.existePropiedad(periodo.getId_propiedad()) )
			errors.rejectValue("id_propiedad", "obligatori", "La propiedad que has introducido no existe");
		if ( periodo.getFechaInicio().equals("") )
			errors.rejectValue("fechaInicio", "obligatori", "Hay que introducir una fecha inicial");
		if ( periodo.getFechaFinal().equals("") )
			errors.rejectValue("fechaFinal", "obligatori", "Hay que introducir una fecha final");
		if ( periodo.getId_propiedad() < 0 )
			errors.rejectValue("id_propiedad", "obligatori", "Es necesario saber la propiedad");
	}
}

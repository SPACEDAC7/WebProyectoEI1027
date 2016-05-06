package es.uji.ei1027.proyecto.domain;

import java.sql.Date;
import java.util.Calendar;

public class ConvertidorDeFechas {
	
	private Date fechaAConvertir;
	
	public ConvertidorDeFechas() {
		super();
	}
	
	public ConvertidorDeFechas(Date d) {
		fechaAConvertir = d;
	}
	
	public String convertirFecha() {
		int dia, mes, ano;
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.fechaAConvertir);
		dia = cal.get(Calendar.DAY_OF_MONTH);
		mes = cal.get(Calendar.MONTH)+1;
		ano = cal.get(Calendar.YEAR);
		return dia + "/" + mes + "/" + ano;
	}
	
	public String convertirFecha(Date fecha) {
		int dia, mes, ano;
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		dia = cal.get(Calendar.DAY_OF_MONTH);
		mes = cal.get(Calendar.MONTH)+1;
		ano = cal.get(Calendar.YEAR);
		return dia + "/" + mes + "/" + ano;
	}
	
	public Date convertirFecha(String fecha) {
		String[] diaMesAno = fecha.split("/");
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(diaMesAno[2]), Integer.parseInt(diaMesAno[1])-1, Integer.parseInt(diaMesAno[0]));
		return new Date(cal.getTimeInMillis());
	}

	public Date getFechaAConvertir() {
		return fechaAConvertir;
	}

	public void setFechaAConvertir(Date fechaAConvertir) {
		this.fechaAConvertir = fechaAConvertir;
	}

}

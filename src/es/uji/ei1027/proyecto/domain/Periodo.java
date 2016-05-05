package es.uji.ei1027.proyecto.domain;

import java.sql.Date;
import java.util.Calendar;

public class Periodo {

	private int id_periodo;
	private int id_propiedad;
	private Date inicio;
	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	private Date fin;
	private String fechaInicio;
	private String fechaFinal;
	
	public Periodo() {
		super();
	}
	
	public Periodo(int id_periodo, int id_propiedad, Date inicio, Date fin) {
		super();
		this.id_periodo = id_periodo;
		this.id_propiedad = id_propiedad;
		this.inicio = inicio;
		this.fin = fin;
	}
	
	public void crearFechas() {
		String[] diaMesAno = fechaInicio.split("/");
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(diaMesAno[2]), Integer.parseInt(diaMesAno[1]), Integer.parseInt(diaMesAno[0]));
		this.inicio = new Date(cal.getTimeInMillis());
		
		diaMesAno = fechaFinal.split("/");
		cal.set(Integer.parseInt(diaMesAno[2]), Integer.parseInt(diaMesAno[1]), Integer.parseInt(diaMesAno[0]));
		this.fin = new Date(cal.getTimeInMillis());
		
	}


	public int getId_periodo() {
		return id_periodo;
	}

	public void setId_periodo(int id_periodo) {
		this.id_periodo = id_periodo;
	}

	public int getId_propiedad() {
		return id_propiedad;
	}

	public void setId_propiedad(int id_propiedad) {
		this.id_propiedad = id_propiedad;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	@Override
	public String toString() {
		return "Periodo [idPeriodo=" + id_periodo + ", idPropiedad=" + id_propiedad + ", inicio="
				+ inicio.toString() + ", fin=" + fin.toString() + "]";
	}
	
	
}

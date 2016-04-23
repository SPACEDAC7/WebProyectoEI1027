package es.uji.ei1027.proyecto.domain;

import java.sql.Date;

public class Periodo {

	public Periodo(int id_periodo, int id_propiedad, Date inicio, Date fin) {
		super();
		this.idPeriodo = id_periodo;
		this.idPropiedad = id_propiedad;
		this.inicio = inicio;
		this.fin = fin;
	}
	
	public Periodo() {
		super();
	}
	
	private int idPeriodo;
	private int idPropiedad;
	private Date inicio;
	private Date fin;
		
	public int getIdPeriodo() {
		return idPeriodo;
	}
	public void setIdPeriodo(int id_periodo) {
		this.idPeriodo = id_periodo;
	}
	public int getIdPropiedad() {
		return idPropiedad;
	}
	public void setIdPropiedad(int id_propiedad) {
		this.idPropiedad = id_propiedad;
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
		return "Periodo [idPeriodo=" + idPeriodo + ", idPropiedad=" + idPropiedad + ", inicio="
				+ inicio.toString() + ", fin=" + fin.toString() + "]";
	}
	
	
}

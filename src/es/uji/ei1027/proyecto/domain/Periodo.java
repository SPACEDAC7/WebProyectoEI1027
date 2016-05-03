package es.uji.ei1027.proyecto.domain;

import java.sql.Date;

public class Periodo {

	private int id_periodo;
	private int id_propiedad;
	private Date inicio;
	private Date fin;
	
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

package es.uji.ei1027.proyecto.domain;

import java.sql.Date;

public class Periodo {

	private int id_periodo;
	private int id_propiedad;
	private Date inicio;
	private Date fin;
	//Comentario de prueba
	
	//Estos dos atributos no tienen nada que ver con la base de datos
	//Únicamente se utilizan para poder mostrar y solicitar dechas en formato dd/mm/aaaa
	private String fechaInicio;
	private String fechaFinal;
	
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
		//Convierte una fecha tipo String con el formato dd/mm/aaaa a una tipo Date
		ConvertidorDeFechas c = new ConvertidorDeFechas();
		inicio = c.convertirFecha(fechaInicio);
		fin = c.convertirFecha(fechaFinal);
	}
	
	public void convertirDateADiaMesAno() {
		//Convierte una fecha tipo Date a una fecha tipo String con el formato dd/mm/aaaa
		ConvertidorDeFechas c = new ConvertidorDeFechas();
		this.fechaInicio = c.convertirFecha(inicio);
		this.fechaFinal = c.convertirFecha(fin);
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

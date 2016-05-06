package es.uji.ei1027.proyecto.domain;

public class Servicio {
	private int id_servicio;
	private String nombre_servicio;
	public Servicio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Servicio(int id_servicio, String nombre_servicio) {
		super();
		this.id_servicio = id_servicio;
		this.nombre_servicio = nombre_servicio;
	}
	public int getId_servicio() {
		return id_servicio;
	}
	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}
	public String getNombre_servicio() {
		return nombre_servicio;
	}
	public void setNombre_servicio(String nombre_servicio) {
		this.nombre_servicio = nombre_servicio;
	}
	@Override
	public String toString() {
		return "Servicio [id_servicio=" + id_servicio + ", nombre_servicio=" + nombre_servicio + "]";
	}
	
	
}

package es.uji.ei1027.proyecto.domain;

public class PropiedadServicio {

	private int id_propiedad;
	private int id_servicio;
	public PropiedadServicio(int id_propiedad, int id_servicio) {
		super();
		this.id_propiedad = id_propiedad;
		this.id_servicio = id_servicio;
	}
	public PropiedadServicio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId_propiedad() {
		return id_propiedad;
	}
	public void setId_propiedad(int id_propiedad) {
		this.id_propiedad = id_propiedad;
	}
	public int getId_servicio() {
		return id_servicio;
	}
	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}
}

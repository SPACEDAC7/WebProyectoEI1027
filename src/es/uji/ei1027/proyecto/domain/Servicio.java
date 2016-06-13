package es.uji.ei1027.proyecto.domain;

public class Servicio {
	private int idServicio;
	private String nombreServicio;
	public Servicio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Servicio(int idServicio, String nombreServicioo) {
		super();
		this.idServicio = idServicio;
		this.nombreServicio = nombreServicioo;
	}
	public int getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
	public String getNombreServicio() {
		return nombreServicio;
	}
	public void setNombreServicio(String nombreServicioo) {
		this.nombreServicio = nombreServicioo;
	}
	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", nombreServicioo=" + nombreServicio + "]";
	}
	
	
}

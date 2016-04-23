package es.uji.ei1027.proyecto.domain;

public class Puntuacion {
			
	public Puntuacion(int idPuntuacion, int idPropiedad, int idUsuario,
			int valorPuntuacion, String comentario) {
		super();
		this.idPuntuacion = idPuntuacion;
		this.idPropiedad = idPropiedad;
		this.idUsuario = idUsuario;
		this.valorPuntuacion = valorPuntuacion;
		this.comentario = comentario;
	}
	
	public Puntuacion() {
		super();
	}
	
	private int idPuntuacion;
	private int idPropiedad;
	private int idUsuario;
	private int valorPuntuacion;
	private String comentario;
	
	public int getIdPuntuacion() {
		return idPuntuacion;
	}
	public void setIdPuntuacion(int idPuntuacion) {
		this.idPuntuacion = idPuntuacion;
	}
	public int getIdPropiedad() {
		return idPropiedad;
	}
	public void setIdPropiedad(int idPropiedad) {
		this.idPropiedad = idPropiedad;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getValorPuntuacion() {
		return valorPuntuacion;
	}
	public void setValorPuntuacion(int valorPuntuacion) {
		this.valorPuntuacion = valorPuntuacion;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	@Override
	public String toString() {
		return "Puntuacion [idPuntuacion=" + idPuntuacion + ", idPropiedad=" + idPropiedad + ", idUsuario="
				+ idUsuario + ", valorPuntuacion=" + valorPuntuacion + ", comentario " + comentario + "]";
	}
	
	

}

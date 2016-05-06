package es.uji.ei1027.proyecto.domain;

public class Puntuacion {
	
	private int id_puntuacion;
	private int id_propiedad;
	private int id_usuario;
	private int valor_puntuacion;
	private String comentario;
	
	public Puntuacion(int idPuntuacion, int idPropiedad, int idUsuario,
			int valorPuntuacion, String comentario) {
		super();
		this.id_puntuacion = idPuntuacion;
		this.id_propiedad = idPropiedad;
		this.id_usuario = idUsuario;
		this.valor_puntuacion = valorPuntuacion;
		this.comentario = comentario;
	}
	
	public Puntuacion() {
		super();
	}
	
	public int getId_puntuacion() {
		return id_puntuacion;
	}
	public void setId_puntuacion(int idPuntuacion) {
		this.id_puntuacion = idPuntuacion;
	}
	public int getId_propiedad() {
		return id_propiedad;
	}
	public void setId_propiedad(int idPropiedad) {
		this.id_propiedad = idPropiedad;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int idUsuario) {
		this.id_usuario = idUsuario;
	}
	public int getValor_puntuacion() {
		return valor_puntuacion;
	}
	public void setValor_puntuacion(int valorPuntuacion) {
		this.valor_puntuacion = valorPuntuacion;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	@Override
	public String toString() {
		return "Puntuacion [idPuntuacion=" + id_puntuacion + ", idPropiedad=" + id_propiedad + ", idUsuario="
				+ id_usuario + ", valorPuntuacion=" + valor_puntuacion + ", comentario " + comentario + "]";
	}
	
	

}

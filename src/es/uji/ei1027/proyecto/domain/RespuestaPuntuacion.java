package es.uji.ei1027.proyecto.domain;

public class RespuestaPuntuacion {
	private int id_respuesta;
	private int id_puntuacion;
	private String respuesta;
	
	public RespuestaPuntuacion(int id_respuesta, int id_puntuacion, String respuesta) {
		super();
		this.id_respuesta = id_respuesta;
		this.id_puntuacion = id_puntuacion;
		this.respuesta = respuesta;
	}

	public RespuestaPuntuacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_respuesta() {
		return id_respuesta;
	}

	public void setId_respuesta(int id_respuesta) {
		this.id_respuesta = id_respuesta;
	}

	public int getId_puntuacion() {
		return id_puntuacion;
	}

	public void setId_puntuacion(int id_puntuacion) {
		this.id_puntuacion = id_puntuacion;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
	
}
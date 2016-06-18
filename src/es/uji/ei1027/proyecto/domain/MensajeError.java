package es.uji.ei1027.proyecto.domain;

public class MensajeError {
	
	public String mensaje;
	
	public MensajeError() {
		super();
	}
	
	public MensajeError(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}

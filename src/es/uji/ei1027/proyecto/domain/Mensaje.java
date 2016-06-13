package es.uji.ei1027.proyecto.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class Mensaje {
	private int id_mensaje;
	private int id_receptor;
	private int id_emisor;
	private String asunto;
	private String contenido;
	private int estado_vision;
	private Date fecha_mensaje;
	
	private String fechaMensaje;
	
	public Mensaje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mensaje(int id_mensaje, int id_receptor, int id_emisor, String asunto, String contenido, int estado_vision,
			Date fecha_mensaje) {
		super();
		this.id_mensaje = id_mensaje;
		this.id_receptor = id_receptor;
		this.id_emisor = id_emisor;
		this.asunto = asunto;
		this.contenido = contenido;
		this.estado_vision = estado_vision;
		this.fecha_mensaje = fecha_mensaje;
	}
	
	public void crearFechas() {
		//Convierte una fecha tipo String con el formato dd/mm/aaaa a una tipo Date
		ConvertidorDeFechas c = new ConvertidorDeFechas();
		fecha_mensaje = c.convertirFecha(fechaMensaje);
	}
	
	public void convertirDateADiaMesAno() {
		//Convierte una fecha tipo Date a una fecha tipo String con el formato dd/mm/aaaa
		ConvertidorDeFechas c = new ConvertidorDeFechas();
		fechaMensaje = c.convertirFecha(fecha_mensaje);
	}

	public int getId_mensaje() {
		return id_mensaje;
	}

	public void setId_mensaje(int id_mensaje) {
		this.id_mensaje = id_mensaje;
	}

	public int getId_receptor() {
		return id_receptor;
	}

	public void setId_receptor(int id_receptor) {
		this.id_receptor = id_receptor;
	}

	public int getId_emisor() {
		return id_emisor;
	}

	public void setId_emisor(int id_emisor) {
		this.id_emisor = id_emisor;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public int getEstado_vision() {
		return estado_vision;
	}

	public void setEstado_vision(int estado_vision) {
		this.estado_vision = estado_vision;
	}

	public Date getFecha_mensaje() {
		return fecha_mensaje;
	}

	public void setFecha_mensaje(String fecha_mensaje) {
		this.fecha_mensaje = Date.valueOf(fecha_mensaje);
	}

	public String getFechaMensaje() {
		return fechaMensaje;
	}

	public void setFechaMensaje(Date fechaMensaje) {
		this.fecha_mensaje = fechaMensaje;
	}

	@Override
	public String toString() {
		return "Mensaje [id_mensaje=" + id_mensaje + ", id_receptor=" + id_receptor + ", id_emisor=" + id_emisor
				+ ", asunto=" + asunto + ", contenido=" + contenido + ", estado_vision=" + estado_vision
				+ ", fecha_mensaje=" + fecha_mensaje + ", fechaMensaje=" + fechaMensaje + "]";
	}
	
	
}

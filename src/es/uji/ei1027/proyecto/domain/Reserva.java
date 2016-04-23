package es.uji.ei1027.proyecto.domain;

import java.sql.Date;

public class Reserva {

	private int idReserva;
	private int idUsuario;
	private int idPropiedad;
	private Date fechaReserva;
	private Date fechaCheckin;
	private Date fechaCheckout;
	private float precioReserva;
	private String estado;
	
	public Reserva(int idReserva, int idUsuario, int idPropiedad,
			Date fechaReserva, Date fechaCheckin, Date fechaCheckout,
			float precioReserva, String estado) {
		super();
		this.idReserva = idReserva;
		this.idUsuario = idUsuario;
		this.idPropiedad = idPropiedad;
		this.fechaReserva = fechaReserva;
		this.fechaCheckin = fechaCheckin;
		this.fechaCheckout = fechaCheckout;
		this.precioReserva = precioReserva;
		this.estado = estado;
	}
	
	public Reserva() {
		super();
	}
	
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdPropiedad() {
		return idPropiedad;
	}
	public void setIdPropiedad(int idPropiedad) {
		this.idPropiedad = idPropiedad;
	}
	public Date getFechaReserva() {
		return fechaReserva;
	}
	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
	public Date getFechaCheckin() {
		return fechaCheckin;
	}
	public void setFechaCheckin(Date fechaCheckin) {
		this.fechaCheckin = fechaCheckin;
	}
	public Date getFechaCheckout() {
		return fechaCheckout;
	}
	public void setFechaCheckout(Date fechaCheckout) {
		this.fechaCheckout = fechaCheckout;
	}
	public float getPrecioReserva() {
		return precioReserva;
	}
	public void setPrecioReserva(float precioReserva) {
		this.precioReserva = precioReserva;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", idUsuario=" + idUsuario + ", idPropiedad="
				+ idPropiedad + ", fechaReserva=" + fechaReserva.toString() + ", fechaCheckin=" + fechaCheckin.toString() + ", fechaCheckout=" + fechaCheckout.toString() 
				+ ", precioReserva=" + precioReserva + ", estado=" + estado + "]";
	}
	
}

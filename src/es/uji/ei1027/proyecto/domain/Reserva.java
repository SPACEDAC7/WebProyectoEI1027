package es.uji.ei1027.proyecto.domain;

import java.sql.Date;

public class Reserva {

	private int id_reserva;
	private int id_usuario;
	private int id_propiedad;
	private Date fecha_reserva;
	private Date fecha_checkin;
	private Date fecha_checkout;
	private float precio_reserva;
	private String estado;
	
	public Reserva(int idReserva, int idUsuario, int idPropiedad,
			Date fechaReserva, Date fechaCheckin, Date fechaCheckout,
			float precioReserva, String estado) {
		super();
		this.id_reserva = idReserva;
		this.id_usuario = idUsuario;
		this.id_propiedad = idPropiedad;
		this.fecha_reserva = fechaReserva;
		this.fecha_checkin = fechaCheckin;
		this.fecha_checkout = fechaCheckout;
		this.precio_reserva = precioReserva;
		this.estado = estado;
	}
	
	public Reserva() {
		super();
	}
	
	public int getId_reserva() {
		return id_reserva;
	}
	public void setId_reserva(int idReserva) {
		this.id_reserva = idReserva;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int idUsuario) {
		this.id_usuario = idUsuario;
	}
	public int getId_propiedad() {
		return id_propiedad;
	}
	public void setId_propiedad(int idPropiedad) {
		this.id_propiedad = idPropiedad;
	}
	public Date getFecha_reserva() {
		return fecha_reserva;
	}
	public void setFecha_reserva(Date fechaReserva) {
		this.fecha_reserva = fechaReserva;
	}
	public Date getFecha_checkin() {
		return fecha_checkin;
	}
	public void setFecha_checkin(Date fechaCheckin) {
		this.fecha_checkin = fechaCheckin;
	}
	public Date getFecha_checkout() {
		return fecha_checkout;
	}
	public void setFecha_checkout(Date fechaCheckout) {
		this.fecha_checkout = fechaCheckout;
	}
	public float getPrecio_reserva() {
		return precio_reserva;
	}
	public void setPrecio_reserva(float precioReserva) {
		this.precio_reserva = precioReserva;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Reserva [idReserva=" + id_reserva + ", idUsuario=" + id_usuario + ", idPropiedad="
				+ id_propiedad + ", fechaReserva=" + fecha_reserva.toString() + ", fechaCheckin=" + fecha_checkin.toString() + ", fechaCheckout=" + fecha_checkout.toString() 
				+ ", precioReserva=" + precio_reserva + ", estado=" + estado + "]";
	}
	
}

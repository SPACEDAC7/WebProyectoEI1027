package es.uji.ei1027.proyecto.domain;

import java.sql.Date;

public class Factura {
			
	private int idFactura;
	private int idReserva;
	private Date fechaFactura;
	private float precioFactura;
	private int iva;
	
	public Factura(int idFactura, int idReserva, Date fechaFactura,
			float precioFactura, int iva) {
		super();
		this.idFactura = idFactura;
		this.idReserva = idReserva;
		this.fechaFactura = fechaFactura;
		this.precioFactura = precioFactura;
		this.iva = iva;
	}
	
	public Factura() {
		super();
	}
	
	public int getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public Date getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	public float getPrecioFactura() {
		return precioFactura;
	}
	public void setPrecioFactura(float precioFactura) {
		this.precioFactura = precioFactura;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	
	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", idReserva=" + idReserva + ", fechaFactura="
				+ fechaFactura.toString() + ", precioFactura=" + precioFactura + ", iva=" + iva + "]";
	}
	
}

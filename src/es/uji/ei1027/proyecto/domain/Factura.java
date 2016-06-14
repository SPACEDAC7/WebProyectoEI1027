package es.uji.ei1027.proyecto.domain;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Factura {
			
	private int id_factura;
	private int id_reserva;
	private Date fecha_factura;
	private float precio_factura;
	public String getFechaString() {
		return fechaString;
	}

	public void setFechaString(String fechaString) {
		this.fechaString = fechaString;
	}

	private int iva;
	private String fechaString;
	
	public Factura(int id_factura, int id_reserva, Date fecha_factura,
			float precio_factura, int iva) {
		super();
		this.id_factura = id_factura;
		this.id_reserva = id_reserva;
		this.fecha_factura = fecha_factura;
		this.precio_factura = precio_factura;
		this.iva = iva;
	}
	
	public Factura() {
		super();
	}
	
	
	public void crearFecha() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			java.util.Date d = sdf.parse(this.fechaString);
			this.fecha_factura = new Date(d.getTime());
			System.out.println(this.fecha_factura);
		} catch (Exception ex) {
			System.out.println("Error de conversión " + ex.getMessage());
		}
	}
	
	public int getId_factura() {
		return id_factura;
	}

	public void setId_factura(int id_factura) {
		this.id_factura = id_factura;
	}

	public int getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}

	public Date getFecha_factura() {
		return fecha_factura;
	}

	public void setFecha_factura(Date fecha_factura) {
		this.fecha_factura = fecha_factura;
	}

	public float getPrecio_factura() {
		return precio_factura;
	}

	public void setPrecio_factura(float precio_factura) {
		this.precio_factura = precio_factura;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	@Override
	public String toString() {
		return "Factura [idFactura=" + id_factura + ", idReserva=" + id_reserva + ", fechaFactura="
				+ fecha_factura.toString() + ", precioFactura=" + precio_factura + ", iva=" + iva + "]";
	}

	
}

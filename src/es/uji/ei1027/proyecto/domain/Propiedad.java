package es.uji.ei1027.proyecto.domain;

public class Propiedad {
	
	private int id_propiedad;
	private int id_usuario;
	private String titulo;
	private String descripcion;
	private String tipo;
	private int capacidad;
	private int num_habitaciones;
	private int num_camas;
	private int area;
	private String servicios;
	private float precio_propiedad;
	private int id_direccion;
	private String url_mapa;
	
	public Propiedad(int id_propiedad, int id_usuario, String titulo,
			String descripcion, String tipo, int capacidad,
			int num_habitaciones, int num_camas, int area, String servicios,
			float precio_propiedad, int id_direccion, String url_mapa) {
		super();
		this.id_propiedad = id_propiedad;
		this.id_usuario = id_usuario;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.capacidad = capacidad;
		this.num_habitaciones = num_habitaciones;
		this.num_camas = num_camas;
		this.area = area;
		this.servicios = servicios;
		this.precio_propiedad = precio_propiedad;
		this.id_direccion = id_direccion;
		this.url_mapa = url_mapa;
	}
	
	public Propiedad() {
		super();
	}
	
	public int getId_propiedad() {
		return id_propiedad;
	}
	public void setId_propiedad(int id_propiedad) {
		this.id_propiedad = id_propiedad;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public int getNum_habitaciones() {
		return num_habitaciones;
	}
	public void setNum_habitaciones(int num_habitaciones) {
		this.num_habitaciones = num_habitaciones;
	}
	public int getNum_camas() {
		return num_camas;
	}
	public void setNum_camas(int num_camas) {
		this.num_camas = num_camas;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public String getServicios() {
		return servicios;
	}
	public void setServicios(String servicios) {
		this.servicios = servicios;
	}
	public float getPrecio_propiedad() {
		return precio_propiedad;
	}
	public void setPrecio_propiedad(float precio_propiedad) {
		this.precio_propiedad = precio_propiedad;
	}
	public int getId_direccion() {
		return id_direccion;
	}
	public void setId_direccion(int id_direccion) {
		this.id_direccion = id_direccion;
	}
	public String getUrl_mapa() {
		return url_mapa;
	}
	public void setUrl_mapa(String url_mapa) {
		this.url_mapa = url_mapa;
	}

	
	@Override
	public String toString() {
		return "Propiedad [id_propiedad=" + id_propiedad + ", id_usuario=" + id_usuario + ", titulo="
				+ titulo + ", descripcion=" + descripcion + ", tipo=" + tipo + ", capacidad=" + capacidad 
				+ ", num_habitaciones=" + num_habitaciones + ", num_camas=" + num_camas 
				+ ", area=" + area + ", servicios" + servicios + ", precio_pripiedad=" + precio_propiedad 
				+ "id_direccion=" + id_direccion + ", url_mapa" + url_mapa + "]";
	} 

}

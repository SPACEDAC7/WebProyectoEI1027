package es.uji.ei1027.proyecto.domain;

public class Buscador {
//No se si tenemos que meter aqui los servicios y las propiedades de la direccion
	private String tipo;
	private int capacidad;
	private int num_habitaciones;
	private int num_camas;
	private int area;
	private float precio_propiedad_minimo;
	private float precio_propiedad_maximo;
	private String localidad;
	private String provincia;
	
	public Buscador(String tipo, int capacidad,
			int num_habitaciones, int num_camas, int area, String localidad, String provincia,
			float precio_propiedad_minimo,float precio_propiedad_maximo, int id_direccion) {
		super();
		this.tipo = tipo;
		this.capacidad = capacidad;
		this.num_habitaciones = num_habitaciones;
		this.num_camas = num_camas;
		this.area = area;
		this.precio_propiedad_minimo = precio_propiedad_minimo;
		this.precio_propiedad_maximo = precio_propiedad_maximo;
		this.localidad = localidad;
		this.provincia = provincia;
	}
	
	public Buscador() {
		super();
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
	
	public String getCapacidadString() {
		if(capacidad == -1){
			return "%";
		}
		return ""+this.capacidad;
	}
	
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public int getNum_habitaciones() {
		return num_habitaciones;
	}
	public String getNumHabitacionesString() {
		if(num_habitaciones == -1){
			return "%";
		}
		return ""+this.num_habitaciones;
	}
	
	public void setNum_habitaciones(int num_habitaciones) {
		this.num_habitaciones = num_habitaciones;
	}
	
	public int getNum_camas() {
		return num_camas;
	}
	
	public String getNumcamasString() {
		if(num_camas == -1){
			return "%";
		}
		return ""+this.num_camas;
	}
	
	public void setNum_camas(int num_camas) {
		this.num_camas = num_camas;
	}
	public int getArea() {
		return area;
	}
	
	public String getAreaString() {
		if(area == -1){
			return "%";
		}
		return ""+this.num_camas;
	}
	
	public void setArea(int area) {
		this.area = area;
	}

	public float getPrecio_propiedad_minimo() {
		return precio_propiedad_minimo;
	}
	
	public float getPrecioMinimoString() {
		if(precio_propiedad_minimo == -1){
			return 0;
		}
		return this.precio_propiedad_minimo;
	}

	public void setPrecio_propiedad_minimo(float precio_propiedad_minimo) {
		this.precio_propiedad_minimo = precio_propiedad_minimo;
	}

	public float getPrecio_propiedad_maximo() {
		return precio_propiedad_maximo;
	}
	
	public float getPrecioMaximoString() {
		if(precio_propiedad_maximo == -1){
			return 9999999;
		}
		return this.precio_propiedad_maximo;
	}
	

	public void setPrecio_propiedad_maximo(float precio_propiedad_maximo) {
		this.precio_propiedad_maximo = precio_propiedad_maximo;
	}
	
	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	@Override
	public String toString() {
		return "BuscarPropiedad [tipo=" + tipo + ", capacidad=" + capacidad + ", num_habitaciones=" + num_habitaciones
				+ ", num_camas=" + num_camas + ", area=" + area + ", precio_propiedad_minimo=" + precio_propiedad_minimo
				+ ", precio_propiedad_maximo=" + precio_propiedad_maximo + ", id_direccion=" + "]";
	}
	
	public void arreglarBuscador() {
		if (this.localidad.equals(""))
			this.localidad = "%";
		if (this.tipo.equals(""))
			this.tipo="%";
		
	}

}

package es.uji.ei1027.proyecto.domain;

public class Direccion {
	private int id_direccion;
	private String calle;
	private int numero;
	private int codigo_postal;
	private String localidad;
	private String provincia;
	
	public Direccion() {
		super();
	}

	public Direccion(int id_direccion, String calle, int numero, int codigo_postal, String localidad,
			String provincia) {
		super();
		this.id_direccion = id_direccion;
		this.calle = calle;
		this.numero = numero;
		this.codigo_postal = codigo_postal;
		this.localidad = localidad;
		this.provincia = provincia;
	}

	public int getId_direccion() {
		return id_direccion;
	}

	public void setId_direccion(int id_direccion) {
		this.id_direccion = id_direccion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(int codigo_postal) {
		this.codigo_postal = codigo_postal;
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
		return "Calle " + this.getCalle() + " , " + this.getNumero() + 
				" C.P: " + this.getCodigo_postal() + 
				" Localidad: " + this.getLocalidad() + 
				" Provincia: " + this.getProvincia();
	} 
}


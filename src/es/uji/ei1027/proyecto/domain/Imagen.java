package es.uji.ei1027.proyecto.domain;

public class Imagen {
	private int id_imagen;
	private int id_propiedad;
	private String pie_foto;
	private String referencia;
	
	public Imagen() {
		super();
	}
	public Imagen(int id_imagen, int id_propiedad, String pie_foto, String referencia) {
		super();
		this.id_imagen = id_imagen;
		this.id_propiedad = id_propiedad;
		this.pie_foto = pie_foto;
		this.referencia = referencia;
	}
	public int getId_imagen() {
		return id_imagen;
	}
	public void setId_imagen(int id_imagen) {
		this.id_imagen = id_imagen;
	}
	public int getId_propiedad() {
		return id_propiedad;
	}
	public void setId_propiedad(int id_propiedad) {
		this.id_propiedad = id_propiedad;
	}
	public String getPie_foto() {
		return pie_foto;
	}
	public void setPie_foto(String pie_foto) {
		this.pie_foto = pie_foto;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	
}

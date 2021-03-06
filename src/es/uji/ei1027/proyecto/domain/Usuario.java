package es.uji.ei1027.proyecto.domain;

import java.sql.Date;

public class Usuario {

	private int id_usuario;
	private int id_credencial;
	private String url_imagen_perfil;
	private String nombre;
	private String apellido;
	private String nif;
	private String email;
	private int id_direccion;
	private Date fecha_registro;
	private String telefono;
	private boolean estado_usuario;
	//Tengo que poner en la base de datos que sea un varchar(20)
	//Esto es una prueba a ver que pasaa
	
	private String fechaRegistro;
	
	public Usuario() {
		super();
	}
	
	public Usuario(int id_usuario, int id_credencial,String url_imagen_perfil, String nombre,
			String apellido, String nif, String email, int id_direccion,
			Date fecha_registro, String telefono, boolean estado_usuario) {
		super();
		this.id_usuario = id_usuario;
		this.id_credencial = id_credencial;
		this.url_imagen_perfil = url_imagen_perfil;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nif = nif;
		this.email = email;
		this.id_direccion = id_direccion;
		this.fecha_registro = fecha_registro;
		this.telefono = telefono;
		this.estado_usuario = estado_usuario;
	}	
	
	public void crearFechas() {
		//Convierte una fecha tipo String con el formato dd/mm/aaaa a una tipo Date
		ConvertidorDeFechas c = new ConvertidorDeFechas();
		fecha_registro = c.convertirFecha(fechaRegistro);
	}
	
	public void convertirDateADiaMesAno() {
		//Convierte una fecha tipo Date a una fecha tipo String con el formato dd/mm/aaaa
		ConvertidorDeFechas c = new ConvertidorDeFechas();
		fechaRegistro = c.convertirFecha(fecha_registro);
	}
	
	
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getId_credencial() {
		return id_credencial;
	}

	public void setId_credencial(int id_credencial) {
		this.id_credencial = id_credencial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId_direccion() {
		return id_direccion;
	}

	public void setId_direccion(int id_direccion) {
		this.id_direccion = id_direccion;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fechaRegistro) {
		this.fecha_registro = fechaRegistro;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public boolean getEstado_usuario() {
		return estado_usuario;
	}

	public void setEstado_usuario(boolean estado_usuario) {
		this.estado_usuario = estado_usuario;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + id_usuario + ", idCredencial=" + id_credencial + " , url Imagen PErfil : " + url_imagen_perfil +", nombre="
				+ nombre + ", apellido=" + apellido + ", nif=" + nif + ", email=" + email 
				+ ", idDireccion=" + id_direccion + ", fechaRegistro=" + fecha_registro.toString() 
				+ ", telefono=" + telefono + ", estadoUsuario" + estado_usuario + "]";
	}

	public String getUrl_imagen_perfil() {
		return url_imagen_perfil;
	}

	public void setUrl_imagen_perfil(String url_imagen_perfil) {
		this.url_imagen_perfil = url_imagen_perfil;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	private Date fechaDeHoy() {
		java.util.Date fecha = new java.util.Date();
		Date fechaSQL = new Date(fecha.getTime());
		return fechaSQL;
		
	}
	
	
}

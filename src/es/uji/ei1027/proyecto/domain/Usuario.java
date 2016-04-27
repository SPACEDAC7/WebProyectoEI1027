package es.uji.ei1027.proyecto.domain;

import java.sql.Date;

public class Usuario {

	private int id_usuario;
	private int id_credencial;
	private String nombre;
	private String apellido;
	private String nif;
	private String email;
	private int id_direccion;
	private Date fechaRegistro;
	private int telefono;
	private boolean estadoUsuario;
	
	public Usuario() {
		super();
	}
	
	public Usuario(int idUsuario, int idCredencial, String nombre,
			String apellido, String nif, String email, int idDireccion,
			Date fechaRegistro, int telefono, boolean estadoUsuario) {
		super();
		this.id_usuario = idUsuario;
		this.id_credencial = idCredencial;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nif = nif;
		this.email = email;
		this.id_direccion = idDireccion;
		this.fechaRegistro = fechaRegistro;
		this.telefono = telefono;
		this.estadoUsuario = estadoUsuario;
	}	
	
	public int getIdUsuario() {
		return id_usuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.id_usuario = idUsuario;
	}
	public int getIdCredencial() {
		return id_credencial;
	}
	public void setIdCredencial(int idCredencial) {
		this.id_credencial = idCredencial;
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
	public int getIdDireccion() {
		return id_direccion;
	}
	public void setIdDireccion(int idDireccion) {
		this.id_direccion = idDireccion;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public boolean getEstadoUsuario() {
		return estadoUsuario;
	}
	public void setEstadoUsuario(boolean estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}
	
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + id_usuario + ", idCredencial=" + id_credencial + ", nombre="
				+ nombre + ", apellido=" + apellido + ", nif=" + nif + ", email=" + email 
				+ ", idDireccion=" + id_direccion + ", fechaRegistro=" + fechaRegistro.toString() 
				+ ", telefono=" + telefono + ", estadoUsuario" + estadoUsuario + "]";
	}
	
	
}

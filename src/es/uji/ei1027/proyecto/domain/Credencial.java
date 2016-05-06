package es.uji.ei1027.proyecto.domain;

public class Credencial {
	private int id_credencial;
	private String nick_usuario;
	private String password;
	private String rol;
	
	public Credencial(int id_credencial, String nick_usuario, String password, String rol) {
		super();
		this.id_credencial = id_credencial;
		this.nick_usuario = nick_usuario;
		this.password = password;
		this.rol = rol;
	}
	 
	public Credencial() {
		super();
	}
	
	public int getId_credencial() {
		return id_credencial;
	}
	
	public void setId_credencial(int id_credencial) {
		this.id_credencial = id_credencial;
	}
	public String getNick_usuario() {
		return nick_usuario;
	}
	public void setNick_usuario(String nick_usuario) {
		this.nick_usuario = nick_usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
		
}

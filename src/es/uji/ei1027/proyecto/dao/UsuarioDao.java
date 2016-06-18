package es.uji.ei1027.proyecto.dao;

import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.proyecto.domain.Usuario;

@Repository
public class UsuarioDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private static final class UsuarioMapper implements RowMapper<Usuario>{
		public Usuario mapRow(ResultSet rs, int rowNum)throws SQLException{
			Usuario usuario = new Usuario();
			usuario.setId_usuario(rs.getInt("id_usuario"));
			usuario.setId_credencial(rs.getInt("id_credencial"));
			usuario.setUrl_imagen_perfil(rs.getString("url_imagen_perfil"));
			usuario.setNombre(rs.getString("nombre"));
			usuario.setApellido(rs.getString("apellido"));
			usuario.setNif(rs.getString("nif"));
			usuario.setEmail(rs.getString("email"));
			usuario.setId_direccion(rs.getInt("id_direccion"));
			usuario.setFecha_registro(rs.getDate("fecha_registro"));
			usuario.setTelefono(rs.getString("telefono"));
			usuario.setEstado_usuario(rs.getBoolean("estado_usuario"));
			return usuario;
		}
	}
	public List<Usuario> getUsuarios() {
		return this.jdbcTemplate.query("select id_usuario, id_credencial,url_imagen_perfil, nombre"
					+ ", apellido, nif, email, id_direccion, fecha_registro, telefono"
					+ ", estado_usuario from usuario", new UsuarioMapper());
	}
	
	public Usuario getUsuario(int id_usuario) {
		return this.jdbcTemplate.queryForObject("select id_usuario, id_credencial,url_imagen_perfil, nombre"
					+ ", apellido, nif, email, id_direccion, fecha_registro, telefono"
					+ ", estado_usuario from usuario where id_usuario=?;", new Object[] {id_usuario}, new UsuarioMapper());
	}
	
	public Usuario getUsuarioPorIdCredencial(int idCredencial) {
		return this.jdbcTemplate.queryForObject("select id_usuario, id_credencial, url_imagen_perfil, nombre"
					+ ", apellido, nif, email, id_direccion, fecha_registro, telefono"
					+ ", estado_usuario from usuario where id_credencial=?", new Object[] {idCredencial}, new UsuarioMapper());
	}
	
	
	public void addUsuario(Usuario usuario) {
		this.jdbcTemplate.update(
					"insert into usuario(id_usuario, id_credencial,url_imagen_perfil, nombre"
					+ ", apellido, nif, email, id_direccion, fecha_registro, telefono"
					+ ", estado_usuario) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
					usuario.getId_usuario(),usuario.getId_credencial(),
					usuario.getUrl_imagen_perfil(),usuario.getNombre(),usuario.getApellido(),
					usuario.getNif(),usuario.getEmail(),
					usuario.getId_direccion(),usuario.getFecha_registro(),
					usuario.getTelefono(),usuario.getEstado_usuario());
	}
	
	
	public void updateUsuario(Usuario usuario) {
		this.jdbcTemplate.update("update usuario "
					+ "set id_credencial = ?,url_imagen_perfil = ?,nombre = ?,"
					+ "apellido = ?,nif = ?,"
					+ "email = ?,id_direccion = ?,"
					+ "fecha_registro = ?,telefono = ?,"
					+ "estado_usuario = ? where id_usuario = ?",
					usuario.getId_credencial(), usuario.getUrl_imagen_perfil(),usuario.getNombre(),usuario.getApellido(),
					usuario.getNif(),usuario.getEmail(),
					usuario.getId_direccion(),usuario.getFecha_registro(),
					usuario.getTelefono(),usuario.getEstado_usuario(),
					usuario.getId_usuario());
	}
	
	public void deleteUsuario(Usuario usuario) {
		this.jdbcTemplate.update("DELETE FROM usuario WHERE id_usuario=?", usuario.getId_usuario());
	}
	
	public void deleteUsuario(int idUsuario) {
		this.jdbcTemplate.update("DELETE FROM usuario WHERE id_usuario=?", idUsuario);
	}
	
	public int nuevoIdUsuario() {
		//Consulta cual es el último id_usuario y devuelve ese número +1 para un nuevo usuario
		String sql = "SELECT MAX(id_usuario) from usuario";
		int max;
		try {
			max = this.jdbcTemplate.queryForObject(sql, Integer.class);
		} catch (NullPointerException ex) {
			max = -1;
		}
		return max+1;
	}
	
	public int contarUsuariosConIdCredencial( int idCredencial ) {
		String sql = "SELECT COUNT(id_credencial) from usuario WHERE id_credencial = ?";
		int num;
		try {
			num = this.jdbcTemplate.queryForObject(sql, Integer.class, idCredencial);
		} catch ( Exception ex ) {
			num = -1;
		}
		
		return num;
		
	}
	
}

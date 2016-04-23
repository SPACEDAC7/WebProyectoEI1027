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
			usuario.setIdUsuario(rs.getInt("id_usuario"));
			usuario.setIdCredencial(rs.getInt("id_credencial"));
			usuario.setNombre(rs.getString("nombre"));
			usuario.setApellido(rs.getString("apellido"));
			usuario.setNif(rs.getString("nif"));
			usuario.setEmail(rs.getString("email"));
			usuario.setIdDireccion(rs.getInt("id_direccion"));
			usuario.setFechaRegistro(rs.getDate("fecha_registro"));
			usuario.setTelefono(rs.getInt("telefono"));
			usuario.setEstadoUsuario(rs.getBoolean("estado_usuario"));
			return usuario;
		}
	}
	public List<Usuario> getUsuarios() {
		return this.jdbcTemplate.query("select id_usuario, id_credencial, nombre"
					+ ", apellido, nif, email, id_direccion, fecha_registro, telefono"
					+ ", estado_usuario from usuario", new UsuarioMapper());
	}
	
	public Usuario getUsuario(int id_usuario) {
		return this.jdbcTemplate.queryForObject("select id_usuario, id_credencial, nombre"
					+ ", apellido, nif, email, id_direccion, fecha_registro, telefono"
					+ ", estado_usuario from usuario where id_usuario=?;", new Object[] {id_usuario}, new UsuarioMapper());
	}
	
	
	public void addUsuario(Usuario usuario) {
		this.jdbcTemplate.update(
					"insert into usuario(id_usuario, id_credencial, nombre"
					+ ", apellido, nif, email, id_direccion, fecha_registro, telefono"
					+ ", estado_usuario) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
					usuario.getIdUsuario(),usuario.getIdCredencial(),
					usuario.getNombre(),usuario.getApellido(),
					usuario.getNif(),usuario.getEmail(),
					usuario.getIdDireccion(),usuario.getFechaRegistro(),
					usuario.getTelefono(),usuario.getEstadoUsuario());
	}
	
	
	public void updateUsuario(Usuario usuario) {
		this.jdbcTemplate.update("update usuario "
					+ "set id_credencial = ?,nombre = ?,"
					+ "apellido = ?,nif = ?,"
					+ "email = ?,id_direccion = ?,"
					+ "fecha_registro = ?,telefono = ?,"
					+ "estado_usuario = ? where id_usuario = ?",
					usuario.getIdCredencial(),usuario.getNombre(),usuario.getApellido(),
					usuario.getNif(),usuario.getEmail(),
					usuario.getIdDireccion(),usuario.getFechaRegistro(),
					usuario.getTelefono(),usuario.getEstadoUsuario(),
					usuario.getIdUsuario());
	}
	
	public void deleteUsuario(Usuario usuario) {
		this.jdbcTemplate.update("DELETE FROM usuario WHERE id_usuario=?", usuario.getIdUsuario());
	}
	
	public void deleteUsuario(int idUsuario) {
		this.jdbcTemplate.update("DELETE FROM usuario WHERE id_usuario=?", idUsuario);
	}
	
}

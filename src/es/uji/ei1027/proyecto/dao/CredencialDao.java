package es.uji.ei1027.proyecto.dao;

import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;

import javax.sql.DataSource;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.util.NestedServletException;

import es.uji.ei1027.proyecto.domain.Credencial;

@Repository
public class CredencialDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private static final class CredencialMapper implements RowMapper<Credencial>{
		public Credencial mapRow(ResultSet rs, int rowNum) throws SQLException{
			Credencial credencial = new Credencial();
			credencial.setId_credencial(rs.getInt("id_credencial"));
			credencial.setNick_usuario(rs.getString("nick_usuario"));
			credencial.setPassword(rs.getString("password"));
			credencial.setRol(rs.getString("rol"));
			return credencial;
		}
	
	}
	//No se si esto es util o no y no se hasta que punto debemos ense�ar la contrase�a SEGURIDAD
	public List<Credencial> getCredenciales(){
		return this.jdbcTemplate.query("select id_credencial,nick_usuario, password,rol from credencial", new CredencialMapper());
	}
	
	public Credencial getCredencial(int id_credencial) {
		return this.jdbcTemplate.queryForObject("SELECT id_credencial, nick_usuario, password, rol FROM credencial WHERE id_credencial = ?",  new Object[] {id_credencial}, new CredencialMapper()); 
	}
	
	
	public void addCredencial(Credencial credencial) {
		//BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		//credencial.setPassword(passwordEncryptor.encryptPassword(credencial.getPassword()));
		this.jdbcTemplate.update("insert into credencial(id_credencial, nick_usuario, password , rol) values(?, ?, ?, ?)", credencial.getId_credencial(), credencial.getNick_usuario(),credencial.getPassword(),credencial.getRol());
	}
	
	public String getPassword(String nombreUsuario) {
		String sql = "SELECT password FROM credencial WHERE nick_usuario = ?";
		String retorno;
		try {
			retorno = this.jdbcTemplate.queryForObject(sql,  new Object[] {nombreUsuario}, String.class);
		} catch (Exception ex) {
			retorno = null;
		}
		return retorno;
	}
	
	public void updateCredencial(Credencial credencial) {
		this.jdbcTemplate.update("update Credencial set nick_usuario = ?, password = ?, rol = ? where id_credencial = ?", credencial.getNick_usuario(),credencial.getPassword(),credencial.getRol(),credencial.getId_credencial());
	}
	public void deleteCredencial(Credencial credencial) {
		this.jdbcTemplate.update("DELETE FROM Credencial WHERE id_credencial = ?", credencial.getId_credencial());
	}
	
	public void deleteCredencial(int id_credencial) {
		this.jdbcTemplate.update("DELETE FROM Credencial WHERE id_credencial = ?", id_credencial);
	}
	
	public int getIdCredencialAPartirDeNombre(String nombreUsuario) {
		int id_credencial;
		String sql = "SELECT id_credencial FROM credencial WHERE nick_usuario = ?";
		try {
			id_credencial = this.jdbcTemplate.queryForObject(sql , Integer.class, nombreUsuario);
		} catch (EmptyResultDataAccessException ex) {
			//Salta esta excepción cuando el usuario no está en la base de datos
			id_credencial = -1;
		}
		
		return id_credencial;
	}
	
	public int nuevoIdCredencial() {
		//Consulta cual es el último id_credencial y devuelve ese número +1 para una nueva credencial
		String sql = "SELECT MAX(id_credencial) from credencial";
		int max;
		try {
			max = this.jdbcTemplate.queryForObject(sql, Integer.class);
		} catch (NullPointerException ex) {
			max = -1;
		}
		return max+1;
	}
	
	public String getRolPorIdCredencial(int idCredencial) {
		String sql = "SELECT rol FROM credencial WHERE id_credencial = ?";
		String rol;
		try {
			rol = this.jdbcTemplate.queryForObject(sql,  new Object[] {idCredencial}, String.class);
		} catch (Exception ex) {
			rol = null;
		}
		return rol;
	}
	
	public boolean existeCredencialConEsteNombre(String nombre) {
		int id_credencial;
		String sql = "SELECT id_credencial FROM credencial WHERE nick_usuario = ?";
		try {
			id_credencial = this.jdbcTemplate.queryForObject(sql , Integer.class, nombre);
		} catch (EmptyResultDataAccessException ex) {
			//Salta esta excepción cuando el usuario no está en la base de datos
			id_credencial = -1;
		}
		if ( id_credencial == -1 )
			return false;
		else
			return true;
	}
	
	public int idUsuarioAPartirDeIdCredencial(int idCredencial) {
		String sql = "SELECT id_usuario from credencial WHERE id_credencial = ?";
		return this.jdbcTemplate.queryForObject(sql, Integer.class, idCredencial);
	}
	
}

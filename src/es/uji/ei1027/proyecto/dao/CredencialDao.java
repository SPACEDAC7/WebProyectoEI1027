package es.uji.ei1027.proyecto.dao;

import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.proyecto.domain.Credencial;

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
	//No se si esto es util o no y no se hasta que punto debemos enseñar la contraseña SEGURIDAD
	public List<Credencial> getCredenciales(){
		return this.jdbcTemplate.query("select id_credencial,nick_usuario, password,rol from credencial", new CredencialMapper());
	}
	
	public Credencial getCredencial(int id_credencial) {
		return this.jdbcTemplate.queryForObject("SELECT id_credencial, nick_usuario, password, rol FROM credencial WHERE id_credencial = ?",  new Object[] {id_credencial}, new CredencialMapper()); 
	}
	
	
	public void addCredencial(Credencial credencial) {
		this.jdbcTemplate.update("insert into credencial(id_credencial, nick_usuario, password , rol) values(?, ?, ?, ?)", credencial.getId_credencial(), credencial.getNick_usuario(),credencial.getPassword(),credencial.getRol());
	}
	
	public void updateCredencial(Credencial credencial) {
		this.jdbcTemplate.update("update Credencial set nick_usuario = ?, password = ?, rol = ? where id_credencial = ?", credencial.getNick_usuario(),credencial.getPassword(),credencial.getRol(),credencial.getId_credencial());
	}
	//No se si deberiamos borrar con un argumento credencial o con un argumento int id_credencial
	public void deleteCredencial(Credencial credencial) {
		this.jdbcTemplate.update("DELETE FROM Credencial WHERE id_credencial = ?", credencial.getId_credencial());
	}
	
}

package es.uji.ei1027.proyecto.dao;

import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.proyecto.domain.RespuestaPuntuacion;

@Repository
public class RespuestaPuntuacionDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private static final class RespuestaPuntuacionMapper implements RowMapper<RespuestaPuntuacion>{
		public RespuestaPuntuacion mapRow(ResultSet rs, int rowNum) throws SQLException{
			RespuestaPuntuacion respuestaPuntuacion = new RespuestaPuntuacion();
			respuestaPuntuacion.setId_respuesta(rs.getInt("id_respuesta"));
			respuestaPuntuacion.setId_puntuacion(rs.getInt("id_puntuacion"));
			respuestaPuntuacion.setRespuesta(rs.getString("respuesta"));
			return respuestaPuntuacion;
		}
	}
	
	public List<RespuestaPuntuacion> getRespuestasPuntuaciones() {
		return this.jdbcTemplate.query("select id_respuesta, id_puntuacion, respuesta from RespuestaPuntuacion", new RespuestaPuntuacionMapper());
	}
	
	public RespuestaPuntuacion getRespuestaPuntuacion(int id_respuesta) {
		return this.jdbcTemplate.queryForObject("select id_respuesta, id_puntuacion, respuesta from RespuestaPuntuacion where id_respuesta=?;", new Object[] {id_respuesta}, new RespuestaPuntuacionMapper());
	}
	
	public void addRespuestaPuntuacion(RespuestaPuntuacion respuestaPuntuacion) {
		this.jdbcTemplate.update("insert into RespuestaPuntuacion(id_respuesta, id_puntuacion, respuesta) values(?, ?, ?)",
				respuestaPuntuacion.getId_respuesta(),
				respuestaPuntuacion.getId_puntuacion(),
				respuestaPuntuacion.getRespuesta());
	}
	
	public void updateRespuestaPuntuacion(RespuestaPuntuacion respuestaPuntuacion) {
		this.jdbcTemplate.update(
					"update RespuestaPuntuacion set id_respuesta = ?,"
					+ "id_puntuacion = ?,respuesta = ?,"
					+ "where id_respuesta = ?",
					respuestaPuntuacion.getId_respuesta(),
					respuestaPuntuacion.getId_puntuacion(),
					respuestaPuntuacion.getRespuesta());
	}
	
	public void deleteRespuestaPuntuacion(RespuestaPuntuacion respuestaPuntuacion) {
		this.jdbcTemplate.update("DELETE FROM RespuestaPuntuacion WHERE id_respuesta=?", respuestaPuntuacion.getId_respuesta());
	}
	
	public void deleteRespuestaPuntuacion(int idRespuesta) {
		this.jdbcTemplate.update("DELETE FROM RespuestaPuntuacion WHERE id_respuesta=?", idRespuesta);
	}
}
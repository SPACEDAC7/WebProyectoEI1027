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
		return this.jdbcTemplate.query("select id_respuesta, id_puntuacion, respuesta from respuesta_puntuacion", new RespuestaPuntuacionMapper());
	}
	
	public List<RespuestaPuntuacion> getRespuestas(int id_puntuacion){
		return this.jdbcTemplate.query("select id_respuesta, id_puntuacion, respuesta from respuesta_puntuacion where id_puntuacion = ?", new RespuestaPuntuacionMapper(), id_puntuacion);
	}
	
	public RespuestaPuntuacion getRespuestaPuntuacion(int id_respuesta) {
		return this.jdbcTemplate.queryForObject("select id_respuesta, id_puntuacion, respuesta from respuesta_puntuacion where id_respuesta=?;", new Object[] {id_respuesta}, new RespuestaPuntuacionMapper());
	}
	
	public void addRespuestaPuntuacion(RespuestaPuntuacion respuestaPuntuacion) {
		this.jdbcTemplate.update("insert into respuesta_puntuacion(id_respuesta, id_puntuacion, respuesta) values(?, ?, ?)",
				respuestaPuntuacion.getId_respuesta(),
				respuestaPuntuacion.getId_puntuacion(),
				respuestaPuntuacion.getRespuesta());
	}
	
	public void updateRespuestaPuntuacion(RespuestaPuntuacion respuestaPuntuacion) {
		this.jdbcTemplate.update(
					"update respuesta_puntuacion set "
					+ "id_puntuacion = ?,respuesta = ? "
					+ "where id_respuesta = ?",
					respuestaPuntuacion.getId_puntuacion(),
					respuestaPuntuacion.getRespuesta(),
					respuestaPuntuacion.getId_respuesta());
	}
	
	public void deleteRespuestaPuntuacion(RespuestaPuntuacion respuestaPuntuacion) {
		this.jdbcTemplate.update("DELETE FROM respuesta_puntuacion WHERE id_respuesta=?", respuestaPuntuacion.getId_respuesta());
	}
	
	public void deleteRespuestaPuntuacion(int idRespuesta) {
		this.jdbcTemplate.update("DELETE FROM respuesta_puntuacion WHERE id_respuesta=?", idRespuesta);
	}
	
	public int nuevoIdRespuestaPuntuacion() {
		//Consulta cual es el último id_propiedad y devuelve ese número +1 para una nueva propiedad
		String sql = "SELECT MAX(id_respuesta) from respuesta_puntuacion";
		int max;
		try {
			max = this.jdbcTemplate.queryForObject(sql, Integer.class);
		} catch (NullPointerException ex) {
			max = -1;
		}
		return max+1;
	}
	
	
}
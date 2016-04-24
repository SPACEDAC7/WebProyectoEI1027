package es.uji.ei1027.proyecto.dao;

import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.proyecto.domain.Puntuacion;

@Repository
public class PuntuacionDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private static final class PuntuacionMapper implements RowMapper<Puntuacion>{
		public Puntuacion mapRow(ResultSet rs, int rowNum) throws SQLException{
			Puntuacion puntuacion = new Puntuacion();
			puntuacion.setIdPuntuacion(rs.getInt("id_puntuacion"));
			puntuacion.setIdPropiedad(rs.getInt("id_propiedad"));
			puntuacion.setIdUsuario(rs.getInt("id_usuario"));
			puntuacion.setValorPuntuacion(rs.getInt("valor_puntuacion"));
			puntuacion.setComentario(rs.getString("comentario"));
			return puntuacion;
		}
	}
	
	public List<Puntuacion> getPuntuaciones() {
		return this.jdbcTemplate.query("select id_puntuacion, id_propiedad"
					+ ", id_usuario, valor_puntuacion, comentario from puntuacion", new PuntuacionMapper());
	}
	
	public List<Puntuacion> getPuntuacionesDePropiedad(int id_propiedad) {
		return this.jdbcTemplate.query("select id_puntuacion, id_propiedad"
					+ ", id_usuario, valor_puntuacion, comentario from puntuacion where id_propiedad=?",/* new Object[] {id_propiedad},*/ new PuntuacionMapper());
	}
	
	public Puntuacion getPuntuacion(int id_puntuacion) {
		return this.jdbcTemplate.queryForObject("select id_puntuacion, id_propiedad, id_usuario"
					+ ", valor_puntuacion, comentario from puntuacion where id_puntuacion=?;", new Object[] {id_puntuacion}, new PuntuacionMapper());
	}
	
	public void addPuntuacion(Puntuacion puntuacion) {
		this.jdbcTemplate.update("insert into puntuacion(id_puntuacion, id_propiedad, id_usuario"
					+ ", valor_puntuacion, comentario) values(?, ?, ?, ?, ?)",
					 puntuacion.getIdPuntuacion(),
					 puntuacion.getIdPropiedad(),
					 puntuacion.getIdUsuario(),
					 puntuacion.getValorPuntuacion(),
					 puntuacion.getComentario());
	}
	
	public void updatePuntuacion(Puntuacion puntuacion) {
		this.jdbcTemplate.update("update puntuacion "
					+ "set id_propiedad = ?,"
					+ "id_usuario = ?,"
					+ "valor_puntuacion = ?,"
					+ "comentario = ? "
					+ "where id_puntuacion = ?",
					puntuacion.getIdPropiedad(),
					puntuacion.getIdUsuario(),
					puntuacion.getValorPuntuacion(),
					puntuacion.getComentario(),
					puntuacion.getIdPuntuacion());
	}
	
	public void deletePuntuacion(Puntuacion puntuacion) {
		this.jdbcTemplate.update("DELETE FROM puntuacion WHERE id_puntuacion=?", puntuacion.getIdPuntuacion());
	}
	
	public void deletePuntuacion(int id_puntuacion) {
		this.jdbcTemplate.update("DELETE FROM puntuacion WHERE id_puntuacion=?", id_puntuacion);
	}
}
package es.uji.ei1027.proyecto.dao;

import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.proyecto.domain.Mensaje;

@Repository
public class MensajeDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private static final class MensajeMapper implements RowMapper<Mensaje>{
		public Mensaje mapRow(ResultSet rs, int rowNum)throws SQLException{
			Mensaje mensaje = new Mensaje();
			mensaje.setId_mensaje(rs.getInt("id_mensaje"));
			mensaje.setId_receptor(rs.getInt("id_receptor"));
			mensaje.setId_emisor(rs.getInt("id_emisor"));
			mensaje.setAsunto(rs.getString("asunto"));
			mensaje.setContenido(rs.getString("contenido"));
			mensaje.setFecha_mensaje(rs.getDate("fecha_mensaje"));
			mensaje.setEstado_vision(rs.getInt("estado_vision"));
			return mensaje;
		}
	}
	
	public List<Mensaje> getMensajes() {
		return this.jdbcTemplate.query("select id_mensaje, id_receptor,id_emisor, asunto"
					+ ", contenido,estado_vision,fecha_mensaje from mensaje", new MensajeMapper());
	}
	
	public Mensaje getMensaje(int id_mensaje) {
		return this.jdbcTemplate.queryForObject("select id_mensaje, id_receptor,id_emisor, asunto"
					+ ", contenido, estado_vision, fecha_mensaje from mensaje where id_mensaje=?;", new Object[] {id_mensaje}, new MensajeMapper());
	}
	
	public void addMensaje(Mensaje mensaje) {
		this.jdbcTemplate.update(
					"insert into mensaje(id_mensaje, id_receptor,id_emisor, asunto"
					+ ", contenido, estado_vision, fecha_mensaje) values(?, ?, ?, ?, ?, ?, ?)",
					mensaje.getId_mensaje(),mensaje.getId_receptor(),mensaje.getId_emisor(),
					mensaje.getAsunto(),mensaje.getContenido(),mensaje.getEstado_vision(),
					mensaje.getFecha_mensaje());
	}
	
	
	public void updateMensaje(Mensaje mensaje) {
		this.jdbcTemplate.update("update mensaje "
					+ "set id_receptor = ?,id_emisor = ?,asunto = ?,"
					+ "contenido = ?,estado_vision = ?,"
					+ "fecha_mensaje = ? where id_mensaje = ?",
					mensaje.getId_receptor(),mensaje.getId_emisor(),
					mensaje.getAsunto(),mensaje.getContenido(),mensaje.getEstado_vision(),
					mensaje.getFecha_mensaje(),mensaje.getId_mensaje());
	}
	
	public void deleteMensaje(Mensaje mensaje) {
		this.jdbcTemplate.update("DELETE FROM mensaje WHERE id_mensaje=?", mensaje.getId_mensaje());
	}
	
	public void deleteMensaje(int idMensaje) {
		this.jdbcTemplate.update("DELETE FROM mensaje WHERE id_mensaje=?", idMensaje);
	}
	
	public int nuevoIdMensaje() {
		String sql = "SELECT MAX(id_mensaje) from mensaje";
		int max;
		try {
			max = this.jdbcTemplate.queryForObject(sql, Integer.class);
		} catch (NullPointerException ex) {
			max = -1;
		}
		return max+1;
	}
}

package es.uji.ei1027.proyecto.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.proyecto.domain.Servicio;

@Repository
public class ServicioDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private static final class ServicioMapper implements RowMapper<Servicio>{
		public Servicio mapRow(ResultSet rs, int rowNum)throws SQLException{
			Servicio servicio = new Servicio();
			servicio.setIdServicio(rs.getInt("id_servicio"));
			servicio.setNombreServicio(rs.getString("nombre_servicio"));
			return servicio;
		}
	}
	
	public List<Servicio> getServicios() {
		return this.jdbcTemplate.query("select id_servicio, nombre_servicio from servicio", new ServicioMapper());
	}
	
	public Servicio getServicio(int id_servicio) {
		return this.jdbcTemplate.queryForObject("select id_servicio, nombre_servicio from servicio where id_servicio=?;", new Object[] {id_servicio}, new ServicioMapper());
	}
	
	
	public void addServicio(Servicio servicio) {
		this.jdbcTemplate.update(
					"insert into servicio(id_servicio, nombre_servicio)"
					+ " values(?,?)",
					servicio.getIdServicio(), servicio.getNombreServicio());
	}
	
	
	public void updateServicio(Servicio servicio) {
		this.jdbcTemplate.update("update servicio "
					+ "set nombre_servicio = ? where id_servicio = ?",
					servicio.getNombreServicio(), servicio.getIdServicio());
	}
	
	public void deleteServicio(Servicio servicio) {
		this.jdbcTemplate.update("DELETE FROM servicio WHERE id_servicio=?", servicio.getIdServicio());
	}
	
	public void deleteServicio(int idServicio) {
		this.jdbcTemplate.update("DELETE FROM servicio WHERE id_servicio=?", idServicio);
	}
	
	public int nuevoIdServicio() {
		//Consulta cual es el último id_servicio y devuelve ese número +1 para un nuevo servicio
		String sql = "SELECT MAX(id_servicio) from servicio";
		int max;
		try {
			max = this.jdbcTemplate.queryForObject(sql, Integer.class);
		} catch (NullPointerException ex) {
			max = -1;
		}
		
		return max+1;
	}
	
}

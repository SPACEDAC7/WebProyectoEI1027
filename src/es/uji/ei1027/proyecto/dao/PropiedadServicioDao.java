package es.uji.ei1027.proyecto.dao;

import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.proyecto.domain.PropiedadServicio;

@Repository
public class PropiedadServicioDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private static final class PropiedadServicioMapper implements RowMapper<PropiedadServicio>{
		public PropiedadServicio mapRow(ResultSet rs, int rowNum) throws SQLException{
			PropiedadServicio propiedadServicio = new PropiedadServicio();
			propiedadServicio.setId_propiedad(rs.getInt("id_propiedad"));
			propiedadServicio.setId_servicio(rs.getInt("id_servicio"));
			return propiedadServicio;
		}
	}
	
	public List<PropiedadServicio> getPropiedadesServicios(){
		return this.jdbcTemplate.query("select id_propiedad, id_servicio from propiedad_servicio", new PropiedadServicioMapper());
	}
	
	public PropiedadServicio getPropiedadServicio(int id_propiedad, int id_servicio){
		return this.jdbcTemplate.queryForObject("select id_propiedad, id_servicio from propiedad_servicio where id_propiedad=? and id_servicio=?", new Object[] {id_propiedad, id_servicio}, new PropiedadServicioMapper());
	}
	
	public void addPropiedadServicio(PropiedadServicio propiedadServicio){
		this.jdbcTemplate.update("insert into propiedad_servicio(id_propiedad, id_servicio) values(?,?)", propiedadServicio.getId_propiedad(),propiedadServicio.getId_servicio());
	}
	
	public void updatePropiedadServicio(PropiedadServicio propiedadServicio){
		this.jdbcTemplate.update("update propiedad set id_servicio=? where id_propiedad=?", propiedadServicio.getId_servicio(),propiedadServicio.getId_propiedad());
	}
	
	public void deletePropiedadServicio(PropiedadServicio propiedad) {
		this.jdbcTemplate.update("DELETE FROM propiedad_servicio WHERE id_propiedad=? and id_servicio=?", propiedad.getId_propiedad(), propiedad.getId_servicio());
	}
	
	public void deletePropiedadServicio(int id_propiedad, int id_servicio) {
		this.jdbcTemplate.update("DELETE FROM propiedad_servicio WHERE id_propiedad=? and id_servicio=?", id_propiedad, id_servicio);
	}
}

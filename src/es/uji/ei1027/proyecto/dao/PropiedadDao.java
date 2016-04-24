package es.uji.ei1027.proyecto.dao;

import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.proyecto.domain.Propiedad;

@Repository
public class PropiedadDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private static final class PropiedadMapper implements RowMapper<Propiedad>{
		public Propiedad mapRow(ResultSet rs, int rowNum) throws SQLException{
			Propiedad propiedad = new Propiedad();
			propiedad.setId_propiedad(rs.getInt("id_propiedad"));
			propiedad.setId_usuario(rs.getInt("id_usuario"));
			propiedad.setTitulo(rs.getString("titulo"));
			propiedad.setTipo(rs.getString("tipo"));
			propiedad.setCapacidad(rs.getInt("capacidad"));
			propiedad.setNum_habitaciones(rs.getInt("num_habitaciones"));
			propiedad.setNum_camas(rs.getInt("num_camas"));
			propiedad.setArea(rs.getInt("area"));
			propiedad.setServicios(rs.getString("servicios"));
			propiedad.setId_propiedad(rs.getInt("id_propiedad"));
			propiedad.setUrl_mapa(rs.getString("url_mapa"));
			return propiedad;
		}
	}
	
	public 	List<Propiedad> getPropiedades() {
			return this.jdbcTemplate.query("select id_propiedad, id_usuario, titulo, descripcion"
					+ ", tipo, capacidad, num_habitaciones, num_camas, area, servicios"
					+ ", precio_propiedad, id_direccion, url_mapa from propiedad", new PropiedadMapper());
	}
	
	public Propiedad getPropiedad(int id_propiedad) {
		return this.jdbcTemplate.queryForObject("select id_propiedad, id_usuario, titulo, descripcion"
					+ ", tipo, capacidad, num_habitaciones, num_camas, area, servicios"
					+ ", precio_propiedad, id_direccion, url_mapa from propiedad where id_propiedad=?", new Object[] {id_propiedad}, new PropiedadMapper());
	}
	
	public void addPropiedad(Propiedad propiedad) {
		this.jdbcTemplate.update("insert into propiedad(id_propiedad, id_usuario, titulo, descripcion"
					+ ", tipo, capacidad, num_habitaciones, num_camas, area, servicios"
					+ ", precio_propiedad, id_direccion, url_mapa) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
					propiedad.getId_propiedad(),propiedad.getId_usuario(),
					propiedad.getTitulo(), propiedad.getDescripcion(),
					propiedad.getTipo(),propiedad.getCapacidad(),
					propiedad.getNum_habitaciones(),propiedad.getNum_camas(),
					propiedad.getArea(),propiedad.getServicios(),
					propiedad.getPrecio_propiedad(),propiedad.getId_direccion(),
					propiedad.getUrl_mapa());
	}
	
	public void updatePropiedad(Propiedad propiedad) {
		this.jdbcTemplate.update("update propiedad "
					+ "set id_usuario = ?, titulo = ?,"
					+ "descripcion = ?,tipo = ?,"
					+ "capacidad = ?,num_habitaciones = ?,"
					+ "num_camas = ?,area = ?,"
					+ "servicios = ?,precio_propiedad = ?,"
					+ "id_direccion = ?,url_mapa = ? "
					+ "where id_propiedad = ?",
					propiedad.getId_usuario(),propiedad.getTitulo(),
					propiedad.getDescripcion(),propiedad.getTipo(),
					propiedad.getCapacidad(),propiedad.getNum_habitaciones(),
					propiedad.getNum_camas(),propiedad.getArea(),
					propiedad.getServicios(),propiedad.getPrecio_propiedad(),
					propiedad.getId_direccion(),propiedad.getUrl_mapa(),
					propiedad.getId_propiedad());
	}
	
	public void deletePropiedad(Propiedad propiedad) {
		this.jdbcTemplate.update("DELETE FROM propiedad WHERE id_propiedad=?", propiedad.getId_propiedad());
	}
	
	

}
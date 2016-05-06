package es.uji.ei1027.proyecto.dao;

import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.proyecto.domain.Direccion;

@Repository
public class DireccionDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource( DataSource dataSource ){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private static final class DireccionMapper implements RowMapper<Direccion>{
		public Direccion mapRow(ResultSet rs, int rowNum) throws SQLException{
			Direccion direccion = new Direccion();
			direccion.setId_direccion(rs.getInt("id_direccion"));
			direccion.setCalle(rs.getString("calle"));
			direccion.setNumero(rs.getInt("numero"));
			direccion.setCodigo_postal(rs.getInt("codigo_postal"));
			direccion.setLocalidad(rs.getString("localidad"));
			direccion.setProvincia(rs.getString("provincia"));
			return direccion;
		}
	}
	
	public List<Direccion> getDirecciones(){
		return this.jdbcTemplate.query("select id_direccion, calle, numero, codigo_postal, localidad, provincia from direccion", new DireccionMapper());
	}
	
	public Direccion getDireccion(int id_direccion) {
		return this.jdbcTemplate.queryForObject("SELECT id_direccion, calle, numero, codigo_postal, localidad, provincia FROM direccion WHERE id_direccion = ?", new Object[] {id_direccion}, new DireccionMapper());
			
	}
	
	public void addDireccion(Direccion direccion) {
		this.jdbcTemplate.update("insert into direccion(id_direccion, calle, numero, codigo_postal, localidad, provincia) values(?, ?, ?, ?, ?, ?)", direccion.getId_direccion(), direccion.getCalle(), direccion.getNumero(),direccion.getCodigo_postal(), direccion.getLocalidad(), direccion.getProvincia() );
	}
	
	public void updateDireccion(Direccion direccion) {
		this.jdbcTemplate.update("update direccion set calle=?, numero=?, codigo_postal=?, localidad=?, provincia=? where id_direccion=?",direccion.getCalle(),direccion.getNumero(),direccion.getCodigo_postal(),direccion.getLocalidad(),direccion.getProvincia(),direccion.getId_direccion());	
	}

	public void deleteDireccion(Direccion direccion) {		
		this.jdbcTemplate.update("delete from direccion where id_direccion=?", direccion.getId_direccion());	
	}
	
	public void deleteDireccion(int id_direccion) {		
		this.jdbcTemplate.update("delete from direccion where id_direccion=?", id_direccion);	
	}
}

package es.uji.ei1027.proyecto.dao;

import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.proyecto.domain.Imagen;

@Repository
public class ImagenDao {

	private JdbcTemplate jdbcTemplate;

	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private static final class ImagenMapper implements RowMapper<Imagen>{
		public Imagen mapRow(ResultSet rs, int rowNum) throws SQLException{
			Imagen imagen = new Imagen();
			imagen.setId_imagen(rs.getInt("id_imagen"));
			imagen.setId_propiedad(rs.getInt("id_propiedad"));
			imagen.setPie_foto(rs.getString("pie_foto"));
			imagen.setReferencia(rs.getString("referencia"));
			return imagen;
		}
	}
	
	public List<Imagen> getImagenes(){
		return this.jdbcTemplate.query("select id_imagen, id_propiedad, pie_foto , referencia from imagen", new ImagenMapper());
	}
	
	public List<Imagen> getImagenesPropiedad(int id_propiedad){
		return this.jdbcTemplate.query("select id_imagen, id_propiedad, pie_foto , referencia from imagen where id_propiedad = ?", new ImagenMapper(), id_propiedad);
	}
	
	public Imagen getImagen(int id_imagen) {
		return this.jdbcTemplate.queryForObject("SELECT id_imagen, id_propiedad, pie_foto, referencia FROM imagen WHERE id_imagen = ?", new Object[] {id_imagen}, new ImagenMapper());
	}


	public void addImagen(Imagen imagen) {
		this.jdbcTemplate.update("insert into imagen(id_imagen, id_propiedad, pie_foto , referencia) values(?, ?, ?, ?)", imagen.getId_imagen(), imagen.getId_propiedad(),imagen.getPie_foto(),imagen.getReferencia());
	}

	public void updateImagen(Imagen imagen) {
		this.jdbcTemplate.update("update imagen set id_propiedad = ?,pie_foto = ?, referencia = ? where id_imagen = ?", imagen.getId_propiedad(),imagen.getPie_foto(),imagen.getReferencia(),imagen.getId_imagen());
	}

	public void deleteImagen(Imagen imagen) {
		this.jdbcTemplate.update("DELETE FROM imagen WHERE id_imagen = ?", imagen.getId_imagen());
	}
	
	public void deleteImagen(int imagen) {
		this.jdbcTemplate.update("DELETE FROM imagen WHERE id_imagen = ?", imagen);
	}
	
	public int nuevoIdImagen() {
		//Consulta cual es el último id_direccion y devuelve ese número +1 para una nueva direccion
		String sql = "SELECT MAX(id_imagen) from imagen";
		int max;
		try {
			max = this.jdbcTemplate.queryForObject(sql, Integer.class);
		} catch (NullPointerException ex) {
			max = -1;
		}
		return max+1;
	}
	
}

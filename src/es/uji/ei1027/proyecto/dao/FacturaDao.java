package es.uji.ei1027.proyecto.dao;

import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.proyecto.domain.Factura;

@Repository
public class FacturaDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private static final class FacturaMapper implements RowMapper<Factura>{
		public Factura mapRow(ResultSet rs, int rowNum) throws SQLException{
			Factura factura = new Factura();
			factura.setId_factura(rs.getInt("id_factura"));
			factura.setId_reserva(rs.getInt("id_reserva"));
			factura.setFecha_factura(rs.getDate("fecha_factura"));
			factura.setPrecio_factura(rs.getFloat("precio_factura"));
			factura.setIva(rs.getInt("iva"));
			return factura;
		}
	}
	
	public List<Factura> getFacturas() {
		return this.jdbcTemplate.query("select id_factura, id_reserva, fecha_factura, precio_factura, iva from factura", new FacturaMapper());
	}
	
	public Factura getFactura(int id_factura) {
		Factura factura = this.jdbcTemplate.queryForObject("select id_factura, id_reserva, fecha_factura, precio_factura, iva from factura where id_factura=?", new Object[] {id_factura}, new FacturaMapper());
		factura.rellenarDiaMesAno();
		return factura;
	}
	
	public void addFactura(Factura factura) {
		this.jdbcTemplate.update("insert into factura(id_factura, id_reserva, fecha_factura, precio_factura, iva) values(?, ?, ?, ?, ?)",factura.getId_factura(),factura.getId_reserva(),factura.getFecha_factura(),factura.getPrecio_factura(),factura.getIva());
	}
	
	public void updateFactura(Factura factura) {
		this.jdbcTemplate.update("update factura "
					+ "set id_reserva = ?,"
					+ "fecha_factura = ?,"
					+ "precio_factura = ?,"
					+ "iva = ? "
					+ "where id_factura = ?",factura.getId_reserva(),
					factura.getFecha_factura(),
					factura.getPrecio_factura(),
					factura.getIva(),
					factura.getId_factura());
	}
	
	public void deleteFactura(Factura factura) {
		this.jdbcTemplate.update("DELETE FROM factura WHERE id_factura=?",factura.getId_factura() );
	}
	
	public void deleteFactura(int id_factura) {
		this.jdbcTemplate.update("DELETE FROM factura WHERE id_factura=?",id_factura );
	}
}

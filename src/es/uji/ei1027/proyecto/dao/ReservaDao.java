package es.uji.ei1027.proyecto.dao;

import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.proyecto.domain.Reserva;

@Repository
public class ReservaDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private static final class ReservaMapper implements RowMapper<Reserva>{
		public Reserva mapRow(ResultSet rs, int rowNum) throws SQLException{
			Reserva reserva = new Reserva();
			reserva.setId_reserva(rs.getInt("id_reserva"));
			reserva.setId_usuario(rs.getInt("id_usuario"));
			reserva.setId_propiedad(rs.getInt("id_propiedad"));
			reserva.setFecha_reserva(rs.getDate("fecha_reserva"));
			reserva.setFecha_checkin(rs.getDate("fecha_checkin"));
			reserva.setFecha_checkout(rs.getDate("fecha_checkout"));
			reserva.setPrecio_reserva(rs.getFloat("precio_reserva"));
			reserva.setEstado(rs.getString("estado"));
			return reserva;
		}
	}
	
	public List<Reserva> getReservas() {
			return this.jdbcTemplate.query("select id_reserva, id_usuario, id_propiedad, fecha_reserva, fecha_checkin, fecha_checkout, precio_reserva, estado from reserva", new ReservaMapper());			
	}
	
	public Reserva getReserva(int id_reserva) {
		return this.jdbcTemplate.queryForObject("select id_reserva, id_usuario, id_propiedad ,fecha_reserva, fecha_checkin, fecha_checkout, precio_reserva, estado from reserva where id_reserva=?", new Object[] {id_reserva}, new ReservaMapper());
	}
	
	public void addReserva(Reserva reserva) {
		this.jdbcTemplate.update("insert into reserva(id_reserva, id_usuario, id_propiedad, fecha_reserva, fecha_checkin, fecha_checkout, precio_reserva, estado) values(?, ?, ?, ?, ?, ?, ?, ?)",reserva.getId_reserva(), reserva.getId_usuario(),reserva.getId_propiedad(),reserva.getFecha_reserva(),reserva.getFecha_checkin(),reserva.getFecha_checkout(),reserva.getPrecio_reserva(),reserva.getEstado());
	}
	
	public void updateReserva(Reserva reserva) {
		this.jdbcTemplate.update("update reserva set id_usuario = ?,id_propiedad = ?, fecha_reserva = ?,fecha_checkin = ?,fecha_checkout = ?,precio_reserva = ?,estado = ? where id_reserva = ?",reserva.getId_usuario(),reserva.getId_propiedad(),reserva.getFecha_reserva(),reserva.getFecha_checkin(),reserva.getFecha_checkout(),reserva.getPrecio_reserva(),reserva.getEstado(),reserva.getId_reserva());
	}
	
	public void deleteReserva(Reserva reserva) {
		this.jdbcTemplate.update("DELETE FROM reserva WHERE id_reserva=?", reserva.getId_reserva());
	}
	
	public void deleteReserva(int idReserva) {
		this.jdbcTemplate.update("DELETE FROM reserva WHERE id_reserva=?", idReserva);
	}
	
	public int nuevoIdReserva() {
		//Consulta cual es el último id_reserva y devuelve ese número +1 para una nueva reserva
		String sql = "SELECT MAX(id_reserva) from reserva";
		int max;
		try {
			max = this.jdbcTemplate.queryForObject(sql, Integer.class);
		} catch (NullPointerException ex) {
			max = -1;
		}
		return max+1;
	}
	
	public boolean existeReserva(int idReserva) {
		String sql = "SELECT id_reserva from reserva where id_reserva = ?";
		int id;
		try {
			id = this.jdbcTemplate.queryForObject(sql, Integer.class, idReserva);
		} catch (Exception ex) {
			id = -1;
		}
		if ( id == -1 ) 
			return false;
		else
			return true;
	}
	

}

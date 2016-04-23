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
			reserva.setIdReserva(rs.getInt("id_reserva"));
			reserva.setIdUsuario(rs.getInt("id_usuario"));
			reserva.setIdPropiedad(rs.getInt("id_propiedad"));
			reserva.setFechaReserva(rs.getDate("fecha_reserva"));
			reserva.setFechaCheckin(rs.getDate("fecha_checkin"));
			reserva.setFechaCheckout(rs.getDate("fecha_chechout"));
			reserva.setPrecioReserva(rs.getFloat("precio_reserva"));
			reserva.setEstado(rs.getString("estado"));
			return reserva;
		}
	}
	
	public List<Reserva> getReservas() {
			return this.jdbcTemplate.query("select id_reserva, id_usuario, id_propiedad"
					+ ", fecha_reserva, fecha_checkin, fecha_checkout, precio_reserva"
					+ ", estado from reserva", new ReservaMapper());			
	}
	
	public Reserva getReserva(int id_reserva) {
		return this.jdbcTemplate.queryForObject("select id_reserva, id_usuario, id_propiedad"
					+ ", fecha_reserva, fecha_checkin, fecha_checkout, precio_reserva"
					+ ", estado from reserva where id_reserva=?", new Object[] {id_reserva}, new ReservaMapper());
	}
	
	public void addReserva(Reserva reserva) {
		this.jdbcTemplate.update("insert into reserva(id_reserva, id_usuario, id_propiedad"
					+ ", fecha_reserva, fecha_checkin, fecha_checkout, precio_reserva"
					+ ", estado) values(?, ?, ?, ?, ?, ?, ?, ?)",
					reserva.getIdReserva(), reserva.getIdUsuario(),
					reserva.getIdPropiedad(),reserva.getFechaReserva(),
					reserva.getFechaCheckin(),reserva.getFechaCheckout(),
					reserva.getPrecioReserva(),reserva.getEstado());
	}
	
	public void updateReserva(Reserva reserva) {
		this.jdbcTemplate.update("update reserva set id_usuario = ?,"
					+ "id_propiedad = ?, fecha_reserva = ?,"
					+ "fecha_checkin = ?,fecha_checkout = ?,"
					+ "precio_reserva = ?,estado = ? "
					+ "where id_reserva = ?",reserva.getIdUsuario(),
					reserva.getIdPropiedad(),reserva.getFechaReserva(),
					reserva.getFechaCheckin(),reserva.getFechaCheckout(),
					reserva.getPrecioReserva(),reserva.getEstado(),
					reserva.getIdReserva());
	}
	
	public void deleteReserva(Reserva reserva) {
		this.jdbcTemplate.update("DELETE FROM reserva WHERE id_reserva=?", reserva.getIdReserva());
	}
	
	public void deleteReserva(int idReserva) {
		this.jdbcTemplate.update("DELETE FROM reserva WHERE id_reserva=?", idReserva);
	}

}

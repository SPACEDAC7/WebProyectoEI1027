package es.uji.ei1027.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import conection.ConnectionManager;
import es.uji.ei1027.proyecto.domain.Reserva;

public class ReservaDao {
	private final static Logger Log = Logger.getLogger(ReservaDao.class.getName());
	
	public Set<Reserva> getReservas() {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
		}
		catch (ClassNotFoundException e) {
			Log.severe("Driver JDBC no trobat");
			e.printStackTrace();
			return null;
		}
		catch (SQLException e) {
			Log.severe("Error creant connexió JDBC");
			e.printStackTrace();
			return null;
		}
		HashSet<Reserva> reservas = new HashSet<Reserva>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("select id_reserva, id_usuario, id_propiedad"
					+ ", fecha_reserva, fecha_checkin, fecha_checkout, precio_reserva"
					+ ", estado from reserva");
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				Reserva reserva = new Reserva();
				reserva.setIdReserva(rs.getInt("id_reserva"));
				reserva.setIdUsuario(rs.getInt("id_usuario"));
				reserva.setIdPropiedad(rs.getInt("id_propiedad"));
				reserva.setFechaReserva(rs.getDate("fecha_reserva"));
				reserva.setFechaCheckin(rs.getDate("fecha_checkin"));
				reserva.setFechaCheckout(rs.getDate("fecha_chechout"));
				reserva.setPrecioReserva(rs.getFloat("precio_reserva"));
				reserva.setEstado(rs.getString("estado"));
				reservas.add(reserva);
			}
		}
		catch (SQLException e) {
			Log.severe("Error executant PreparedStatement");
			e.printStackTrace();
			return null;
		}
		finally {
			if (rs != null) {
				try {
					rs.close();
				}
				catch (SQLException e) {
					Log.warning("Error tancant ResultSet");
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					Log.warning("Error tancant PreparedStatement");
					e.printStackTrace();
				}
			}
			try {
				conn.close();
			} catch (SQLException e) {
				Log.warning("Error tancant connexió JDBC");				
				e.printStackTrace();
			}
		}
		return reservas;
	}
	
	public Reserva getReserva(int idReservaABuscar) {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
		}
		catch (ClassNotFoundException e) {
			Log.severe("Driver JDBC no trobat");
			e.printStackTrace();
			return null;
		}
		catch (SQLException e) {
			Log.severe("Error creant connexió JDBC");
			e.printStackTrace();
			return null;
		}
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Reserva reserva = null;
		try {
			String sql = "select id_reserva, id_usuario, id_propiedad"
					+ ", fecha_reserva, fecha_checkin, fecha_checkout, precio_reserva"
					+ ", estado from reserva where id_reserva=?;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idReservaABuscar);
			rs = stmt.executeQuery();
			reserva = new Reserva();
			if (rs != null) {
				while (rs.next()) {
					reserva.setIdReserva(rs.getInt(1));
					reserva.setIdUsuario(rs.getInt(2));
					reserva.setIdPropiedad(rs.getInt(3));
					reserva.setFechaReserva(rs.getDate(4));
					reserva.setFechaCheckin(rs.getDate(5));
					reserva.setFechaCheckout(rs.getDate(6));
					reserva.setPrecioReserva(rs.getFloat(7));
					reserva.setEstado(rs.getString(8));
				}
			}
		} 
		catch (SQLException e) {
			Log.severe("Error executant PreparedStatement");
			e.printStackTrace();
			return null;
		}
		finally {
			if (rs != null) {
				try {
					rs.close();
				}
				catch (SQLException e) {
					Log.warning("Error tancant ResultSet");
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					Log.warning("Error tancant PreparedStatement");
					e.printStackTrace();
				}
			}
			try {
				conn.close();
			} catch (SQLException e) {
				Log.warning("Error tancant connexió JDBC");				
				e.printStackTrace();
			}
		}
		return reserva;
	}
	
	public void addReserva(Reserva reserva) {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
		}
		catch (ClassNotFoundException e) {
			Log.severe("Driver JDBC no trobat");
			e.printStackTrace();
			return;
		}
		catch (SQLException e) {
			Log.severe("Error creant connexió JDBC");
			e.printStackTrace();
			return;
		}
		PreparedStatement stmt = null;
		try {
			 stmt = conn.prepareStatement(
					"insert into reserva(id_reserva, id_usuario, id_propiedad"
					+ ", fecha_reserva, fecha_checkin, fecha_checkout, precio_reserva"
					+ ", estado) values(?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, reserva.getIdReserva());
			stmt.setInt(2, reserva.getIdUsuario());
			stmt.setInt(3, reserva.getIdPropiedad());
			stmt.setDate(4, reserva.getFechaReserva());
			stmt.setDate(5, reserva.getFechaCheckin());
			stmt.setDate(6, reserva.getFechaCheckout());
			stmt.setFloat(7, reserva.getPrecioReserva());
			stmt.setString(8, reserva.getEstado());
			stmt.execute();	
		}
		catch (SQLException e) {
			Log.severe("Error executant PreparedStatement");
			e.printStackTrace();
		}
		finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					Log.warning("Error tancant PreparedStatement");
					e.printStackTrace();
				}
			}
			try {
				conn.close();
			} catch (SQLException e) {
				Log.warning("Error tancant connexió JDBC");				
				e.printStackTrace();
			}
		}
	}
	
	public void updateReserva(Reserva reserva) {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
		}
		catch (ClassNotFoundException e) {
			Log.severe("Driver JDBC no trobat");
			e.printStackTrace();
			return;
		}
		catch (SQLException e) {
			Log.severe("Error creant connexió JDBC");
			e.printStackTrace();
			return;
		}
		PreparedStatement stmt = null;
		try {
			
			stmt = conn.prepareStatement(
					"update reserva "
					+ "set id_usuario = ?,"
					+ "id_propiedad = ?,"
					+ "fecha_reserva = ?,"
					+ "fecha_checkin = ?,"
					+ "fecha_checkout = ?,"
					+ "precio_reserva = ?,"
					+ "estado = ? "
					+ "where id_reserva = ?");
			
			stmt.setInt(1, reserva.getIdUsuario());
			stmt.setInt(2, reserva.getIdPropiedad());
			stmt.setDate(3, reserva.getFechaReserva());
			stmt.setDate(4, reserva.getFechaCheckin());
			stmt.setDate(5, reserva.getFechaCheckout());
			stmt.setFloat(6, reserva.getPrecioReserva());
			stmt.setString(7, reserva.getEstado());
			stmt.setInt(8, reserva.getIdReserva());
			stmt.execute();	
		}
		catch (SQLException e) {
			Log.severe("Error executant PreparedStatement");
			e.printStackTrace();
		}
		finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					Log.warning("Error tancant PreparedStatement");
					e.printStackTrace();
				}
			}
			try {
				conn.close();
			} catch (SQLException e) {
				Log.warning("Error tancant connexió JDBC");				
				e.printStackTrace();
			}
		}
	}
	
	public void deleteReserva(Reserva reserva) {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
		}
		catch (ClassNotFoundException e) {
			Log.severe("Driver JDBC no trobat");
			e.printStackTrace();
			return;
		}
		catch (SQLException e) {
			Log.severe("Error creant connexió JDBC");
			e.printStackTrace();
			return;
		}
		PreparedStatement stmt = null;
		try {
			String sql = "DELETE FROM reserva WHERE id_reserva=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, reserva.getIdReserva());
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			Log.severe("Error executant PreparedStatement");
			e.printStackTrace();
		}
		finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					Log.warning("Error tancant PreparedStatement");
					e.printStackTrace();
				}
			}
			try {
				conn.close();
			} catch (SQLException e) {
				Log.warning("Error tancant connexió JDBC");				
				e.printStackTrace();
			}
		}
	}
	
	public void deleteReserva(int idReserva) {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
		}
		catch (ClassNotFoundException e) {
			Log.severe("Driver JDBC no trobat");
			e.printStackTrace();
			return;
		}
		catch (SQLException e) {
			Log.severe("Error creant connexió JDBC");
			e.printStackTrace();
			return;
		}
		PreparedStatement stmt = null;
		try {
			String sql = "DELETE FROM reserva WHERE id_reserva=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idReserva);
			stmt.executeUpdate();
		}
		catch (SQLException e) {
			Log.severe("Error executant PreparedStatement");
			e.printStackTrace();
		}
		finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					Log.warning("Error tancant PreparedStatement");
					e.printStackTrace();
				}
			}
			try {
				conn.close();
			} catch (SQLException e) {
				Log.warning("Error tancant connexió JDBC");				
				e.printStackTrace();
			}
		}
	}

}

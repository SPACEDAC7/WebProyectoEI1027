package es.uji.ei1027.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import conection.ConnectionManager;
import es.uji.ei1027.proyecto.domain.Factura;

public class FacturaDao {
	private final static Logger Log = Logger.getLogger(FacturaDao.class.getName());
	
	public Set<Factura> getFacturas() {
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
		HashSet<Factura> facturas = new HashSet<Factura>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("select id_factura, id_reserva, fecha_factura"
					+ ", precio_factura, iva from factura");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Factura factura = new Factura();
				factura.setIdFactura(rs.getInt("id_factura"));
				factura.setIdReserva(rs.getInt("id_reserva"));
				factura.setFechaFactura(rs.getDate("fecha_factura"));
				factura.setPrecioFactura(rs.getFloat("precio_factura"));
				factura.setIva(rs.getInt("iva"));
				facturas.add(factura);
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
		return facturas;
	}
	
	public Factura getFactura(int idFacturaABuscar) {
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
		Factura factura = null;
		try {
			String sql = "select id_factura, id_reserva, fecha_factura"
					+ ", precio_factura, iva from factura where id_factura=?;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idFacturaABuscar);
			rs = stmt.executeQuery();
			factura = new Factura();
			if (rs != null) {
				while (rs.next()) {
					factura.setIdFactura(rs.getInt(1));
					factura.setIdReserva(rs.getInt(2));
					factura.setFechaFactura(rs.getDate(3));
					factura.setPrecioFactura(rs.getFloat(4));
					factura.setIva(rs.getInt(5));
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
		return factura;
	}
	
	public void addFactura(Factura factura) {
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
					"insert into factura(id_factura, id_reserva, fecha_factura"
					+ ", precio_factura, iva) values(?, ?, ?, ?, ?)");
			stmt.setInt(1, factura.getIdFactura());
			stmt.setInt(2, factura.getIdReserva());
			stmt.setDate(3, factura.getFechaFactura());
			stmt.setFloat(4, factura.getPrecioFactura());
			stmt.setInt(5, factura.getIva());
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
	
	public void updateFactura(Factura factura) {
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
					"update factura "
					+ "set id_reserva = ?,"
					+ "fecha_factura = ?,"
					+ "precio_factura = ?,"
					+ "iva = ? "
					+ "where id_factura = ?");
			
			stmt.setInt(1, factura.getIdReserva());
			stmt.setDate(2, factura.getFechaFactura());
			stmt.setFloat(3, factura.getPrecioFactura());
			stmt.setInt(4, factura.getIva());
			stmt.setInt(5, factura.getIdFactura());
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
	
	public void deleteFactura(Factura factura) {
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
			String sql = "DELETE FROM factura WHERE id_factura=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, factura.getIdFactura());
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
	
	public void deleteFactura(int idFactura) {
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
			String sql = "DELETE FROM factura WHERE id_factura=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idFactura);
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

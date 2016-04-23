package es.uji.ei1027.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import conection.ConnectionManager;
import es.uji.ei1027.proyecto.domain.Periodo;

public class PeriodoDao {
	private final static Logger Log = Logger.getLogger(PeriodoDao.class.getName());
	
	public Set<Periodo> getPeriodos() {
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
		HashSet<Periodo> periodos = new HashSet<Periodo>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("select id_periodo, id_propiedad"
					+ ", inicio, fin from periodo");
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				Periodo periodo = new Periodo();
				periodo.setIdPeriodo(rs.getInt("id_periodo"));
				periodo.setIdPropiedad(rs.getInt("id_propiedad"));
				periodo.setInicio(rs.getDate("inicio"));
				periodo.setFin(rs.getDate("fin"));
				periodos.add(periodo);
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
		return periodos;
	}
	
	public Periodo getPeriodo(int idPeriodoABuscar) {
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
		Periodo periodo = null;
		try {
			String sql = "select id_periodo, id_propiedad"
					+ ", inicio, fin from periodo where id_periodo=?;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idPeriodoABuscar);
			rs = stmt.executeQuery();
			periodo = new Periodo();
			if (rs != null) {
				while (rs.next()) {
					periodo.setIdPeriodo(rs.getInt(1));
					periodo.setIdPropiedad(rs.getInt(2));
					periodo.setInicio(rs.getDate(3));
					periodo.setFin(rs.getDate(4));
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
		return periodo;
	}
	
	public void addPeriodo(Periodo periodo) {
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
					"insert into periodo(id_periodo, id_propiedad"
					+ ", inicio, fin) values(?, ?, ?, ?)");
			stmt.setInt(1, periodo.getIdPeriodo());
			stmt.setInt(2, periodo.getIdPropiedad());
			stmt.setDate(3, periodo.getInicio());
			stmt.setDate(4, periodo.getFin());
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
	
	public void updatePeriodo(Periodo periodo) {
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
					"update periodo "
					+ "set id_propiedad = ?,"
					+ "inicio = ?,"
					+ "fin = ? "
					+ "where id_periodo = ?");
			
			stmt.setInt(1, periodo.getIdPropiedad());
			stmt.setDate(2, periodo.getInicio());
			stmt.setDate(3, periodo.getFin());
			stmt.setInt(4, periodo.getIdPeriodo());
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
	
	public void deletePeriodo(Periodo periodo) {
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
			String sql = "DELETE FROM periodo WHERE id_periodo=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, periodo.getIdPeriodo());
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
	
	public void deletePeriodo(int idPeriodo) {
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
			String sql = "DELETE FROM periodo WHERE id_periodo=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idPeriodo);
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

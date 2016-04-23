package es.uji.ei1027.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import conection.ConnectionManager;
import es.uji.ei1027.proyecto.domain.Credencial;

public class CredencialDao {
	private final static Logger Log = Logger.getLogger(DireccionDao.class.getName()); 
	private Connection conn = null;
	
	public Credencial getCredencial(int id_credencial) {
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
			Log.severe("Error creant connexi� JDBC");
			e.printStackTrace();
			return null;
		}
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Credencial credencial = null;
		try {
			String sql = "SELECT id_credencial, nick_usuario, password, rol " + 
						"FROM credencial WHERE id_credencial = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id_credencial);
			rs = stmt.executeQuery();
			if ( rs != null){
				while(rs.next()){
					credencial.setId_credencial(rs.getInt(1));
					credencial.setNick_usuario(rs.getString(2));
					credencial.setPassword(rs.getString(3));
					credencial.setRol(rs.getString(4));
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
				Log.warning("Error tancant connexi� JDBC");				
				e.printStackTrace();
			}
		}
		return credencial;
	}
	
	
	public void addCredencial(Credencial credencial) {
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
			Log.severe("Error creant connexi� JDBC");
			e.printStackTrace();
			return;
		}
		PreparedStatement stmt = null;
		try {
			 stmt = conn.prepareStatement(
					"insert into credencial(id_credencial, nick_usuario, password , rol) "
					+ "values(?, ?, ?, ?)");
			stmt.setInt(1, credencial.getId_credencial());
			stmt.setString(2, credencial.getNick_usuario());
			stmt.setString(3, credencial.getPassword());
			stmt.setString(4, credencial.getRol());
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
				Log.warning("Error tancant connexi� JDBC");				
				e.printStackTrace();
			}
		}
	}
	
	public void updateCredencial(Credencial credencial) {
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
			Log.severe("Error creant connexi� JDBC");
			e.printStackTrace();
			return;
		}
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(
					"update credencial "
					+ "set nick_usuario = ?, "
					+ "password = ?, "
					+ "rol = ? "
					+ "where id_credencial = ?");
			stmt.setString(1, credencial.getNick_usuario());
			stmt.setString(2, credencial.getPassword());
			stmt.setString(3, credencial.getRol());
			stmt.setInt(4, credencial.getId_credencial());
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
				Log.warning("Error tancant connexi� JDBC");				
				e.printStackTrace();
			}
		}
	}

	public void deleteCredencial(Credencial credencial) {
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
			Log.severe("Error creant connexi� JDBC");
			e.printStackTrace();
			return;
		}
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(
					"DELETE FROM credencial WHERE id_credencial = ?");
			stmt.setInt(1, credencial.getId_credencial());
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
				Log.warning("Error tancant connexi� JDBC");				
				e.printStackTrace();
			}
		}
	}
	
}

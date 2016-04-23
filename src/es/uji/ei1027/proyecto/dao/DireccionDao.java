package es.uji.ei1027.proyecto.dao;

import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import conection.ConnectionManager;
import es.uji.ei1027.proyecto.domain.Direccion;

public class DireccionDao {
	private final static Logger Log = Logger.getLogger(DireccionDao.class.getName()); 
	private Connection conn = null;
	
	public Direccion getNadador(int id_direccion) {
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
		Direccion direccion = null;
		try {
			String sql = "SELECT id_direccion, calle, numero, codigo_postal, localidad, provincia " + 
						"FROM direccion WHERE id_direccion = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id_direccion);
			rs = stmt.executeQuery();
			if ( rs != null){
				while(rs.next()){
					direccion.setId_direccion(rs.getInt(1));
					direccion.setCalle(rs.getString(2));
					direccion.setNumero(rs.getInt(3));
					direccion.setCodigo_postal(rs.getInt(4));
					direccion.setLocalidad(rs.getString(5));
					direccion.setProvincia(rs.getString(6));
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
		return direccion;
	}
	
	
	public void addDireccion(Direccion direccion) {
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
					"insert into direccion(id_direccion, calle, numero, codigo_postal, localidad, provincia) "
					+ "values(?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, direccion.getId_direccion());
			stmt.setString(2, direccion.getCalle());
			stmt.setInt(3, direccion.getNumero());
			stmt.setInt(4, direccion.getCodigo_postal());
			stmt.setString(5, direccion.getLocalidad());
			stmt.setString(6, direccion.getProvincia());
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
	
	public void updateDireccion(Direccion direccion) {
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
					"update direccion "
					+ "set calle = ?, "
					+ "numero = ?, "
					+ "codigo_postal = ?, "
					+ "localidad = ?, "
					+ "provincia = ? "
					+ "where id_direccion = ?");
			stmt.setString(1, direccion.getCalle());
			stmt.setInt(2, direccion.getNumero());
			stmt.setInt(3, direccion.getCodigo_postal());
			stmt.setString(4, direccion.getLocalidad());
			stmt.setString(5, direccion.getProvincia());
			stmt.setInt(6, direccion.getId_direccion());
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

	public void deleteDireccion(Direccion direccion) {
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
					"DELETE FROM direccion WHERE id_direccion = ?");
			stmt.setInt(1, direccion.getId_direccion());
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
				Log.warning("Error tancant connexio JDBC");				
				e.printStackTrace();
			}
		}
	}
	
}

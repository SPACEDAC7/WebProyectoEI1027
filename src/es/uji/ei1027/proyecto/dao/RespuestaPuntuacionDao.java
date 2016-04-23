package es.uji.ei1027.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import conection.ConnectionManager;
import es.uji.ei1027.proyecto.domain.RespuestaPuntuacion;

public class RespuestaPuntuacionDao {
private final static Logger Log = Logger.getLogger(RespuestaPuntuacionDao.class.getName());
	
	Set<RespuestaPuntuacion> getRespuestaPuntuacion() {
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
			Log.severe("Error creant connexiÃ³ JDBC");
			e.printStackTrace();
			return null;
		}
		HashSet<RespuestaPuntuacion> respuestasPuntuacion = new HashSet<RespuestaPuntuacion>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement("select id_respuesta, id_puntuacion, respuesta from RespuestaPuntuacion");
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				RespuestaPuntuacion respuestaPuntuacion = new RespuestaPuntuacion();
				respuestaPuntuacion.setId_respuesta(rs.getInt("id_respuesta"));
				respuestaPuntuacion.setId_puntuacion(rs.getInt("id_puntuacion"));
				respuestaPuntuacion.setRespuesta(rs.getString("respuesta"));
				respuestasPuntuacion.add(respuestaPuntuacion);
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
				Log.warning("Error tancant connexiÃ³ JDBC");				
				e.printStackTrace();
			}
		}
		return respuestasPuntuacion;
	}
	
	RespuestaPuntuacion getIdRespuesta(int idRespuesta) {
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
			Log.severe("Error creant connexiÃ³ JDBC");
			e.printStackTrace();
			return null;
		}
		PreparedStatement stmt = null;
		ResultSet rs = null;
		RespuestaPuntuacion respuestaPuntuacion = null;
		try {
			String sql = "select id_respuesta, id_puntuacion, respuesta from RespuestaPuntuacion where id_respuesta=?;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idRespuesta);
			rs = stmt.executeQuery();
			respuestaPuntuacion = new RespuestaPuntuacion();
			if (rs != null) {
				while (rs.next()) {
					respuestaPuntuacion.setId_respuesta(rs.getInt(1));
					respuestaPuntuacion.setId_puntuacion(rs.getInt(2));
					respuestaPuntuacion.setRespuesta(rs.getString(3));
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
				Log.warning("Error tancant connexiÃ³ JDBC");				
				e.printStackTrace();
			}
		}
		return respuestaPuntuacion;
	}
	
	void addIdRespuesta(RespuestaPuntuacion respuestaPuntuacion) {
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
			Log.severe("Error creant connexiÃ³ JDBC");
			e.printStackTrace();
			return;
		}
		PreparedStatement stmt = null;
		try {
			 stmt = conn.prepareStatement("insert into RespuestaPuntuacion(id_respuesta, id_puntuacion, respuesta) values(?, ?, ?)");
			stmt.setInt(1, respuestaPuntuacion.getId_respuesta());
			stmt.setInt(2, respuestaPuntuacion.getId_puntuacion());
			stmt.setString(3, respuestaPuntuacion.getRespuesta());
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
				Log.warning("Error tancant connexiÃ³ JDBC");				
				e.printStackTrace();
			}
		}
	}
	
	void updateRespuesta(RespuestaPuntuacion respuestaPuntuacion) {
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
			Log.severe("Error creant connexiÃ³ JDBC");
			e.printStackTrace();
			return;
		}
		PreparedStatement stmt = null;
		try {
			
			stmt = conn.prepareStatement(
					"update RespuestaPuntuacion "
					+ "set id_respuesta = ?,"
					+ "id_puntuacion = ?,"
					+ "respuesta = ?,"
					+ "where id_respuesta = ?");
			
			stmt.setInt(1, respuestaPuntuacion.getId_respuesta());
			stmt.setInt(2, respuestaPuntuacion.getId_puntuacion());
			stmt.setString(3, respuestaPuntuacion.getRespuesta());
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
				Log.warning("Error tancant connexiÃ³ JDBC");				
				e.printStackTrace();
			}
		}
	}
	
	void deleteRespuesta(RespuestaPuntuacion respuestaPuntuacion) {
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
			Log.severe("Error creant connexiÃ³ JDBC");
			e.printStackTrace();
			return;
		}
		PreparedStatement stmt = null;
		try {
			String sql = "DELETE FROM RespuestaPuntuacion WHERE id_respuesta=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, respuestaPuntuacion.getId_respuesta());
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
				Log.warning("Error tancant connexiÃ³ JDBC");				
				e.printStackTrace();
			}
		}
	}
	
	void deleteRespuesta(int idRespuesta) {
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
			Log.severe("Error creant connexiÃ³ JDBC");
			e.printStackTrace();
			return;
		}
		PreparedStatement stmt = null;
		try {
			String sql = "DELETE FROM RespuestaPuntuacion WHERE id_respuesta=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idRespuesta);
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
				Log.warning("Error tancant connexiÃ³ JDBC");				
				e.printStackTrace();
			}
		}
	}
}
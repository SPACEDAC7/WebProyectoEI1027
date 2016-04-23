package es.uji.ei1027.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import conection.ConnectionManager;
import es.uji.ei1027.proyecto.domain.Puntuacion;

public class PuntuacionDao {
	
	private final static Logger Log = Logger.getLogger(PuntuacionDao.class.getName());
	
	public Set<Puntuacion> getPuntuaciones() {
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
		HashSet<Puntuacion> puntuaciones = new HashSet<Puntuacion>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("select id_puntuacion, id_propiedad"
					+ ", id_usuario, valor_puntuacion, comentario from puntuacion");
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				Puntuacion puntuacion = new Puntuacion();
				puntuacion.setIdPuntuacion(rs.getInt("id_puntuacion"));
				puntuacion.setIdPropiedad(rs.getInt("id_propiedad"));
				puntuacion.setIdUsuario(rs.getInt("id_usuario"));
				puntuacion.setValorPuntuacion(rs.getInt("valor_puntuacion"));
				puntuacion.setComentario(rs.getString("comentario"));
				puntuaciones.add(puntuacion);
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
		return puntuaciones;
	}
	
	public Set<Puntuacion> getPuntuacionesDePropiedad(int idPropiedad) {
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
		HashSet<Puntuacion> puntuaciones = new HashSet<Puntuacion>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("select id_puntuacion, id_propiedad"
					+ ", id_usuario, valor_puntuacion, comentario from puntuacion where id_propiedad=?");
			stmt.setInt(1, idPropiedad);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Puntuacion puntuacion = new Puntuacion();
				puntuacion.setIdPuntuacion(rs.getInt("id_puntuacion"));
				puntuacion.setIdPropiedad(rs.getInt("id_propiedad"));
				puntuacion.setIdUsuario(rs.getInt("id_usuario"));
				puntuacion.setValorPuntuacion(rs.getInt("valor_puntuacion"));
				puntuacion.setComentario(rs.getString("comentario"));
				puntuaciones.add(puntuacion);
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
		return puntuaciones;
	}
	
	public Puntuacion getPuntuacion(int idPuntuacionABuscar) {
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
		Puntuacion puntuacion = null;
		try {
			String sql = "select id_puntuacion, id_propiedad, id_usuario"
					+ ", valor_puntuacion, comentario from puntuacion where id_puntuacion=?;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idPuntuacionABuscar);
			rs = stmt.executeQuery();
			puntuacion = new Puntuacion();
			if (rs != null) {
				while (rs.next()) {
					puntuacion.setIdPuntuacion(rs.getInt(1));
					puntuacion.setIdPropiedad(rs.getInt(2));
					puntuacion.setIdUsuario(rs.getInt(3));
					puntuacion.setValorPuntuacion(rs.getInt(4));
					puntuacion.setComentario(rs.getString(5));
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
		return puntuacion;
	}
	
	public void addPuntuacion(Puntuacion puntuacion) {
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
					"insert into puntuacion(id_puntuacion, id_propiedad, id_usuario"
					+ ", valor_puntuacion, comentario) values(?, ?, ?, ?, ?)");
			 stmt.setInt(1, puntuacion.getIdPuntuacion());
			 stmt.setInt(2, puntuacion.getIdPropiedad());
			 stmt.setInt(3, puntuacion.getIdUsuario());
			 stmt.setInt(4, puntuacion.getValorPuntuacion());
			 stmt.setString(5, puntuacion.getComentario());
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
	
	public void updatePuntuacion(Puntuacion puntuacion) {
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
					"update puntuacion "
					+ "set id_propiedad = ?,"
					+ "id_usuario = ?,"
					+ "valor_puntuacion = ?,"
					+ "comentario = ? "
					+ "where id_puntuacion = ?");
			
			stmt.setInt(1, puntuacion.getIdPropiedad());
			stmt.setInt(2, puntuacion.getIdUsuario());
			stmt.setInt(3, puntuacion.getValorPuntuacion());
			stmt.setString(4, puntuacion.getComentario());
			stmt.setInt(5, puntuacion.getIdPuntuacion());
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
	
	public void deletePuntuacion(Puntuacion puntuacion) {
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
			String sql = "DELETE FROM puntuacion WHERE id_puntuacion=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, puntuacion.getIdPuntuacion());
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
	
	public void deletePuntuacion(int idPuntuacion) {
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
			String sql = "DELETE FROM puntuacion WHERE id_puntuacion=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idPuntuacion);
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

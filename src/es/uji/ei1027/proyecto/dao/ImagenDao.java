package es.uji.ei1027.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import conection.ConnectionManager;
import es.uji.ei1027.proyecto.domain.Imagen;

public class ImagenDao {


	private final static Logger Log = Logger.getLogger(DireccionDao.class.getName()); 
	private Connection conn = null;

	public Set<Imagen> getImagenes() {
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
		HashSet<Imagen> imagenes = new HashSet<Imagen>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("select id_imagen, id_propiedad, pie_foto , referencia"
					+ " from imagen");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Imagen imagen = new Imagen();
				imagen.setId_imagen(rs.getInt("id_imagen"));
				imagen.setId_propiedad(rs.getInt("id_propiedad"));
				imagen.setPie_foto(rs.getString("pie_foto"));
				imagen.setReferencia(rs.getString("referencia"));
				imagenes.add(imagen);
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
		return imagenes;
	}
	
	public Set<Imagen> getImagenesPropiedad(int id_propiedad) {
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
		HashSet<Imagen> imagenes = new HashSet<Imagen>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("select id_imagen, id_propiedad, pie_foto, referencia"
					+ " from imagen where id_propiedad = ?");
			stmt.setInt(1, id_propiedad);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Imagen imagen = new Imagen();
				imagen.setId_imagen(rs.getInt("id_imagen"));
				imagen.setId_propiedad(rs.getInt("id_propiedad"));
				imagen.setPie_foto(rs.getString("pie_foto"));
				imagen.setReferencia(rs.getString("referencia"));
				imagenes.add(imagen);
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
		return imagenes;
	}
	
	public Imagen getImagen(int id_imagen) {
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
		Imagen imagen = null;
		try {
			String sql = "SELECT id_imagen, id_propiedad, pie_foto, referencia " + 
					"FROM imagen WHERE id_imagen = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id_imagen);
			rs = stmt.executeQuery();
			if ( rs != null){
				while(rs.next()){
					imagen.setId_imagen(rs.getInt(1));
					imagen.setId_propiedad(rs.getInt(2));
					imagen.setPie_foto(rs.getString(3));
					imagen.setReferencia(rs.getString(4));
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
		return imagen;
	}


	public void addImagen(Imagen imagen) {
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
					"insert into direccion(id_imagen, id_propiedad, pie_foto , referencia) "
							+ "values(?, ?, ?, ?)");
			stmt.setInt(1, imagen.getId_imagen());
			stmt.setInt(2, imagen.getId_propiedad());
			stmt.setString(3, imagen.getPie_foto());
			stmt.setString(4, imagen.getReferencia());
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

	public void updateImagen(Imagen imagen) {
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
							+ "set id_propiedad = ?,"
							+ "pie_foto = ?"
							+ "referencia = ?"
							+ "where id_imagen = ?");
			stmt.setInt(1, imagen.getId_propiedad());
			stmt.setString(2, imagen.getPie_foto());
			stmt.setString(3, imagen.getReferencia());
			stmt.setInt(4, imagen.getId_imagen());
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

	public void deleteImagen(Imagen imagen) {
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
					"DELETE FROM imagen WHERE id_imagen = ?");
			stmt.setInt(1, imagen.getId_imagen());
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

package es.uji.ei1027.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import conection.ConnectionManager;
import es.uji.ei1027.proyecto.domain.Propiedad;


public class PropiedadDao {
	private final static Logger Log = Logger.getLogger(PropiedadDao.class.getName());
	
	public 	Set<Propiedad> getPropiedades() {
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
		HashSet<Propiedad> propiedades = new HashSet<Propiedad>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("select id_propiedad, id_usuario, titulo, descripcion"
					+ ", tipo, capacidad, num_habitaciones, num_camas, area, servicios"
					+ ", precio_propiedad, id_direccion, url_mapa from propiedad");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Propiedad propiedad = new Propiedad();
				propiedad.setId_propiedad(rs.getInt("id_propiedad"));
				propiedad.setId_usuario(rs.getInt("id_usuario"));
				propiedad.setTitulo(rs.getString("titulo"));
				propiedad.setDescripcion(rs.getString("descripcion"));
				propiedad.setTipo(rs.getString("tipo"));
				propiedad.setCapacidad(rs.getInt("capacidad"));
				propiedad.setNum_habitaciones(rs.getInt("num_habitaciones"));
				propiedad.setNum_camas(rs.getInt("num_camas"));
				propiedad.setArea(rs.getInt("area"));
				propiedad.setServicios(rs.getString("servicios"));
				propiedad.setPrecio_propiedad(rs.getFloat("precio_propiedad"));
				propiedad.setId_direccion(rs.getInt("id_direccion"));
				propiedad.setUrl_mapa(rs.getString("url_mapa"));
				propiedades.add(propiedad);
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
		return propiedades;
	}
	
	public Propiedad getPropiedad(int idPropiedadABuscar) {
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
		Propiedad propiedad = null;
		try {
			String sql = "select id_propiedad, id_usuario, titulo, descripcion"
					+ ", tipo, capacidad, num_habitaciones, num_camas, area, servicios"
					+ ", precio_propiedad, id_direccion, url_mapa from propiedad where id_propiedad=?;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idPropiedadABuscar);
			rs = stmt.executeQuery();
			propiedad = new Propiedad();
			if (rs != null) {
				while (rs.next()) {
					propiedad.setId_propiedad(rs.getInt(1));
					propiedad.setId_usuario(rs.getInt(2));
					propiedad.setTitulo(rs.getString(3));
					propiedad.setDescripcion(rs.getString(4));
					propiedad.setTipo(rs.getString(5));
					propiedad.setCapacidad(rs.getInt(6));
					propiedad.setNum_habitaciones(rs.getInt(7));
					propiedad.setNum_camas(rs.getInt(8));
					propiedad.setArea(rs.getInt(9));
					propiedad.setServicios(rs.getString(10));
					propiedad.setPrecio_propiedad(rs.getFloat(11));
					propiedad.setId_direccion(rs.getInt(12));
					propiedad.setUrl_mapa(rs.getString(13));
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
		return propiedad;
	}
	
	public void addPropiedad(Propiedad propiedad) {
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
					"insert into propiedad(id_propiedad, id_usuario, titulo, descripcion"
					+ ", tipo, capacidad, num_habitaciones, num_camas, area, servicios"
					+ ", precio_propiedad, id_direccion, url_mapa) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, propiedad.getId_propiedad());
			stmt.setInt(2, propiedad.getId_usuario());
			stmt.setString(3, propiedad.getTitulo());
			stmt.setString(4, propiedad.getDescripcion());
			stmt.setString(5, propiedad.getTipo());
			stmt.setInt(6, propiedad.getCapacidad());
			stmt.setInt(7, propiedad.getNum_habitaciones());
			stmt.setInt(8, propiedad.getNum_camas());
			stmt.setInt(9, propiedad.getArea());
			stmt.setString(10, propiedad.getServicios());
			stmt.setFloat(11, propiedad.getPrecio_propiedad());
			stmt.setInt(12, propiedad.getId_direccion());
			stmt.setString(13, propiedad.getUrl_mapa());
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
	
	public void updatePropiedad(Propiedad propiedad) {
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
					"update propiedad "
					+ "set id_usuario = ?,"
					+ "titulo = ?,"
					+ "descripcion = ?,"
					+ "tipo = ?,"
					+ "capacidad = ?,"
					+ "num_habitaciones = ?,"
					+ "num_camas = ?,"
					+ "area = ?,"
					+ "servicios = ?,"
					+ "precio_propiedad = ?,"
					+ "id_direccion = ?,"
					+ "url_mapa = ? "
					+ "where id_propiedad = ?");
			
			stmt.setInt(1, propiedad.getId_usuario());
			stmt.setString(2, propiedad.getTitulo());
			stmt.setString(3, propiedad.getDescripcion());
			stmt.setString(4, propiedad.getTipo());
			stmt.setInt(5, propiedad.getCapacidad());
			stmt.setInt(6, propiedad.getNum_habitaciones());
			stmt.setInt(7, propiedad.getNum_camas());
			stmt.setInt(8, propiedad.getArea());
			stmt.setString(9, propiedad.getServicios());
			stmt.setFloat(10, propiedad.getPrecio_propiedad());
			stmt.setInt(11, propiedad.getId_direccion());
			stmt.setString(12, propiedad.getUrl_mapa());
			stmt.setInt(13, propiedad.getId_propiedad());
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
	
	public void deletePropiedad(Propiedad propiedad) {
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
			String sql = "DELETE FROM propiedad WHERE id_propiedad=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, propiedad.getId_propiedad());
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
	
	public void deletePropiedad(int id_propiedad) {
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
			String sql = "DELETE FROM propiedad WHERE id_propiedad=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id_propiedad);
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

package es.uji.ei1027.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import conection.ConnectionManager;
import es.uji.ei1027.proyecto.domain.Usuario;

public class UsuarioDao {
	private final static Logger Log = Logger.getLogger(UsuarioDao.class.getName());
	
	public Set<Usuario> getUsuarios() {
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
		HashSet<Usuario> usuarios = new HashSet<Usuario>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("select id_usuario, id_credencial, nombre"
					+ ", apellido, nif, email, id_direccion, fecha_registro, telefono"
					+ ", estado_usuario from usuario");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("id_usuario"));
				usuario.setIdCredencial(rs.getInt("id_credencial"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setNif(rs.getString("nif"));
				usuario.setEmail(rs.getString("email"));
				usuario.setIdDireccion(rs.getInt("id_direccion"));
				usuario.setFechaRegistro(rs.getDate("fecha_registro"));
				usuario.setTelefono(rs.getInt("telefono"));
				usuario.setEstadoUsuario(rs.getBoolean("estado_usuario"));
				usuarios.add(usuario);
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
		return usuarios;
	}
	
	public Usuario getUsuario(int idUsuarioABuscar) {
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
		Usuario usuario = null;
		try {
			String sql = "select id_usuario, id_credencial, nombre"
					+ ", apellido, nif, email, id_direccion, fecha_registro, telefono"
					+ ", estado_usuario from usuario where id_usuario=?;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idUsuarioABuscar);
			rs = stmt.executeQuery();
			usuario = new Usuario();
			if (rs != null) {
				while (rs.next()) {
					usuario.setIdUsuario(rs.getInt(1));
					usuario.setIdCredencial(rs.getInt(2));
					usuario.setNombre(rs.getString(3));
					usuario.setApellido(rs.getString(4));
					usuario.setNif(rs.getString(5));
					usuario.setEmail(rs.getString(6));
					usuario.setIdDireccion(rs.getInt(7));
					usuario.setFechaRegistro(rs.getDate(8));
					usuario.setTelefono(rs.getInt(9));
					usuario.setEstadoUsuario(rs.getBoolean(10));
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
		return usuario;
	}
	
	
	public void addUsuario(Usuario usuario) {
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
					"insert into usuario(id_usuario, id_credencial, nombre"
					+ ", apellido, nif, email, id_direccion, fecha_registro, telefono"
					+ ", estado_usuario) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, usuario.getIdUsuario());
			stmt.setInt(2, usuario.getIdCredencial());
			stmt.setString(3, usuario.getNombre());
			stmt.setString(4, usuario.getApellido());
			stmt.setString(5, usuario.getNif());
			stmt.setString(6, usuario.getEmail());
			stmt.setInt(7, usuario.getIdDireccion());
			stmt.setDate(8, usuario.getFechaRegistro());
			stmt.setInt(9, usuario.getTelefono());
			stmt.setBoolean(10, usuario.getEstadoUsuario());
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
	
	
	public void updateUsuario(Usuario usuario) {
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
					"update usuario "
					+ "set id_credencial = ?,"
					+ "nombre = ?,"
					+ "apellido = ?,"
					+ "nif = ?,"
					+ "email = ?,"
					+ "id_direccion = ?,"
					+ "fecha_registro = ?,"
					+ "telefono = ?,"
					+ "estado_usuario = ? "
					+ "where id_usuario = ?");
			
			stmt.setInt(1, usuario.getIdCredencial());
			stmt.setString(2, usuario.getNombre());
			stmt.setString(3, usuario.getApellido());
			stmt.setString(4, usuario.getNif());
			stmt.setString(5, usuario.getEmail());
			stmt.setInt(6, usuario.getIdDireccion());
			stmt.setDate(7, usuario.getFechaRegistro());
			stmt.setInt(8, usuario.getTelefono());
			stmt.setBoolean(9, usuario.getEstadoUsuario());
			stmt.setInt(10, usuario.getIdUsuario());
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
	
	public void deleteUsuario(Usuario usuario) {
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
			String sql = "DELETE FROM usuario WHERE id_usuario=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, usuario.getIdUsuario());
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
	
	public void deleteUsuario(int idUsuario) {
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
			String sql = "DELETE FROM usuario WHERE id_usuario=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idUsuario);
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

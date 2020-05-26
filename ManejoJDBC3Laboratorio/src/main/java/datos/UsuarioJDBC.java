package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.Usuario;

public class UsuarioJDBC {
	
	private static final String SQL_INSERT = "INSERT INTO usuario(usuario, password) VALUES(?,?) ";
	private static final String SQL_SELECT = "SELECT * FROM usuario";
	private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario=?";
	private static final String SQL_UPDATE = "UPDATE usuario SET usuario=?, password=? WHERE id_usuario= ?";
	
	
	public int insert(Usuario usuario) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getPassword());
			rows = stmt.executeUpdate();
			System.out.println("Se ha agregado: "+ rows+ " Usuario");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Conexion.close(conn);
			Conexion.close(stmt);
		}
		
		return rows;
	}
	
	public int delete(Usuario usuario) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, usuario.getId_usuario());
			rows = stmt.executeUpdate();
			System.out.println("Se ha eliminado "+ rows+ " registro");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Conexion.close(conn);
			Conexion.close(stmt);
		}
		
		
		return rows;
	}
	
	public boolean update(Usuario usuario) {
		
		Connection conn = null; 
		PreparedStatement stmt = null;
		int rows = 0;
		boolean up = false;
		
		try {
			conn = Conexion.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getPassword());
			stmt.setInt(3, usuario.getId_usuario());
			rows = stmt.executeUpdate();
			if(rows == 1) {
				up = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Conexion.close(conn);
			Conexion.close(stmt);
		}
		
		
		return up;
	}
	
	public List<Usuario> select(){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Usuario user = null;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			conn= Conexion.getConnection();
			stmt =conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while(rs.next()) {
				int id_usuario = rs.getInt("id_usuario");
				String usuario = rs.getString("usuario");
				String password = rs.getString("password");
				user = new Usuario(id_usuario, usuario,password);
				usuarios.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Conexion.close(conn);
			Conexion.close(stmt);
			Conexion.close(rs);
		}
		
		
		return usuarios;
		
	}

}

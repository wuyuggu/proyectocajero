package BaseDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class UsuariosDAO extends DBManager{

	Statement statement, tempStatement;
	ResultSet resultSet, tempResultSet;
	static UsuariosDAO instance;
	
	protected UsuariosDAO(){
		
	}
	
	public static UsuariosDAO getInstance(){
		if(instance==null){
			instance = new UsuariosDAO();
		}
		return instance;
	}
	
	
	public ArrayList<UsuariosVO> getAllUsers() {
		UsuariosVO ex = null;
		ArrayList<UsuariosVO> list = new ArrayList<UsuariosVO>();
		Connection con = this.getConnection();
		try {
			statement = con.createStatement();
			resultSet = statement.executeQuery("select * from usuarios;");
			while (resultSet.next()) {
				ex = new UsuariosVO(resultSet.getString("DNI"), resultSet.getString("nombre"),
					resultSet.getString("apellido"));

				list.add(ex);
			}

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void deleteUser(UsuariosVO usuario) {
		try {
			statement = this.getConnection().createStatement();
			statement.execute("DELETE FROM usuarios WHERE DNI='" + usuario.getDni() + "';");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addUser(String dni, String nombre,  String apellido) {
		Connection con = this.getConnection();
		try {

			statement = con.createStatement();
			statement.executeUpdate(
					"INSERT INTO usuarios (DNI, nombre, apellido) VALUES ('"
							+ dni + "','" + nombre + "','" + apellido +  "');");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
	
	public void updateUser(UsuariosVO usuario) {
		Connection con = this.getConnection();
		try {
			statement = con.createStatement();
			statement.executeUpdate("UPDATE `popbl4`.`usuarios` SET `nombre`='"
					+ usuario.getNombre() + "', `apellido`='" + usuario.getApellido() + 
					"' WHERE DNI = '"+usuario.getDni()+"';");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
	}
	
}

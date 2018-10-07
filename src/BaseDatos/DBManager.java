package BaseDatos;

import java.sql.*;

public class DBManager {

	private static DBManager instance;

	private String USER = "root";
	private String PASS = "";
	private String DBNAME = "popbl4";

	protected DBManager() {

	}

	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}

	public void checkDB() {
		if (this.getConnection() != null) {
			System.out.println("FUNCIONA");
		}
	}	
	
	public Connection getConnection() {
		Connection connect = null;
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection(
					"jdbc:mysql://localhost/" + this.DBNAME + "?" + "user=" + this.USER + "&password=" + this.PASS);
			System.out.println("Conexion con la DB establecida");
			return connect;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error conectando la base de datos");
		}
		return connect;
	}

	public void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}


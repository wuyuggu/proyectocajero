package BaseDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CuentasDAO extends DBManager {


	Statement statement, tempStatement;
	ResultSet resultSet, tempResultSet;
	static CuentasDAO instance;
	
	protected CuentasDAO(){
		
	}
	
	public static CuentasDAO getInstance(){
		if(instance==null){
			instance = new CuentasDAO();
		}
		return instance;
	}
	
	public CuentasVO getCuenta(String numCuenta, int PIN) {
		CuentasVO cuenta = null;
		Connection con = this.getConnection();
		try {
			statement = con.createStatement();
			resultSet = statement.executeQuery(
					"select * from cuentas where cuenta='" + numCuenta + "' and PIN='" + PIN + "';");
			while (resultSet.next()) {

				cuenta = new CuentasVO(resultSet.getString("cuenta"), resultSet.getInt("bancoID"),
						resultSet.getInt("PIN"), resultSet.getString("DNI"),
						resultSet.getFloat("ingresos"));
//				if (resultSet.getString("type").equals("ADMIN")) {
//					user.setType(UserType.ADMIN);
//				} else {
//					user.setType(UserType.USER);
//				}
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cuenta;
	}
	
	public ArrayList<CuentasVO> getAllAcounts() {
		CuentasVO ex = null;
		ArrayList<CuentasVO> list = new ArrayList<CuentasVO>();
		Connection con = this.getConnection();
		try {
			statement = con.createStatement();
			resultSet = statement.executeQuery("select * from cuentas;");
			while (resultSet.next()) {
				ex = new CuentasVO(resultSet.getString("cuenta"), resultSet.getInt("bancoID"),
						resultSet.getInt("PIN"), resultSet.getString("DNI"),
						resultSet.getFloat("ingresos"));

				list.add(ex);
			}

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public CuentasVO getAcount(String cuenta) {
		CuentasVO ex = null;
		Connection con = this.getConnection();
		try {
			statement = con.createStatement();
			resultSet = statement.executeQuery("select * from cuentas where cuenta LIKE '" + cuenta +"';");
			while(resultSet.next()){
			ex = new CuentasVO(resultSet.getString("cuenta"), resultSet.getInt("bancoID"),
						resultSet.getInt("PIN"), resultSet.getString("DNI"),
						resultSet.getFloat("ingresos"));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ex;
	}
	
	public void deleteAcount(CuentasVO cuenta) {
		try {
			statement = this.getConnection().createStatement();
			statement.execute("DELETE FROM cuentas WHERE cuenta='" + cuenta.getCuenta() + "';");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addAcount( String cuenta, int id, int pin, String dni,  float ingresos) {
		Connection con = this.getConnection();
		try {

			statement = con.createStatement();
			statement.executeUpdate(
					"INSERT INTO cuentas (cuenta, bancoID, PIN, DNI, ingresos) VALUES ('"
							+ cuenta + "','" + id + "','" + pin +"','"+ dni +"','" + ingresos + "');");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
	public void updateAcount(CuentasVO cuenta) {
		Connection con = this.getConnection();
		try {
			statement = con.createStatement();
			statement.executeUpdate("UPDATE `popbl4`.`cuentas` SET `pin`='"
					+ cuenta.getPin() + "', `ingresos`='" + cuenta.getIngresos() + 
					"' WHERE cuenta LIKE '"+cuenta.getCuenta()+"';");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
	}
}

package BaseDatos;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BancosDAO extends DBManager{


	Statement statement, tempStatement;
	ResultSet resultSet, tempResultSet;
	static BancosDAO instance;
	
	protected BancosDAO(){
		
	}
	
	public static BancosDAO getInstance(){
		if(instance==null){
			instance = new BancosDAO();
		}
		return instance;
	}
	
	public ArrayList<BancosVO> getAllBanks() {
		BancosVO ex = null;
		ArrayList<BancosVO> list = new ArrayList<BancosVO>();
		Connection con = this.getConnection();
		try {
			statement = con.createStatement();
			resultSet = statement.executeQuery("select * from bancos;");
			while (resultSet.next()) {
				ex = new BancosVO(resultSet.getInt("ID"), resultSet.getString("banco"),
					resultSet.getString("direccion"), resultSet.getFloat("intereses"));

				list.add(ex);
			}

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void deleteBank(BancosVO banco) {
		try {
			statement = this.getConnection().createStatement();
			statement.execute("DELETE FROM bancos WHERE DNI='" + banco.getId() + "';");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addBank(int id, String banco, String direccion,  float intereses) {
		Connection con = this.getConnection();
		try {

			statement = con.createStatement();
			statement.executeUpdate(
					"INSERT INTO bancos (ID, banco, direccion, intereses) VALUES ('"
							+ id + "','" + banco + "','" + direccion +"','"+ intereses + "');");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
	public void updateBank(BancosVO banco) {
		Connection con = this.getConnection();
		try {
			statement = con.createStatement();
			statement.executeUpdate("UPDATE `popbl4`.`bancos` SET `banco`='"
					+ banco.getBanco() + "', `direccion`='" + banco.getDireccion() + 
					"', `intereses`='" + banco.getIntereses() + 
					"' WHERE ID = "+banco.getId()+";");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
	}
	
}

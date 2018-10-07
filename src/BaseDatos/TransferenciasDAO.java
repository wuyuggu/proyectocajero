package BaseDatos;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import BaseDatos.TransferenciasVO;


public class TransferenciasDAO extends DBManager {

	Statement statement, tempStatement;
	ResultSet resultSet, tempResultSet;
	static TransferenciasDAO instance;
	
	protected TransferenciasDAO(){
	
	}
	
	public static TransferenciasDAO getInstance(){
		if(instance==null){
			instance = new TransferenciasDAO();
		}
		return instance;
	}
	
	public ArrayList<TransferenciasVO> getAllTransferences() {
		TransferenciasVO ex = null;
		ArrayList<TransferenciasVO> list = new ArrayList<TransferenciasVO>();
		Connection con = this.getConnection();
		try {
			statement = con.createStatement();
			resultSet = statement.executeQuery("select * from transferencias;");
			while (resultSet.next()) {
				ex = new TransferenciasVO(resultSet.getInt("transferenciaID"), resultSet.getString("cuenta"),
					resultSet.getFloat("cantidad") , resultSet.getString("fecha"));

				list.add(ex);
			}

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void deleteTransference(TransferenciasVO transferencia) {
		try {
			statement = this.getConnection().createStatement();
			statement.execute("DELETE FROM transferencias WHERE transferenciaID=" + transferencia.getTransferenciaId() + ";");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addTransference(String cuenta, float cantidad) {
		Connection con = this.getConnection();
		try {

			statement = con.createStatement();
			statement.execute(
					"INSERT INTO transferencias (cuenta, cantidad) VALUES ('"
							+ cuenta + "','" + cantidad +"');");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
	
		
}

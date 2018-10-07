package BaseDatos;

import java.util.Date;

public class TransferenciasVO {

	private int transferenciaId;
	private String cuenta;
	private float cantidad;
	private String fecha;
	
	public TransferenciasVO(int id, String cuenta, float cantidad, String fecha) {

		this.transferenciaId = id;
		this.cuenta = cuenta;
		this.cantidad = cantidad;
		this.fecha = fecha;
		
	}
	
	public void printAllData(){
		
		System.out.println("Id:" + this.transferenciaId +"\n" + 
						"cuenta:" + this.cuenta +"\n" +
						"cantidad:" + this.cantidad +"\n" +
						"fecha:" + this.fecha +"\n");
	}

	public int getTransferenciaId() {
		return transferenciaId;
	}

	public void setTransferenciaId(int transferenciaId) {
		this.transferenciaId = transferenciaId;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	public String get(int columna){
		switch(columna){
		case 0:
			return String.valueOf(transferenciaId);
		case 1:
			return cuenta;
		case 2:
			return String.valueOf(cantidad);
		case 3:
			return fecha;
		default:
			return null;
		}
	}
	
}

package BaseDatos;

public class BancosVO {
	
	private int id;
	private String banco;
	private String direccion;
	private float intereses;


	public BancosVO(int id, String banco, String direccion, float intereses) {

		this.id = id;
		this.banco = banco;
		this.direccion = direccion;
		this.intereses = intereses;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBanco() {
		return banco;
	}


	public void setBanco(String banco) {
		this.banco = banco;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public float getIntereses() {
		return intereses;
	}


	public void setIntereses(float intereses) {
		this.intereses = intereses;
	}
}

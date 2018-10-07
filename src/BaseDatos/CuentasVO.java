package BaseDatos;

public class CuentasVO {

	private String cuenta;
	private int bancoId;
	private int pin;
	private String dni;
	private float ingresos;
	
	public CuentasVO(CuentasVO cuenta){
		this.cuenta = cuenta.cuenta;
		this.bancoId = cuenta.bancoId;
		this.pin = cuenta.pin;
		this.dni = cuenta.dni;
		this.ingresos = cuenta.ingresos;
	}

	public CuentasVO(String cuenta, int id, int pin, String dni, float ingresos) {

		this.cuenta = cuenta;
		this.bancoId = id;
		this.pin = pin;
		this.dni = dni;
		this.ingresos = ingresos;

	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public int getBancoId() {
		return bancoId;
	}

	public void setBancoId(int bancoId) {
		this.bancoId = bancoId;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public float getIngresos() {
		return ingresos;
	}

	public void setIngresos(float ingresos) {
		this.ingresos = ingresos;
	}

	public void printAllData() {

		System.out.println("cuenta:" + this.cuenta + "/n" + "bancoId:" + this.bancoId + "/n" + "pin:" + this.pin + "/n"
				+ "dni:" + this.dni + "/n" + "ingresos:" + this.ingresos + "/n");
	}

}

package RS232;
/*
 * Lib URL: https://code.google.com/archive/p/java-simple-serial-connector/wikis
 */

import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

public class RS232 {
	String[] serialPorts;
	String portName;

	public RS232() {

		serialPorts = SerialPortList.getPortNames();
		if (serialPorts.length > 0) {
			portName = serialPorts[0];
		} else {
			portName = null;
		}
		System.out.println(portName);
	}

	public void getSerialPorts() {
		String[] portNames = SerialPortList.getPortNames();
		for (int i = 0; i < portNames.length; i++) {
			System.out.println(portNames[i]);
		}
	}

	public static void main(String args[]) {
		RS232 rs = new RS232();
		rs.getSerialPorts();

		while (true) {
			String s = rs.readData();
			// rs.writeData();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		/*
		 * while(!rs.isButtonPressed()){
		 * 
		 * //rs.readData();
		 * 
		 * }
		 */

	}

	public boolean isExerciseButtonInitPressed() {
		if (readData().contains("0001")) {

			return true;
		} else {
			return false;
		}
	}

	public boolean isExerciseChangeButtonPressed() {
		if (readData().contains("0002")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isConnected() {
		if (readData().equals("0000")) {
			return true;
		} else {
			return false;
		}
	}

	public String readData() {
		SerialPort serialPort = new SerialPort(this.portName);
		String buffer = null;
		try {
			serialPort.openPort();// Open serial port
			serialPort.setParams(9600, 8, 1, 0);// Set params.
			// byte[] buffer = serialPort.readBytes(4);//Read 10 bytes from
			// serial port
			buffer = serialPort.readString(1);
			// System.out.print(buffer);
			serialPort.closePort();// Close serial port
		} catch (SerialPortException ex) {
			System.out.println(ex);
		}
		return buffer;
	}

	public void writeData() {
		SerialPort serialPort = new SerialPort(this.portName);
		try {
			serialPort.openPort();// Open serial port
			serialPort.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);// Set params. Also you can set
											// params by this string:
											// serialPort.setParams(9600, 8, 1,
											// 0);
			// serialPort.writeBytes("This".getBytes());//Write data to port
			// serialPort.writeInt(1);
			// serialPort.writeString("asdsa");
			serialPort.closePort();// Close serial port
		} catch (SerialPortException ex) {
			System.out.println(ex);
		}
	}

	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

	public static String bytesToHex(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}

}

package Vistas;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controladores.ControladorPrincipal;
import Core.MiPanel;

public class VistaTransferencia {

	/* Clase que se encarga de crear la vista de las transferencias */

	Toolkit t;

	ControladorPrincipal controlador;

	JPanel panelBotones;
	JTextField numCuenta, numCantidad;
	JLabel numCuentaL, numCantidadL;

	int estado;

	Image fondo;

	/* Constructor */

	public VistaTransferencia(ControladorPrincipal controlador, int estado) {
		this.controlador = controlador;
		this.estado = estado;
		t = Toolkit.getDefaultToolkit();
		fondo = t.createImage("iconos\\car.png");
	}

	/* Crea el panel de la ventana y sus contenidos */

	public JPanel crearPanelVentana() {
		MiPanel pVentana = new MiPanel(fondo);
		pVentana.setLayout(new BorderLayout(0, 0));
		pVentana.setBorder(BorderFactory.createEmptyBorder(35, 00, 35, 00));
		pVentana.add(crearPanelTexto(), BorderLayout.NORTH);
		pVentana.add(crearPanelBoton(), BorderLayout.CENTER);
		pVentana.add(crearPanelInferior(), BorderLayout.SOUTH);
		return pVentana;
	}

	private JPanel crearPanelTexto() {
		JPanel panelB = new JPanel();
		numCuentaL = new JLabel("Numero de cuenta:");
		panelB.add(numCuentaL);

		numCuenta = new JTextField(6);
		numCuenta.setSize(200, 50);
		panelB.add(numCuenta);

		numCantidadL = new JLabel("Cantidad a transferir:");
		panelB.add(numCantidadL);
		numCantidad = new JTextField(6);
		numCantidad.setSize(200, 50);
		panelB.add(numCantidad);
		return panelB;
	}

	private JPanel crearPanelBoton() {
		JPanel panelB = new JPanel();
		JButton botonT = new JButton();
		botonT.setText("Transferir");
		botonT.setActionCommand("Transferir");
		botonT.addActionListener(controlador);
		panelB.add(botonT);
		return panelB;
	}

	private JPanel crearPanelInferior() {
		JPanel panelInf = new JPanel(new BorderLayout(0, 0));
		JButton botonAtras = new JButton();
		botonAtras.addActionListener(controlador);
		botonAtras.setActionCommand("AtrasP");
		botonAtras.setText("ATRAS");
		panelInf.add(botonAtras, BorderLayout.WEST);
		return panelInf;
	}

	public void setNumCuenta(String linea) {
		numCuenta.setText(linea);
	}

	public String getNumCuenta() {
		return numCuenta.getText();
	}

	public void setNumCantidad(String linea) {
		numCantidad.setText(linea);
	}

	public Float getNumCantidad() {
		float num;
		if (numCantidad.getText().equals("")) {
			num = -1;
		} else {
			num = Float.parseFloat(numCantidad.getText());
		}
		return num;

	}
}
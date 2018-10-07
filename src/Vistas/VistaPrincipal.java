package Vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controladores.ControladorPrincipal;
import Core.MiPanel;

public class VistaPrincipal {

	Toolkit t;

	ControladorPrincipal controlador;
	Image fondo;
	MiPanel pVentana;

	JPanel panelAux;
	JTextField cantidad;

	String[] lineas;

	int estado;

	public VistaPrincipal(ControladorPrincipal controlador, String[] lineas, int estado) {
		t = Toolkit.getDefaultToolkit();
		fondo = t.createImage("iconos\fondoCoche.png");
		this.controlador = controlador;
		this.estado = estado;
		this.lineas = lineas;

	}

	public JPanel crearPanelVentana() {
		pVentana = new MiPanel(fondo);
		pVentana.setLayout(new BorderLayout(0, 0));

		pVentana.setBorder(BorderFactory.createEmptyBorder(35, 00, 35, 00));
		switch (estado) {
		case 1:
			break;
		case 2:
			cantidad = new JTextField();
			pVentana.add(cantidad, BorderLayout.NORTH);
			pVentana.add(crearPanelInferior(), BorderLayout.SOUTH);
		}
		panelAux = new JPanel();
		panelAux.setLayout(new GridLayout(3, 3));
		panelAux.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		panelAux.add(crearBoton(null));
		panelAux.add(crearBoton(lineas[0]));
		panelAux.add(crearBoton(null));
		panelAux.add(crearBoton(lineas[1]));
		panelAux.add(crearBoton(null));
		panelAux.add(crearBoton(lineas[2]));
		panelAux.add(crearBoton(null));
		panelAux.add(crearBoton(lineas[3]));
		panelAux.add(crearBoton(null));
		pVentana.add(panelAux, BorderLayout.CENTER);

		return pVentana;
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

	public Container crearBoton(String name) {
		if (name != null) {
			JButton boton = new JButton();
			boton = new JButton(name/* , new ImageIcon("iconos/carrito.png" */);
			boton.setActionCommand(name);
			boton.addActionListener(controlador);

			/* Visual */

			boton.setOpaque(false);
			// boton.setDisabledIcon(new ImageIcon("iconos/carrito_pro.png"));
			boton.setBackground(Color.BLUE);
			boton.setContentAreaFilled(false);
			boton.setBorderPainted(false);
			Font fuente = new Font("Calibri", 3, 20);
			boton.setForeground(Color.WHITE);
			boton.setFont(fuente);

			return boton;

		} else {
			JPanel panelNull = new JPanel();
			return panelNull;
		}

	}

	public int getEstado() {
		return estado;
	}

	public float getCantidad() {
		float num;
		if (cantidad.getText().equals("")) {
			num = -1;
		} else {
			num = Float.parseFloat(cantidad.getText());
		}
		return num;
	}

}

package Vistas;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import Controladores.ControladorLogin;
import Core.MiPanel;

public class VistaPrimera {

	/*Clase que se encarga de crear la vista inicial*/

	Toolkit t;
	
	ControladorLogin controlador;
	
	Image fondo;
	
	/*Constructor*/

	public VistaPrimera (ControladorLogin controlador) {
		this.controlador = controlador;
		t = Toolkit.getDefaultToolkit();
		fondo = t.createImage("iconos\\car.png");
	}
	
	/*Crea el panel de la ventana y sus contenidos*/

	public JPanel crearPanelVentana() {
		MiPanel pVentana = new MiPanel(fondo);
		pVentana.setLayout(new BorderLayout(0, 0));
		pVentana.setBorder(BorderFactory.createEmptyBorder(35, 00, 35, 00));
		JButton boton = new JButton();
		boton.addActionListener(controlador);
		boton.setActionCommand("go");
		pVentana.add(boton);
		return pVentana;
	}
	
	
}
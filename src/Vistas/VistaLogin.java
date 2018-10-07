package Vistas;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controladores.ControladorLogin;
import Core.MiPanel;

public class VistaLogin {

	/*Clase que se encarga de crear la vista del panel de login*/

	Toolkit t;
	
	ControladorLogin controlador;
	
	JPanel panelBotones;
	JPasswordField password;
	JButton botonA,botonC;
	
	Image fondo;
	
	/*Constructor*/

	public VistaLogin(ControladorLogin controlador) {
		this.controlador = controlador;
		t = Toolkit.getDefaultToolkit();
		fondo = t.createImage("iconos\\car.png");
	}
	
	/*Crea el panel de la ventana y sus contenidos*/

	public JPanel crearPanelVentana() {
		MiPanel pVentana = new MiPanel(fondo);
		pVentana.setLayout(new BorderLayout(0, 0));
		pVentana.setBorder(BorderFactory.createEmptyBorder(35, 00, 35, 00));
		pVentana.add(crearPanelText(), BorderLayout.CENTER);
		pVentana.add(crearPanelBotones(), BorderLayout.SOUTH);
		return pVentana;
	}
	
	/*Crea el panel con las imagenes*/

	public JPanel crearPanelText() {
		
		JPanel panelPass = new JPanel();
		panelPass.setSize(400, 150);
		panelPass.setBackground(Color.WHITE);
		int num = 4;
		password = new JPasswordField(num);
		password.addActionListener(controlador);
		password.setSize(200, 50);
		password.setEchoChar('*');
		password.setFont(new java.awt.Font("Arial", Font.BOLD, 150));
		password.setHorizontalAlignment(JTextField.CENTER);
		password.setBackground(Color.YELLOW);
		password.setForeground(Color.BLUE);
		password.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	            if (password.getText().length() >= 4 ) // limit to 4 characters
	                e.consume();
	        }
	    });
		
		password.setToolTipText("Introduzca Pin de 4 digitos");
		panelPass.add(password);
		panelPass.setOpaque(true);
		return panelPass;
	}

	public JPanel crearPanelBotones(){
		panelBotones = new JPanel();
		panelBotones.setSize(300,200);
		panelBotones.setBackground(Color.WHITE);
		botonA = new JButton();
		botonA.setText("Aceptar");
		botonA.setActionCommand("Aceptar");
		botonA.addActionListener(controlador);
		panelBotones.add(botonA);
		botonC = new JButton();
		botonC.setText("Cancelar");
		botonC.setActionCommand("Cancelar");
		botonC.addActionListener(controlador);
		panelBotones.add(botonC);
		panelBotones.setOpaque(true);
		return panelBotones;
	}
	
	public JPasswordField getPass(){
		return password;
	}

}
package Vistas;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import BaseDatos.TransferenciasVO;

import Controladores.ControladorPrincipal;
import Core.MiPanel;
import Modelos.ModeloConsultas;

public class VistaConsulta {

	/*Clase que se encarga de crear la vista de las consultas*/

	Toolkit t;
	
	ControladorPrincipal controlador;
	ModeloConsultas modelo;
	
	JScrollPane panelTabla;
	JPanel panelBotones;
	
	JTable tablaConsultas;
	int estado;
	
	Image fondo;
	
	/*Constructor*/

	public VistaConsulta(ControladorPrincipal controlador,int estado) {
		this.controlador = controlador;
		this.estado = estado;
		t = Toolkit.getDefaultToolkit();
		fondo = t.createImage("iconos\\car.png");
	}
	
	/*Crea el panel de la ventana y sus contenidos*/

	public JPanel crearPanelVentana() {
		MiPanel pVentana = new MiPanel(fondo);
		pVentana.setLayout(new BorderLayout(0, 0));
		pVentana.setBorder(BorderFactory.createEmptyBorder(35, 00, 35, 00));
		pVentana.add(crearPanelTabla(), BorderLayout.CENTER);
		pVentana.add(crearPanelInferior(), BorderLayout.SOUTH);
		return pVentana;
	}
	
	/*Crea el panel con la tabla*/

	public JScrollPane crearPanelTabla() {
		
		panelTabla = new JScrollPane();
		panelTabla.setSize(400, 150);
		panelTabla.setBackground(Color.WHITE);

		tablaConsultas = new JTable();

		panelTabla.setOpaque(true);
		panelTabla.setViewportView(tablaConsultas);
		return panelTabla;
	}

	private JPanel crearPanelInferior(){
		JPanel panelInf = new JPanel(new BorderLayout(0,0));
		JButton botonAtras = new JButton();
		botonAtras.addActionListener(controlador);
		botonAtras.setActionCommand("AtrasP");
		botonAtras.setText("ATRAS");
		panelInf.add(botonAtras,BorderLayout.WEST);
		return panelInf;
	}
	
	public void setModeloTabla(ArrayList<TransferenciasVO> lista){
		modelo = new ModeloConsultas(lista);
		tablaConsultas.setModel(modelo);
	}

}
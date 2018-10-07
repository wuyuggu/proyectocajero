package Core;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import BaseDatos.CuentasVO;
import Controladores.ControladorLogin;
import Controladores.ControladorPrincipal;
import Vistas.VistaConsulta;
import Vistas.VistaLogin;
import Vistas.VistaPrimera;
import Vistas.VistaPrincipal;
import Vistas.VistaTransferencia;

public class Principal {
	
	public JFrame ventanaCajero;
	public CardLayout cardLayout;
	ControladorLogin controlador;
	ControladorPrincipal controladorP;

	Image fondo;
	VistaPrimera vistaPrim;
	VistaLogin vistaLogin;
	VistaConsulta vistaConsulta;
	VistaPrincipal vistaPrincipal,vistaPrincipalSacar;
	VistaTransferencia vistaTrans;

	public JPanel panelCajero, panelPrincipal, panelLogin, panelPrim, panelSacarMeter, panelConsultas, panelTrans;
	
	CuentasVO mainCuenta;
	
	public Principal(){/*Constructor*/
		ventanaCajero = new JFrame("Cajero");
		
		crearControladorLogin();
		crearControladorPrincipal();
		
		construyePanelPrimero();
		construyePanelLogin();
		construyePanelSacar();
		construyePanelConsultas();
		construyePanelTransferencias();
		construyePanelPrincipal();
		/*CONSTRUIR PANELES AQUI*/
		
		construyePanel();
		construyeVentana();
	}
	
	private void construyePanelPrimero() {
		vistaPrim = new VistaPrimera(controlador);
		panelPrim = vistaPrim.crearPanelVentana();
	}

	private void construyePanelPrincipal() {
		String lineas[] ={"Consultas","Sacar/Meter","Transferencias","OtrasOpciones"};
		
		vistaPrincipal = new VistaPrincipal(controladorP,lineas,1);
		panelPrincipal = vistaPrincipal.crearPanelVentana();
	}
	
	private void construyePanelSacar() {
		String lineas[] ={null,"Sacar","Meter",null};
		vistaPrincipalSacar = new VistaPrincipal(controladorP,lineas,2);
		panelSacarMeter = vistaPrincipalSacar.crearPanelVentana();
	}
	
	private void construyePanelConsultas() {
		vistaConsulta = new VistaConsulta(controladorP,3);
		panelConsultas = vistaConsulta.crearPanelVentana();
	}
	
	private void construyePanelTransferencias() {
		vistaTrans = new VistaTransferencia(controladorP,4);
		panelTrans = vistaTrans.crearPanelVentana();
	}
	
	private void construyePanelLogin() {
		vistaLogin = new VistaLogin(controlador);
		panelLogin = vistaLogin.crearPanelVentana();
	}

	private void crearControladorLogin() {
		controlador = new ControladorLogin(this);	
	}
	
	private void crearControladorPrincipal() {
		controladorP = new ControladorPrincipal(this);	
	}

	private void construyePanel() {
		panelCajero= new JPanel();
		cardLayout = new CardLayout();
		panelCajero.setLayout(cardLayout);
		panelCajero.add(panelPrim, "PanelInicio");
		panelCajero.add(panelLogin, "PanelLogin");
		panelCajero.add(panelPrincipal, "PanelPrincipal");
		panelCajero.add(panelSacarMeter, "PanelSacarMeter");
		panelCajero.add(panelConsultas, "PanelConsultas");
		panelCajero.add(panelTrans, "PanelTransferencias");
		
	}

	

	private void construyeVentana() {
		ventanaCajero.setIconImage(new ImageIcon("iconos\\car.png").getImage());		
		ventanaCajero.setVisible(true);
		ventanaCajero.setSize(1280, 720);
		ventanaCajero.setResizable(false);
		ventanaCajero.setLocationRelativeTo(null);
		ventanaCajero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaCajero.add(new JLabel("Cajero"),BorderLayout.NORTH);
		ventanaCajero.add(panelCajero,BorderLayout.CENTER);
	}

	public void dispose(){
		ventanaCajero.dispose();
	}
	
	public CuentasVO getCuenta(){
		return mainCuenta;
	}
	
	public void setCuenta(CuentasVO cuenta){
		this.mainCuenta = cuenta;
	}
	
	public VistaLogin getVistaLog(){
		return vistaLogin;
	}
	
	public VistaConsulta getVistaCon(){
		return vistaConsulta;
	}
	
	public VistaTransferencia getVistaTrans(){
		return vistaTrans;
	}
	
	public VistaPrincipal getVistaPrincipalSacar(){
		return vistaPrincipalSacar;
	}
	

	public static void main(String[] args) {
		/*Le aplica un look and Feel a todo el programa*/
		
		try{
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			//			  UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		new Principal();
	}

}

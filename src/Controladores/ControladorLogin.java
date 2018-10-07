package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BaseDatos.CuentasDAO;
import BaseDatos.CuentasVO;
import BaseDatos.UsuariosDAO;
import Core.Principal;

public class ControladorLogin implements ActionListener {

	Principal vista;
	CuentasVO cuenta;

	/* Constructor */

	public ControladorLogin(Principal vista) {
		this.vista = vista;
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Cancelar")) {
			vista.cardLayout.show(vista.panelCajero, "PanelInicio");
		}
		
		if (e.getActionCommand().equals("go")) {
			vista.cardLayout.show(vista.panelCajero, "PanelLogin");
		}
		
		if (e.getActionCommand().equals("Aceptar")) {
			
			String pass = new String(vista.getVistaLog().getPass().getPassword());
			int PIN = Integer.parseInt(pass);
			
			if(pass.length() == 4 ){
				cuenta = CuentasDAO.getInstance().getCuenta("AAA123", PIN);	
				if(cuenta != null){
					cuenta.printAllData();
					vista.setCuenta(cuenta);
					vista.cardLayout.show(vista.panelCajero, "PanelPrincipal");
				}else{
					//MENSAJE WRONG SIZE
					vista.getVistaLog().getPass().setText("");
				}
			}else{
				//MENSAJE WRONG PASS
				vista.getVistaLog().getPass().setText("");
			}
			
		}

	}

}

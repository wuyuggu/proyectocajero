package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BaseDatos.CuentasDAO;
import BaseDatos.CuentasVO;
import BaseDatos.TransferenciasDAO;
import BaseDatos.TransferenciasVO;
import Core.Principal;
import RS232.RS232;

public class ControladorPrincipal implements ActionListener {

	Principal vista;

	ArrayList<TransferenciasVO> transferencias;
	CuentasVO cuenta;

	String previousCard;

	int estado = 1;

	/* Constructor */

	public ControladorPrincipal(Principal vista) {
		this.vista = vista;
		cuenta = vista.getCuenta();
		goData();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Transferir")) {
			float cantidad = vista.getVistaTrans().getNumCantidad();
			String numCuenta = vista.getVistaTrans().getNumCuenta();

			if (cantidad != -1 || numCuenta == null) {
				JOptionPane.showMessageDialog(null,
						"No has seleccionado ninguna cantidad o la cuenta seleccionada no existe", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				CuentasVO auxiliar = new CuentasVO(CuentasDAO.getInstance().getAcount(numCuenta));
				transferencias = TransferenciasDAO.getInstance().getAllTransferences();

				auxiliar.setIngresos((auxiliar.getIngresos() - cantidad));
				vista.getCuenta().setIngresos((vista.getCuenta().getIngresos() + cantidad));

				CuentasDAO.getInstance().updateAcount(vista.getCuenta());
				CuentasDAO.getInstance().updateAcount(auxiliar);

				TransferenciasDAO.getInstance().addTransference(vista.getCuenta().getCuenta(), -cantidad);
				TransferenciasDAO.getInstance().addTransference(auxiliar.getCuenta(), cantidad);
				vista.getVistaTrans().setNumCuenta("");
			}
		}

	}

	public void goData() {

		Thread t = new Thread(new Runnable() {
			Boolean out = false;

			@Override
			public void run() {
				RS232 rs = new RS232();
				rs.getSerialPorts();

				while (!out) {
					String s = rs.readData();
					if (s != null) {
						changeWindow(s);
						out = true;
					}
					// rs.writeData();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});
		t.start();

	}

	public int sentEstado() {
		return estado;
	}

	public void changeWindow(String s) {

		if (s.equals("w")) {
			if (estado == 1) {
				previousCard = "PanelPrincipal";
				estado = 2;
				vista.cardLayout.show(vista.panelCajero, "PanelSacarMeter");
				goData();
			} else {
				float cantidad;
				transferencias = TransferenciasDAO.getInstance().getAllTransferences();
				cantidad = vista.getVistaPrincipalSacar().getCantidad();
				if (cantidad != -1) {
					vista.getCuenta().setIngresos((vista.getCuenta().getIngresos() - cantidad));
					System.out.println("ingresos nuevos:  " + vista.getCuenta().getIngresos());

					CuentasDAO.getInstance().updateAcount(vista.getCuenta());

					TransferenciasDAO.getInstance().addTransference(vista.getCuenta().getCuenta(), cantidad);
				} else {
					JOptionPane.showMessageDialog(null, "No has seleccionado ninguna cantidad", "Error",
							JOptionPane.ERROR_MESSAGE);
					goData();
				}
			}
		}

		if (s.equals("n")) {
			previousCard = "PanelPrincipal";
			estado = 3;
			ArrayList<TransferenciasVO> transferenciasAux = TransferenciasDAO.getInstance().getAllTransferences();
			transferencias = new ArrayList<>();
			for (TransferenciasVO t : transferenciasAux) {
				if (t.getCuenta().equals(vista.getCuenta().getCuenta())) {
					transferencias.add(t);
				}
			}
			vista.getVistaCon().setModeloTabla(transferencias);
			vista.cardLayout.show(vista.panelCajero, "PanelConsultas");
			goData();

		}

		if (s.equals("e")) {
			if (estado == 1) {
				previousCard = "PanelPrincipal";
				estado = 4;
				vista.cardLayout.show(vista.panelCajero, "PanelTransferencias");
				goData();
			} else {
				float cantidad;
				transferencias = TransferenciasDAO.getInstance().getAllTransferences();
				cantidad = vista.getVistaPrincipalSacar().getCantidad();
				if (cantidad != -1) {
					vista.getCuenta().setIngresos((vista.getCuenta().getIngresos() + cantidad));
					System.out.println("ingresos nuevos:  " + vista.getCuenta().getIngresos());

					CuentasDAO.getInstance().updateAcount(vista.getCuenta());

					TransferenciasDAO.getInstance().addTransference(vista.getCuenta().getCuenta(), cantidad);
				} else {
					JOptionPane.showMessageDialog(null, "No has seleccionado ninguna cantidad", "Error",
							JOptionPane.ERROR_MESSAGE);
					goData();
				}
			}
		}

		if (s.equals("c")) {
			if (estado == 10) {

			} else {
				if (previousCard.equals("PanelPrincipal")) {
					estado = 1;
				}
				vista.cardLayout.show(vista.panelCajero, previousCard);
				goData();
			}
		}

		if (s.equals("a")) {

		}

	}

}
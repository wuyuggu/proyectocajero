package Modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import BaseDatos.TransferenciasVO;

public class ModeloConsultas extends AbstractTableModel{


	String[] columnas = { "TransferenciaID", "Cuenta", "Cantidad" ,"Fecha"};
	List<TransferenciasVO> listaTrans;
    TransferenciasVO trans;
	

	public ModeloConsultas(ArrayList<TransferenciasVO> lista) {
		listaTrans = lista;
		this.fireTableDataChanged();
	}
	
	@Override
	public int getRowCount() {
		return listaTrans.size();
	}

	@Override
	public String getColumnName(int column) {
		return columnas[column];
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnas.length;
	}

	@Override
	public Object getValueAt(int fila, int columna) {
		TransferenciasVO transferencia = listaTrans.get(fila);
		return transferencia.get(columna);
	}
}
package componentesTablas.renderer;
import java.awt.*;

import javax.swing.*;
import javax.swing.table.TableColumn;

public class TablaCombos extends JFrame{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		new TablaCombos();
	}
	public TablaCombos() {
		JTable tabla=new JTable(6,5);
		Font fuente=new Font("Verdana",Font.BOLD,15);
		tabla.setFont(fuente);
		tabla.setRowHeight(30);
		tabla.setBackground(Color.LIGHT_GRAY);
		tabla.setForeground(Color.WHITE);
		TableColumn tablaColumna=tabla.getColumnModel().getColumn(3);
		JComboBox<String>combo=obtenerCeldaCombo();
		DefaultCellEditor renderizador=new DefaultCellEditor(combo);
		tablaColumna.setCellEditor(renderizador);
		add(tabla);
		setLocationRelativeTo(null);
		setSize(500,400);
		setVisible(true);
	}
	private JComboBox<String> obtenerCeldaCombo() {
		JComboBox<String> retorno=new JComboBox<String>();
		retorno.addItem("Mario");
		retorno.addItem("Sergio");
		retorno.addItem("Luis");
		retorno.addItem("Pablo");
		retorno.addItem("Gustavo");
		retorno.addItem("Victor I");
		retorno.addItem("Victor II");
		retorno.addItem("Walid");
		retorno.addItem("Carlos");
		retorno.addItem("Arturo");
		return retorno;
	}
}

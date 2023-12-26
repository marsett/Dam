package componentesTablas.ordenaciontablas;
import javax.swing.*;
import javax.swing.table.*;

public class TablaFiltrada extends JFrame{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		new TablaFiltrada();
	}
	public TablaFiltrada() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		TableModel modelo=getDatosTabla();
		JTable tabla=new JTable(modelo);
		JScrollPane pane=new JScrollPane(tabla);
		this.add(pane);
		setSize(800,400);
		setVisible(true);
	}
	private TableModel getDatosTabla() {
		Object[][]rowData= {
				{"Café cortado", 1.05},
				{"Café con leche", 1.25},
				{"Café con hielo", 1.15},
				{"Café capuccino", 1.65},
				{"Café descafeinado", 1.35},
				{"Café descafeinado con leche", 1.25},
				{"Café irlandes", 1.75}
		};
		Object[]titulos= {"Bebida","Precio"};
		TableModel modelo=new DefaultTableModel(rowData,titulos) {
			Class valor;
			@Override
			public Class<?> getColumnClass(int column) {
				if((column>=0)&&(column<getColumnCount())) {
					valor=getValueAt(0, column).getClass();
				}else {
					valor=Object.class;
				}
				return valor;
			}
		};
		return modelo;
	}
}

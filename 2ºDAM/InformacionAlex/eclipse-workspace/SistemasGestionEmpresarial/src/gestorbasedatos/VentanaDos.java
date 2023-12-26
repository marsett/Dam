package gestorbasedatos;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import gestorbasedatos.VentanaUno.Modelo;

public class VentanaDos extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel esquemas, tablas;
	private JComboBox<String> comboEsquemas, comboTablas;
	private JTextArea textoArea;
	private JPanel panelNorte, panelCentral;
	private static Modelo modelo;
	protected Connection conexion;
	protected Statement stmt;
	protected DatabaseMetaData dbmd;
	public static void main(String[] args) throws SQLException {
		new VentanaDos(modelo);
	}
	public VentanaDos(Modelo modelo) throws SQLException {
		super("Ventana 2");
		VentanaDos.modelo=modelo;
		crearInterfaz();
		conexion();
	}
	public void crearInterfaz() {
		System.out.println("se crea la interfaz");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		panelNorte=new JPanel();
		panelCentral=new JPanel();
		add(panelNorte,BorderLayout.NORTH);
		add(panelCentral,BorderLayout.CENTER);
		esquemas=new JLabel("Esquemas");
		tablas=new JLabel("Tablas");
		comboEsquemas=new JComboBox<>();
		comboEsquemas.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println("recargar tablas");
				try {
					getTablas(dbmd,comboEsquemas.getSelectedItem().toString());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		comboTablas=new JComboBox<>();
		comboTablas.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
					System.out.println("itemStateChanged. cambio combo esquemas");
					String esquemaSeleccionado=(String)comboEsquemas.getSelectedItem();
					String tablaSeleccionada=null;
					JComboBox<String> cb=(JComboBox<String>)(e.getSource());	//referencia al elemento que ha recibido el evento
					if(e.getStateChange()==ItemEvent.SELECTED) {
						tablaSeleccionada=(String)cb.getSelectedItem();
						System.out.println("Esquema: "+esquemaSeleccionado+" tabla: "+tablaSeleccionada);
						getCampos(esquemaSeleccionado, tablaSeleccionada);
					}
			}
		});
		textoArea=new JTextArea();
		panelCentral.setLayout(null);
		panelNorte.add(esquemas);
		panelNorte.add(comboEsquemas);
		panelNorte.add(tablas);
		panelNorte.add(comboTablas);
		panelCentral.add(textoArea);
		textoArea.setLineWrap(true);
		textoArea.setBounds(75,30,430,430);
		textoArea.setEditable(true);
		textoArea.setBorder(new CompoundBorder(new EtchedBorder(),new LineBorder(Color.BLACK)));
		setSize(600,600);
		setVisible(true);
	}
	public void conexion() throws SQLException{
		System.out.println("se crea la conexion");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		String url="jdbc:mysql://localhost:3306/";
		String url2=url+modelo.cuadroDefaultSchema;
		System.out.println(">>>>>>>>>>>>>"+url2);
		
			conexion=DriverManager.getConnection(url2,modelo.cuadroUserName,modelo.cuadroPassword);
			stmt=conexion.createStatement();
				
			dbmd=conexion.getMetaData();
			getEsquemas(dbmd);
	}
	public void getEsquemas(DatabaseMetaData dbmd) throws SQLException {
		System.out.println("getEsquemas()");
		comboEsquemas.removeAll();
		ResultSet catalogos=dbmd.getCatalogs();
		String nombreCatalogo=null;
		while(catalogos.next()) {
			nombreCatalogo=catalogos.getString(1);
			System.out.println(nombreCatalogo);
			comboEsquemas.addItem(nombreCatalogo);
		}
	}
	public void getTablas(DatabaseMetaData dbmd,String nombreEsquema) throws SQLException{
		System.out.println("getTablas() "+nombreEsquema);
		comboTablas.removeAllItems();
		String catalogo=null;
		String patronTabla="%";//%";//"f%"
		String[] tipos=null;
		ResultSet tablas=dbmd.getTables(nombreEsquema, catalogo,  patronTabla, tipos);
		String nombreTabla=null;
		while(tablas.next()) {
			nombreTabla=tablas.getString(3);
			System.out.println("anado tabla al combo "+nombreTabla);
			comboTablas.addItem(nombreTabla);
		}
		System.out.println(">>>>>>fin getTables()");
	}
	public void getCampos(String nombreEsquema, String nombreTabla) {
		System.out.println("getCampos() "+nombreEsquema+" "+nombreTabla);
		try {
			DatabaseMetaData dbmd=conexion.getMetaData();
			textoArea.setText("");
			String catalogo=null;
			//String patronColumna="%";
			String formatoCol=null;
			ResultSet rsColumnas=dbmd.getColumns(nombreEsquema, catalogo, nombreTabla, formatoCol);
			//String formato2="%1$25s %2$25s %3$25s %n";

			String columna, tipo;
			StringBuilder sb=new StringBuilder();
			while(rsColumnas.next()){
				columna=rsColumnas.getString(4);
				tipo=rsColumnas.getString(6);
				System.out.println("getCampos()->  Columna: "+columna+" Tipo:"+tipo);
				sb.append(columna+" \t "+tipo+"\n");
			}
			textoArea.setText(new java.util.Date()+"\n"+sb.toString());
			
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
	}
}

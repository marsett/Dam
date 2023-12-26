package examendi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class SplitPaneBasico extends JFrame implements ItemListener{
	private static final long serialVersionUID = 1L;
	Dimension dim = new Dimension(200, 30);
	JPanel panelIzquierdo , panelArriba, panelAbajo;
	JComboBox<String> drives, comboDirectorios;
	JTree tree =null;
	JSplitPane splitPaneVertical, splitPaneHorizontal;
	JScrollPane scrollpane;
	ModeloDatos modeloDatos;
	private File directorio;
	
	JTextField cajaNombre, cajaRuta, cajaFecha, cajaTamano;
	
	public static void main(String[] a) {
		new SplitPaneBasico();
	}

	private JSplitPane obtenerPanelVertical(JPanel panelArriba, JPanel panelAbajo) {
		JSplitPane retorno=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		retorno.setDividerSize(20);
		retorno.setDividerLocation(250);
		retorno.setTopComponent(panelArriba);
		retorno.setBottomComponent(panelAbajo);
		return retorno;
	}
	public SplitPaneBasico() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		File carpeta = new File("c:\\javam");
		
	    modeloDatos= new ModeloDatos();
	    panelArriba = new JPanel();
	    panelArriba.setLayout(new BorderLayout());
	    tree = new JTree(modeloDatos);

		scrollpane = new JScrollPane();
		scrollpane.getViewport().add(tree);

		panelArriba.add(BorderLayout.CENTER, scrollpane);
		
		panelIzquierdo = obtenerPanelCombos();		
		panelAbajo = obtenerPanelDetalle(carpeta);

		splitPaneVertical = obtenerPanelVertical(panelArriba, panelAbajo);
		splitPaneHorizontal = obtenerPanelHorizontal(panelIzquierdo, splitPaneVertical);

		getContentPane().add(splitPaneHorizontal, BorderLayout.CENTER);
		setSize(850, 500);
		setVisible(true);
	
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
				System.out.println("You selected " + node);
				
				File fichero=new File(node.toString());
				if(fichero.exists())
					System.out.println("EXISTE");
				else
					System.out.println("NO EXISTE");
				
				actualizarPanelDetalleFicheros(fichero);
			}
		});
	}
	
	private JSplitPane obtenerPanelHorizontal(JPanel panelIzquierdo2, JSplitPane splitPaneVertical2) {
		JSplitPane splitPaneHorizontal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPaneHorizontal.setLeftComponent(panelIzquierdo);
		splitPaneHorizontal.setRightComponent(splitPaneVertical);
		splitPaneHorizontal.setDividerLocation(250);
		return splitPaneHorizontal;
	}

	private void actualizarPanelDetalleFicheros(File fichero) {
		cajaNombre.setText(fichero.getName());
		cajaRuta.setText(fichero.getAbsolutePath());
		
		Date fecha=new Date(fichero.lastModified());
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		
		cajaFecha.setText(sdf.format(fecha));
		cajaTamano.setText(String.valueOf(fichero.length()));
		panelAbajo.validate();
		panelAbajo.repaint();
		
		
	}
	private JPanel obtenerPanelDetalle(File directorio) {
		JPanel retorno=new JPanel();

		cajaNombre=new JTextField(); cajaNombre.setEditable(false);
		cajaFecha=new JTextField();cajaFecha.setEditable(false);
		cajaRuta=new JTextField();cajaRuta.setEditable(false);
		cajaTamano=new JTextField();cajaTamano.setEditable(false);
		  retorno.setLayout( new BoxLayout(retorno,BoxLayout.Y_AXIS));
			
		  retorno.add(new JLabel("Nombre"));
		  retorno.add(cajaNombre);
		  
		  retorno.add(new JLabel("Ruta"));
		  retorno.add(cajaRuta);
		  
		  retorno.add(new JLabel("Tamaño"));
		  retorno.add(cajaTamano);
		  
		  retorno.add(new JLabel("Fecha"));
		  retorno.add(cajaFecha);
		  
		  
		return retorno;
	}
	
	private void obtenerPanelArbol(File directorio) {
		modeloDatos.cargar(directorio.getAbsolutePath());
	}
	
	private JPanel obtenerPanelCombos() {
		JPanel p = new JPanel();
		p.setAlignmentX(LEFT_ALIGNMENT);
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.add(new JLabel("drives"));
		drives = obtenerComboDrives();
		drives.addItemListener(e-> generarCarpetas());
		
		p.add(drives);
		comboDirectorios = obtenerComboDirectorios();
		p.add(new JLabel("Directorios"));
		p.add(comboDirectorios);
		return p;
	}



	private JComboBox<String> obtenerComboDrives() {
		drives=new JComboBox<String>();		
		drives.setSize(dim);
		drives.setPreferredSize(dim);
		drives.setMaximumSize(dim);	
	

		File[] unidades = File.listRoots();
		for (File disco : unidades) {
			if (disco!=null) {
				String unid=disco.getPath();
				drives.addItem(unid);
		
			}
		}
		return drives;
	}
	
	private void generarCarpetas() {
		
		String drive=drives.getSelectedItem().toString();
		System.out.println("****ACTUALIZAR COMBO CARPETAS "+drive);
		if(drive==null)
			comboDirectorios=new JComboBox<String>();
		else
			comboDirectorios = obtenerComboDirectorios();
		
	}

	private JComboBox<String> obtenerComboDirectorios() {
		String drive=drives.getSelectedItem().toString();
		System.out.println("obtener directorios de "+drive);
		
		comboDirectorios=new JComboBox<String>();
		comboDirectorios.addItemListener(this);
		comboDirectorios.setSize(dim);
		comboDirectorios.setPreferredSize(dim);
		comboDirectorios.setMaximumSize(dim);	

	
		
		File carpeta = new File(drive);

		if (carpeta.exists()) {
			File[] ficheros = carpeta.listFiles(); 
			for (File f : ficheros) {
				if (f != null) {
					comboDirectorios.addItem(f.getName());
				}
			}
		}
		return comboDirectorios;
	}



	@Override
	public void itemStateChanged(ItemEvent e) {
		String padre=(String) drives.getSelectedItem();
		String directorioCombo=((JComboBox<String>)e.getSource()).getSelectedItem().toString();

	
		directorio=new File(padre,directorioCombo);
		System.out.println("creando arbol de "+directorio.getAbsolutePath());
		modeloDatos.cargar(directorio.getAbsolutePath());

		tree.revalidate();
		for (int i = 0; i < tree.getRowCount(); i++) {
			tree.expandRow(i);
		}
		scrollpane.revalidate();
		scrollpane.repaint();			
	}
	
	
}
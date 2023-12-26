package menus;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.*;

public class VentanaMenu extends JFrame{
	private static final long serialVersionUID = 1L;
	JMenu menu, menu2, submenu;
	JMenuBar barra;
	JMenuItem item1,item2,item3, item4, item5, item6;
	JRadioButtonMenuItem rbt1, rbt2;
	
	public VentanaMenu() {
		super("Usando menu");
		
		menu=new JMenu("Mi menu 1");
		menu.setToolTipText("AYUDA");
		menu2=new JMenu("Mi menu 2");
		
		item1=new JMenuItem("Archivo");
		//atajo de teclado
		item1.setMnemonic(KeyEvent.VK_F);
		item1.getAccessibleContext().setAccessibleDescription("a text");
		
		ManejadorExterno manejadorExterno=new ManejadorExterno();//manejador unico para todos los items del menu
		item1.addActionListener(manejadorExterno);
		item2=new JMenuItem("Ventana", KeyEvent.VK_E);
		KeyStroke tecla2=KeyStroke.getKeyStroke("Z");
		item2.setAccelerator(tecla2);
		item2.addActionListener(manejadorExterno);
		item3=new JMenuItem("Salida");
		KeyStroke tecla3=KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK);
		item3.setAccelerator(tecla3);
		item3.addActionListener(manejadorExterno);
		
		ImageIcon icono=obtenerImagen("../imagenes/kiko2.jpg", "Kiko Matamoros");
		JMenuItem itemImagen=new JMenuItem(icono);

		
		//pueden ser utiles para configuracion: por ejemplo, poner el eclipse en negro
		JCheckBoxMenuItem menuCheck=new JCheckBoxMenuItem("Nombre");
		JCheckBoxMenuItem menuCheck2=new JCheckBoxMenuItem("Apellido");
		
		
		rbt1=new JRadioButtonMenuItem("Boton 1");
		rbt2=new JRadioButtonMenuItem("Boton 2");
		ButtonGroup grupo=new ButtonGroup();
		grupo.add(rbt1);
		grupo.add(rbt2);
		menu.addSeparator();
		menu.add(rbt1);
		menu.add(rbt2);
		
		item4=new JMenuItem("Uno");
		item5=new JMenuItem("Dos");
		item6=new JMenuItem("Tres");
		menu.add(item1);
		menu.add(menuCheck);
		menu.add(item2);
		menu.add(item3);
		menu2.add(item4);
		menu2.addSeparator();
		menu2.add(item5);
		menu2.addSeparator();
		menu2.add(item6);
		menu2.add(itemImagen);
		
		submenu=new JMenu("Un Submenu");
		submenu.add(new JMenuItem("Opcion 1 del Submenu"));
		submenu.add(new JMenuItem("Opcion 2 del Submenu"));
		submenu.add(new JMenuItem("Opcion 3 del Submenu"));
		menu2.add(submenu);
	
		barra=new JMenuBar();
		FlowLayout fl=new FlowLayout();
		fl.setAlignment(FlowLayout.CENTER);
		barra.setLayout(fl);
		barra.add(menu);
		barra.add(menu2);
		barra.add(menuCheck2);
		/*barra.add(rbt1);
		barra.add(rbt2);*/
		/*JLabel etiqueta=new JLabel(obtenerImagen("../imagenes/kiko.png", "Kiko Matamoros"));
		this.add(etiqueta);*/
		this.setJMenuBar(barra);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new VentanaMenu();
	}
	private ImageIcon obtenerImagen(String ruta, String descripcion) {
		URL imgUrl=getClass().getResource(ruta);
		if(imgUrl!=null) {
			return new ImageIcon(imgUrl, descripcion);
		}
		else {
			System.err.println("No ha encontrado imagen en "+ruta);
			return null;
		}
	}
}

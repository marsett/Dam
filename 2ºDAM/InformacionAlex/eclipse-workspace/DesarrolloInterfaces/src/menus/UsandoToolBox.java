package menus;
import java.awt.*;
import java.net.URL;

import javax.swing.*;

public class UsandoToolBox extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel cabecera, status;
	private JPanel controlPanel;
	public UsandoToolBox() {
		// TODO Auto-generated constructor stub
		super("Un ToolBox");
		setSize(500,400);
		setLayout(new GridLayout(3,1));
		cabecera=new JLabel("Cabecera",JLabel.CENTER);
		status=new JLabel("Barra de Sistema",JLabel.CENTER);
		status.setSize(350,100);
		controlPanel=new JPanel();
		controlPanel.setLayout(new FlowLayout());
		add(controlPanel);
		add(cabecera);
		add(status);
		JButton boton1=new JButton("Alfa");
		ImageIcon icono=obtenerImagen("../imagenes/kiko2.jpg", "Kiko Matamoros");
		JMenuItem itemImagen=new JMenuItem(icono);
		boton1.add(itemImagen);
		JButton boton2=new JButton("Beta");
		JButton boton3=new JButton("Gamma");
		JToolBar toolBar=new JToolBar("Mi ToolBar");
		toolBar.add(boton1);
		toolBar.add(boton2);
		toolBar.add(boton3);
		controlPanel.add(toolBar);
		setVisible(true);
	}
	public static void main(String[] args) {
		new UsandoToolBox();
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

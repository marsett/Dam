package dialogos;
import java.awt.FileDialog;
import java.io.File;
import java.net.URL;

import javax.swing.*;

public class Dialogos extends JFrame{
	private static final long serialVersionUID = 1L;
	JPanel panelCentral;
	FileDialog fd;
	JFileChooser fileDialog;
	public static void main(String[] args) {
		new Dialogos();
	}
	public Dialogos(){
		super("Usando diferentes dialogos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fileDialog=new JFileChooser();
		setBounds(100,100,450,450);
		panelCentral=new JPanel();
		setContentPane(panelCentral);//asigna por defecto un panel: tu asignas tu propio panel creado;
									 //ademas, anade el panel de por si
		
		panelCentral.setLayout(null);
		ImageIcon icono=obtenerImagen("../imagenes/kiko2.jpg", "Kiko Matamoros");
		JButton boton1=new JButton("Boton 1");
		boton1.setBounds(100, 140, 300, 40);
		boton1.addActionListener(e->{
			/*JOptionPane.showMessageDialog(this,"Esto es un dialogo",
					"Titulo del Dialogo",JOptionPane.ERROR_MESSAGE);*/
			//WARNING_MESSAGE,INFORMATION_MESSAGE,QUESTION_MESSAGE
			//el this hace que, si muere la primera ventana, también muere este mensaje
			//se hace referencia al 'contenedor padre'
			
			//se le puede poner un icono
			/*JOptionPane.showMessageDialog(this,"Esto es un dialogo",
					"Titulo del Dialogo",0,icono);*/
			
			int respuesta=JOptionPane.showOptionDialog(this, "Esto es una pregunta a responder", "Pregunta", 
					JOptionPane.YES_NO_CANCEL_OPTION, 1, null, null, null);
			System.out.println("Opcion Seleccionada: "+respuesta);
		});
		/*JButton boton2=new JButton("Boton 2");
		boton2.setBounds(100, 180, 300, 40);*/
		
		JButton botonCrearVentana=new JButton("Crear Ventana");
		botonCrearVentana.setBounds(100,100,300,40);
		botonCrearVentana.addActionListener(e->{
			/*System.out.println("Abriendo Ventana...");
			new DialogoPersonalizado();*/
			/*fd=new FileDialog(this);
			fd.setBounds(400,400,400,400);
			
			
			fd.setVisible(true);
			System.out.println(fd.getFile());*/
	
			fileDialog.setBounds(400,400,400,400);
			fileDialog.showOpenDialog(this);
			File ficheroSeleccionado=fileDialog.getSelectedFile();
			System.out.println(ficheroSeleccionado);
		});
		
		JButton boton3=new JButton("ShowInputDialog");
		boton3.setBounds(100,180,300,40);
		boton3.addActionListener(e->{
			System.out.println("Usando ShowInputDialog");
			String nombre=JOptionPane.showInputDialog("Introduce tu nombre");
			System.out.println("Tu nombre es "+nombre);
			String[] opciones= {"Opcion 1","Opcion 2","Opcion 3"};
			String resultado=(String)JOptionPane.showInputDialog(this,"Introduce tu nombre2","titulo",
					JOptionPane.QUESTION_MESSAGE,null,opciones,opciones[0]);
			System.out.println("Opcion Seleccionada "+resultado);
		});
		
		panelCentral.add(boton1);
		//panelCentral.add(boton2);
		panelCentral.add(botonCrearVentana);
		panelCentral.add(boton3);
		setVisible(true);
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

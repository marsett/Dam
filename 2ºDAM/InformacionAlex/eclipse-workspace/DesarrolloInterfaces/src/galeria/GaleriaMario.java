package galeria;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;

public class GaleriaMario implements ActionListener{
	private JButton primero, anterior, siguiente, ultimo;
	private JLabel imagen;
	private ImageIcon icono;
	private CardLayout cartas;
	private JPanel centro;
	private int contador=1;
	public static void main(String[] args) {
		new GaleriaMario();
	}
	public GaleriaMario() {
		JFrame frame=new JFrame();
		frame.setTitle("Galeria de Padreadas");
		frame.setLayout(new BorderLayout());
		
		JPanel superior=new JPanel();
		centro=new JPanel();
		
		primero=new JButton("<<");
		primero.addActionListener(this);
		anterior=new JButton("<");
		anterior.addActionListener(this);
		siguiente=new JButton(">");
		siguiente.addActionListener(this);
		ultimo=new JButton(">>");
		ultimo.addActionListener(this);
		
		superior.add(primero);
		superior.add(anterior);
		superior.add(siguiente);
		superior.add(ultimo);
		
		String rutaUno = "../imagenes/1.jpg";
		String rutaDos = "../imagenes/2.jpg";
		String rutaTres = "../imagenes/3.jpg";
		String rutaCuatro ="../imagenes/4.jpg";
		String rutaCinco ="../imagenes/5.jpg";
		String rutaSeis="../imagenes/6.jpg";
		
		cartas=new CardLayout();
		centro.setLayout(cartas);
		
		centro.add(obtenerPanel(rutaUno,contador) ,"1");
		centro.add(obtenerPanel(rutaDos,contador) ,"2");
		centro.add(obtenerPanel(rutaTres,contador) ,"3");
		centro.add(obtenerPanel(rutaCuatro,contador) ,"4");
		centro.add(obtenerPanel(rutaCinco,contador) ,"5");
		centro.add(obtenerPanel(rutaSeis,contador) ,"6");
		
		frame.add(superior,BorderLayout.SOUTH);
		frame.add(centro,BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700,700);
		frame.setVisible(true);
	}
	private JPanel obtenerPanel(String ruta, int contador) {
		JPanel primero=new JPanel();
		icono=obtenerImagen(ruta,String.valueOf(contador));
		imagen=new JLabel();
		ImageIcon img2=new ImageIcon(icono.getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH));
		imagen.setIcon(img2);
		primero.add(imagen);
		return primero;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==primero) {
			contador=1;
			this.cartas.show(centro, "1");
		}
		if(e.getSource()==siguiente) {
			switch (contador) {
			case 1:
				cartas.show(centro, "2");
				contador++;
				break;
			case 2:
				cartas.show(centro, "3");
				contador++;
				break;
			case 3:
				cartas.show(centro, "4");
				contador++;
				break;
			case 4:
				cartas.show(centro, "5");
				contador++;
				break;
			case 5:
				cartas.show(centro, "6");
				contador++;
				break;
			case 6:
				cartas.show(centro, "1");
				contador = 1;
				break;
			}
		}
		if(e.getSource()==anterior) {
			switch (contador) {
			case 1:
				cartas.show(centro, "6");
				contador = 6;
				break;
			case 2:
				cartas.show(centro, "1");
				contador--;
				break;
			case 3:
				cartas.show(centro, "2");
				contador--;
				break;
			case 4:
				cartas.show(centro, "3");
				contador--;
				break;
			case 5:
				cartas.show(centro, "4");
				contador--;
				break;
			case 6:
				cartas.show(centro, "5");
				contador--;
				break;
			}
		}
		if(e.getSource()==ultimo) {
			contador=6;
			this.cartas.show(centro, "6");
		}
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

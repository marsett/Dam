package componentes;
import java.awt.Color;
import javax.swing.*;

public class UsandoTextArea extends JFrame{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		new UsandoTextArea();
	}
	public UsandoTextArea() {
		// TODO Auto-generated constructor stub
		super("Mi Consola");
		setLayout(null);
		add(obtenerTextArea());
		add(obtenerScroll());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setSize(600,600);
		setVisible(true);
	}
	private JTextArea obtenerTextArea() {
		JTextArea retorno=new JTextArea();
		retorno.setLineWrap(true);
		retorno.setBackground(new Color(0,0,0));
		retorno.setForeground(new Color(255,255,255));
		return retorno;
	}
	private JScrollPane obtenerScroll() {
		JScrollPane scroll=new JScrollPane(obtenerTextArea());
		scroll.setBounds(30,30,300,300);
		return scroll;
	}
}

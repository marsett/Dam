package dialogos;
import java.awt.FlowLayout;

import javax.swing.*;

public class Dialogo extends JDialog{
	private static final long serialVersionUID = 1L;
	private JButton btConectar;
	private JLabel etiquetaUsuario, etiquetaPassword;
	private JTextField cajaUsuario, cajaPassword;
	private JComboBox esquemas, tablas;
	public static void main(String[] args) {
		new Dialogo();
	}
	public Dialogo() {
		// TODO Auto-generated constructor stub
		setLayout(new FlowLayout());
		setBounds(100,100,850,450);
		etiquetaUsuario=new JLabel("Usuario");
		cajaUsuario=new JTextField(20);
		etiquetaPassword=new JLabel("Password");
		cajaPassword=new JTextField(20);
		btConectar=new JButton("Conectar");
		btConectar.setBounds(100, 140, 300, 40);
		esquemas=new JComboBox();
		tablas=new JComboBox();
		add(etiquetaUsuario);
		add(cajaUsuario);
		add(etiquetaPassword);
		add(cajaPassword);
		add(btConectar);
		add(esquemas);
		add(tablas);
		setVisible(true);
	}
}

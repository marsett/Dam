package dialogos;
import java.awt.FlowLayout;

import javax.swing.*;

public class DialogoPersonalizado extends JDialog {
	private static final long serialVersionUID = 1L;
	public DialogoPersonalizado() {
		// TODO Auto-generated constructor stub
		setTitle("Titulo del dialogo");
		setAlwaysOnTop(true);//hace que el dialogo salga por delante de todo
		setBounds(100, 100, 250, 230);
		setResizable(false);//con false evita que el usuario cambie el tamano de la pantalla
		setModal(true);//bloquea la interaccion con otra ventana
		setLayout(new FlowLayout());
		add(new JButton("Boton 1"));
		add(new JButton("Boton 2"));
		add(new JButton("Boton 3"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//oculta ventana
		setVisible(true);
	}
}

package layouts;
import java.awt.*;
import javax.swing.*;

public class UsandoGridBagLayout extends JFrame{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		new UsandoGridBagLayout();
	}
	public UsandoGridBagLayout() {
		// TODO Auto-generated constructor stub
		JPanel panel=new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createTitledBorder("FORMULARIO"));
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.insets=new Insets(2, 2, 2, 2);
		setSize(400,300);
		setLocationRelativeTo(null);
		addComponente(new JLabel("Nombre:"), new JTextField(12), panel, gbc);
		addComponente(new JLabel("Apellido 1:"), new JTextField(22), panel, gbc);
		addComponente(new JLabel("Apellido 2:"), new JTextField(26), panel, gbc);
		addComponente(new JLabel("Direccion:"), new JTextField(7), panel, gbc);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().add(panel);
		setVisible(true);
	}
	private void addComponente(JLabel etiqueta, JTextField caja, JPanel p, GridBagConstraints gbc) {
		gbc.anchor=GridBagConstraints.EAST;
		gbc.gridwidth=GridBagConstraints.RELATIVE;
		p.add(etiqueta,gbc);
		gbc.anchor=GridBagConstraints.WEST;
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		p.add(caja,gbc);
		
	}
}

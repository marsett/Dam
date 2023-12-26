package layouts;
import java.awt.*;
import javax.swing.*;

public class EjemploGridBagLayout extends JFrame{
	private static final long serialVersionUID = 1L;
	GridBagLayout gridBagLayout;
	public static void main(String[] args) {
		new EjemploGridBagLayout();
	}
	public EjemploGridBagLayout() {
		// TODO Auto-generated constructor stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gridBagLayout=new GridBagLayout();
		setLayout(gridBagLayout);

		setBackground(Color.LIGHT_GRAY);
		disposicion1();
		setSize(600,600);
		setVisible(true);
	}
	private void disposicion1() {
		addComponente(new JLabel("Nombre: "),0,0,1,1);
		addComponente(new JTextField(20)	,1,0,2,1);
		addComponente(new JTextArea(5,20)	,0,1,2,2);
		addComponente(new JCheckBox("Yes?")	,2,1,1,1);
		addComponente(new JTextArea(5,20)	,2,2,1,1);
	}
	private void addComponente(Component comp, int gridX, int gridY, int gridAncho, int gridAlto) {
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.gridx=gridX;
		gbc.gridy=gridY;
		gbc.gridwidth=gridAncho;
		gbc.gridheight=gridAlto;
		this.gridBagLayout.setConstraints(comp, gbc);
		add(comp);
	}
}

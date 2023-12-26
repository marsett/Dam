package layouts;
import java.awt.*;
import javax.swing.*;

public class UsoLayoutPersonalizado extends JFrame{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		new UsoLayoutPersonalizado();
	}
	public UsoLayoutPersonalizado() {
		// TODO Auto-generated constructor stub
		Container panelCentral=this.getContentPane();
		int horizontal=20;
		int vertical=20;
		LayoutPersonalizado layout=new LayoutPersonalizado(horizontal,vertical);
		panelCentral.setLayout(layout);
		panelCentral.add(new JLabel("Nombre"));
		panelCentral.add(new JTextField(10));
		panelCentral.add(new JLabel("Apellido1:"));
		panelCentral.add(new JTextField(10));
		panelCentral.add(new JLabel("Apellido2:"));
		panelCentral.add(new JTextField(10));
		panelCentral.add(new JLabel("Telefono:"));
		panelCentral.add(new JTextField(10));
		this.setSize(500,500);
		this.setVisible(true);
	}
}

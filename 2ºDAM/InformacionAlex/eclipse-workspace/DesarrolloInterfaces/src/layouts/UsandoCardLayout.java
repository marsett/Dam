package layouts;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UsandoCardLayout implements ActionListener{
	JFrame frame;
	CardLayout cardLayout;
	JPanel superior, inferior, panel1, panel2;
	JTextField campo;
	JButton btn1, btn2, btn3;
	JComboBox<String>combo;
	String[] cadena= {"Panel con botones","Panel con caja texto"};
	public static void main(String[] args) {
		new UsandoCardLayout();
	}
	private UsandoCardLayout() {
		// TODO Auto-generated constructor stub
		superior=new JPanel();
		superior.setLayout(new FlowLayout());
		combo=new JComboBox<String>(cadena);
		superior.add(combo);
		panel1=new JPanel(new FlowLayout());
		btn1=new JButton("Boton 1");
		panel1.add(btn1);
		btn2=new JButton("Boton 2");
		panel1.add(btn2);
		btn3=new JButton("Boton 3");
		panel1.add(btn3);
		panel1.setBackground(Color.green);
		panel2=new JPanel(new FlowLayout());
		campo=new JTextField("Una caja",20);
		panel2.add(campo);
		inferior=new JPanel();
		cardLayout=new CardLayout();
		inferior.setLayout(cardLayout);
		inferior.add(panel1,"Panel 1");
		inferior.add(panel2,"Panel 2");
		frame=new JFrame();
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.add(superior);
		frame.add(inferior);
		frame.setSize(300,300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		combo.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());
		if(e.getSource()==combo) {
			switch(combo.getSelectedIndex()) {
			case 0:
				this.cardLayout.show(inferior, "Panel 1");
				break;
			case 1:
				this.cardLayout.show(inferior, "Panel 2");
				break;
			}
		}
	}
}

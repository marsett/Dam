package layouts;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.*;

public class UsoBoxLayoutAlineaciones {
	public static void main(String[] args) {
		new UsoBoxLayoutAlineaciones();
	}
	public UsoBoxLayoutAlineaciones() {
		// TODO Auto-generated constructor stub
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton jb1=new JButton("Boton 1");
		JButton jb2=new JButton("Boton 2 -------");
		JButton jb3=new JButton("Boton 3");
		JButton jb4=new JButton("Boton 4 -------");
		JButton jb5=new JButton("Boton 5");
		JButton jb6=new JButton("Boton 6 -------");
		JPanel panel1=new JPanel();
		JPanel panel2=new JPanel();
		JPanel panel3=new JPanel();
		Border bordeconTitulo=BorderFactory.createTitledBorder("Izquierda");
		panel1.setBorder(bordeconTitulo);
		panel2.setBorder(BorderFactory.createTitledBorder("Centro"));
		panel3.setBorder(BorderFactory.createTitledBorder("Derecha"));
		BoxLayout layout1=new BoxLayout(panel1, BoxLayout.Y_AXIS);
		BoxLayout layout2=new BoxLayout(panel2, BoxLayout.Y_AXIS);
		BoxLayout layout3=new BoxLayout(panel3, BoxLayout.Y_AXIS);
		panel1.setLayout(layout1);
		panel2.setLayout(layout2);
		panel3.setLayout(layout3);
		jb1.setAlignmentX(Component.LEFT_ALIGNMENT);
		jb2.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel1.add(jb1);
		panel1.add(jb2);
		jb3.setAlignmentX(Component.CENTER_ALIGNMENT);
		jb4.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel2.add(jb3);
		panel2.add(jb4);
		jb5.setAlignmentX(Component.RIGHT_ALIGNMENT);
		jb6.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel3.add(jb5);
		panel3.add(jb6);
		frame.setLayout(new FlowLayout());
		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
		frame.pack();
		frame.setVisible(true);
	}
}

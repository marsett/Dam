package layouts;
import java.awt.BorderLayout;

import javax.swing.*;

public class UsoBoxLayoutBasico extends JFrame{
	public static void main(String[] args) {
		new UsoBoxLayoutBasico();
	}
	public UsoBoxLayoutBasico() {
		// TODO Auto-generated constructor stub
		JPanel panel=new JPanel();
		JButton btn1=new JButton("1");
		JButton btn2=new JButton("2");
		JButton btn3=new JButton("3");
		
		BoxLayout caja=new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(caja);
		panel.add(btn1);
		//panel.add(Box.createVerticalStrut(20));
		panel.add(btn2);
		panel.add(Box.createVerticalStrut(40));
		panel.add(btn3);
		add(panel,BorderLayout.WEST);
		
		JPanel panel2=new JPanel();
		JButton btn21=new JButton("2.1");
		JButton btn22=new JButton("2.2");
		JButton btn23=new JButton("2.3");
		BoxLayout caja2=new BoxLayout(panel2, BoxLayout.X_AXIS);
		panel2.setLayout(caja2);
		panel2.add(btn21);
		//panel2.add(Box.createHorizontalStrut(40));//componente invisible
		//panel2.add(Box.createGlue());
		panel2.add(btn22);
		panel2.add(Box.createHorizontalStrut(20));
		panel2.add(btn23);
		add(panel2,BorderLayout.EAST);
		
		setSize(300,400);
		setVisible(true);
	}
}

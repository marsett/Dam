package awt;

import java.awt.*;

public class ClasePanel extends Frame{
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		//el frame implementa el borderlayout y el panel el flowlayout
		//array es un objeto referenciado
		new ClasePanel();
	}
	
	public Panel getPanelNorte() {
		Button b1=new Button("Archivo");
		Button b2=new Button("Editar");
		Button b3=new Button("Source");
		
		Panel panel1=new Panel();
		
		FlowLayout fl=new FlowLayout();
		fl.setAlignment(FlowLayout.LEFT);
		
		panel1.add(b1);
		panel1.add(b2);
		panel1.add(b3);
		
		panel1.setLayout(fl);
		return panel1;
	}
	
	public Panel getPanelOeste() {
		Button bb1=new Button("A");
		Button bb2=new Button("B");
		Button bb3=new Button("C");
		Button bb4=new Button("D");
		Button bb5=new Button("E");
		Button bb6=new Button("F");
		Button bb7=new Button("G");
		
		Panel panel2=new Panel();
		
		GridLayout gl2=new GridLayout(7,1);
		
		panel2.add(bb1);
		panel2.add(bb2);
		panel2.add(bb3);
		panel2.add(bb4);
		panel2.add(bb5);
		panel2.add(bb6);
		panel2.add(bb7);
		
		panel2.setLayout(gl2);
		return panel2;
	}
	
	public Panel getPanelCentro() {
		Button bbb1=new Button("1");
		Button bbb2=new Button("2");
		Button bbb3=new Button("3");
		Button bbb4=new Button("4");
		Button bbb5=new Button("5");
		Button bbb6=new Button("6");
		
		Panel panel3=new Panel();
	
		GridLayout gl3=new GridLayout(2,3);
		
		panel3.add(bbb1);
		panel3.add(bbb2);
		panel3.add(bbb3);
		panel3.add(bbb4);
		panel3.add(bbb5);
		panel3.add(bbb6);
		
		panel3.setLayout(gl3);
		return panel3;
	}
	
	public ClasePanel() {
		//PANEL NORTE
		add(BorderLayout.NORTH, getPanelNorte());
		
		//PANEL OESTE
		add(BorderLayout.WEST, getPanelOeste());
		
		//PANEL CENTER
		add(BorderLayout.CENTER, getPanelCentro());
		
		//FRAME
		setSize(500,400);
		setVisible(true);
	}

}

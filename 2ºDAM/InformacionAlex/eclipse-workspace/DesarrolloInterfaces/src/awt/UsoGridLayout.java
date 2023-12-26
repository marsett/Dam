package awt;

import java.awt.*;

public class UsoGridLayout extends Frame{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		new UsoGridLayout();
	}
	public UsoGridLayout() {
		Button b1=new Button("Uno");
		Button b2=new Button("Dos");
		Button b3=new Button("Tres");
		Button b4=new Button("Cuatro");
		Button b5=new Button("Cinco");
		Button b6=new Button("Seis");
		
		GridLayout layout=new GridLayout(2,3);
		layout.setHgap(5);
		layout.setVgap(5);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		setLayout(layout);
		
		setSize(600,600);
		setVisible(true);
	}
}


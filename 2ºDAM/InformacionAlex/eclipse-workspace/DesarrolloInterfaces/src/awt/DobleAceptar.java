package awt;
import java.awt.*;
import java.awt.event.*;

public class DobleAceptar extends Frame implements ActionListener{
	private static final long serialVersionUID = 1L;
	Button boton1, boton2;
	public static void main(String[] args) {
		new DobleAceptar();
	}
	public DobleAceptar() {
		super("titulo");
		setLayout(new FlowLayout());
		boton1=new Button("Aceptar");
		boton1.addActionListener(this);
		boton2=new Button("Aceptar");
		boton2.addActionListener(this);
		
		add(boton1);
		add(boton2);
		
		setSize(500,200);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Button bt=(Button)(e.getSource());
		if(bt==boton1) {
			System.out.println("Aceptar Izquierda");
		}
		else {
			System.out.println("Aceptar Derecha");
		}
	}
}

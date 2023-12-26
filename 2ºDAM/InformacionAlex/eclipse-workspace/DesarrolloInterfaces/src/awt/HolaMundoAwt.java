package awt;

import java.awt.*;
import java.awt.event.*;

public class HolaMundoAwt extends Frame implements ActionListener{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		new HolaMundoAwt();
	}
	public HolaMundoAwt() {
		super("titulo");
		setLayout(new FlowLayout());
		Button boton1=new Button("Aceptar");
		boton1.addActionListener(this);
		Button boton2=new Button("Cancelar");
		boton2.addActionListener(this);
		Button boton3=new Button("Rechazar");
		boton3.addActionListener(this);
		add(boton1);
		add(boton2);
		add(boton3);
		setSize(500,200);
		setVisible(true);
		
		/*int asciiValor=49;
		String str=new Character((char)asciiValor).toString();
		System.out.println("str"+str);*/
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Has hecho click "+e.getActionCommand());//obtener etiqueta del elemento que ha hecho click el usuario
		
	}
}

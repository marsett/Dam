package clasesinternas;
import java.awt.*;
import java.awt.event.*;

public class InterfazInternaManejador extends Frame {
	private static final long serialVersionUID = 1L;
	public Button b1, b2;
	public TextField tf;
	public static void main(String[] args) {
		new InterfazInternaManejador();
	}
	public InterfazInternaManejador() {
		super("Usando manejador externo");
		setLayout(new FlowLayout());
		b1=new Button("Boton 1");
		b1.addActionListener(new ManejadorExt());
		add(b1);
		b2=new Button("Boton 2");
		b2.addActionListener(new ManejadorExt());
		add(b2);
		tf=new TextField("HOLA");
		tf.addActionListener(new ManejadorExt());
		System.out.println(tf.getText());
		
		setSize(800,240);
		pack();
		setVisible(true);
	}
	class ManejadorExt implements ActionListener{
		//InterfazInternaManejador interfaz;
		public ManejadorExt(/*InterfazInternaManejador interfaz*/) {
			//this.interfaz=interfaz;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Has hecho click");
			if(e.getSource()==/*interfaz.*/b1) {
				System.out.println("...sobre el boton 1");
			}
			else if(e.getSource()==/*interfaz.*/b2){
				System.out.println("...sobre el boton 2");
			}
		}
	}
}

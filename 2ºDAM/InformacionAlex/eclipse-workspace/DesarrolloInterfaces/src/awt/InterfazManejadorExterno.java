package awt;
import java.awt.*;



public class InterfazManejadorExterno extends Frame{	//interfaz con manejador externo
	private static final long serialVersionUID = 1L;
	public Button b1, b2;
	public TextField tf;
	public static void main(String[] args) {
		new InterfazManejadorExterno();
	}
	public InterfazManejadorExterno() {
		super("Usando manejador externo");
		setLayout(new FlowLayout());
		b1=new Button("Boton 1");
		b1.addActionListener(new ManejadorExterno(this));
		add(b1);
		b2=new Button("Boton 2");
		b2.addActionListener(new ManejadorExterno(this));
		add(b2);
		tf=new TextField("HOLA");
		tf.addActionListener(new ManejadorExterno(this));
		System.out.println(tf.getText());
		
		setSize(800,240);
		pack();	//el contenedor se adapta a los espacios que dejan los elementos
		setVisible(true);
	}	
}

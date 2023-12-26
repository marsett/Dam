package awt;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazConClaseAnonimaAbstracta extends Frame{	//interfaz con manejador externo
	private static final long serialVersionUID = 1L;
	public Button b1, b2;
	public TextField tf;
	public static void main(String[] args) {
		new InterfazConClaseAnonimaAbstracta();
	}
	public InterfazConClaseAnonimaAbstracta() {
		super("Usando manejador externo");
		setLayout(new FlowLayout());
		b1=new Button("Boton 1");
		/*b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Click sobre el Boton 1");
			}
		});*/
		b1.addActionListener(e -> {
				System.out.println("Click sobre "+e.getActionCommand());
			}
		);
		//inferencia de datos, deduccion de lo que tiene que hacer
		add(b1);
		b2=new Button("Boton 2");
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Click sobre el Boton 2");
			}
		});
		add(b2);
		/*tf=new TextField("HOLA");
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Click sobre HOLA");
			}
		});
		System.out.println(tf.getText());*/
		setSize(400,300);
		//pack();	//el contenedor se adapta a los espacios que dejan los elementos
		setVisible(true);
	}	
}

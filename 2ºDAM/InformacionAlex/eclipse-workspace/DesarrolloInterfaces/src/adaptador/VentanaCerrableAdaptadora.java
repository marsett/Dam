package adaptador;
import java.awt.*;
import java.awt.event.*;

public class VentanaCerrableAdaptadora extends Frame{
	private static final long serialVersionUID = 1L;
	private Button bt;
	public static void main(String[] args) {
		new VentanaCerrableAdaptadora();
	}
	public VentanaCerrableAdaptadora() {
		super("Ventana Cerrable");
		/*ManejadorVentana manejador=new ManejadorVentana();
		this.addWindowListener(manejador);*/
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				System.exit(0);
			}
		});
		bt=new Button("Boton");
		setLayout(new FlowLayout());
		add(bt);
		setSize(550,200);
		setVisible(true);
	}
	class ManejadorVentana extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			super.windowClosing(e);
			System.exit(0);
		}
	}
}

package adaptador;
import java.awt.*;
import java.awt.event.*;

public class VentanaCerrable extends Frame implements WindowListener{
	private static final long serialVersionUID = 1L;
	private Button bt;
	public static void main(String[] args) {
		new VentanaCerrable();
	}
	public VentanaCerrable() {
		super("Ventana Cerrable");
		bt=new Button("Boton");
		setLayout(new FlowLayout());
		addWindowListener(this);
		add(bt);
		setSize(550,200);
		setVisible(true);
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowOpened()");
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowClosing()");
		int numero=0;
		System.exit(numero);
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowsClosed()");
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowsIconified()");
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowDeiconified()");
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowsActivated()");
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowDeactivated()");
	}
}

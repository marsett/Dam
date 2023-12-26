package eventos;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class MiEventoTecladoRaton extends JFrame implements KeyListener, MouseListener, MouseMotionListener{
	private static final long serialVersionUID = 1L;
	private JLabel xPos, yPos;
	private JButton boton;
	public static void main(String[] args) {
		new MiEventoTecladoRaton();
	}
	public MiEventoTecladoRaton() {
		// TODO Auto-generated constructor stub
		super("Evento de Raton y Teclado");
		setLayout(new FlowLayout());
		xPos=new JLabel("z=0			");
		yPos=new JLabel("y=0			");
		boton=new JButton("Boton con Eventos");
		
		add(xPos);
		add(yPos);
		addMouseMotionListener(this);
		addKeyListener(this);
		boton.addMouseListener(this);
		add(boton);
		setSize(600,450);
		setVisible(true);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		xPos.setText("ARRASTRAR X="+e.getX());
		yPos.setText("ARRASTRAR Y="+e.getY());
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		xPos.setText("MOVIDO X="+e.getX());
		yPos.setText("MOVIDO Y="+e.getY());
	}
	@Override
	public void keyTyped(KeyEvent e) {//engloba los otros dos metodos; este metodo pulsas y sueltas
		// TODO Auto-generated method stub
		System.out.println("KeyTyped--> "+e.getKeyChar());
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int codigoTeclaPulsada=e.getKeyCode();
		System.out.println("KeyPressed--> "+codigoTeclaPulsada);
		switch(codigoTeclaPulsada) {
		case KeyEvent.VK_CAPS_LOCK:
			System.out.println("Has pulsado caps lock");
			break;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("KeyReleased--> "+e.getKeyChar());
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("MouseClicked "+e.getClickCount());
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("MousePressed "+e.getClickCount());
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("MouseReleased "+e.getClickCount());
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("MouseEntered "+e.getClickCount());
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("MouseExited "+e.getClickCount());
	}
}

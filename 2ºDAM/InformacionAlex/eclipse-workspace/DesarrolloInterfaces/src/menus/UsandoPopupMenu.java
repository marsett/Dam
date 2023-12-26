package menus;
import javax.swing.*;

public class UsandoPopupMenu extends JFrame{
	private static final long serialVersionUID = 1L;
	JPopupMenu pm=new JPopupMenu();
	JMenuItem mi1=new JMenuItem("Cortar",'x');
	JMenuItem mi2=new JMenuItem("Copiar",'c');
	JMenuItem mi3=new JMenuItem("Pegar",'v');
	JTextArea ta=new JTextArea();
	public static void main(String[] args) {
		new UsandoPopupMenu();
	}
	public UsandoPopupMenu() {
		// TODO Auto-generated constructor stub
		pm.add(mi1);
		pm.add(mi2);
		pm.add(mi3);
		add(ta);
		ta.setComponentPopupMenu(pm);
		setSize(800,600);
		setVisible(true);
	}
}

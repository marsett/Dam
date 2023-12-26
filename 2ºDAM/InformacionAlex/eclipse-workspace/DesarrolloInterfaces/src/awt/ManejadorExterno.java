package awt;
import java.awt.event.*;

public class ManejadorExterno implements ActionListener{
	InterfazManejadorExterno interfaz;
	public ManejadorExterno(InterfazManejadorExterno interfaz) {
		this.interfaz=interfaz;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Has hecho click");
		if(e.getSource()==interfaz.b1) {
			System.out.println("...sobre el boton 1");
		}
		else if(e.getSource()==interfaz.b2){
			System.out.println("...sobre el boton 2");
		}
	}
}

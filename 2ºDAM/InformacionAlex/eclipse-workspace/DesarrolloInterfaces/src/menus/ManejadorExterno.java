package menus;
import java.awt.event.*;

public class ManejadorExterno implements ActionListener{
	VentanaMenu vm;
	public ManejadorExterno(VentanaMenu vm) {
		this.vm=vm;
	}
	public ManejadorExterno() {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String opcionPulsada=e.getActionCommand();
		System.out.println("Opcion Menu Pulsada: "+opcionPulsada);
		switch (opcionPulsada.toLowerCase()) {
		case "archivo": {
			
		}
		break;
		case "ventana": {
			
		}
		break;
		case "salida": {
			System.exit(0);
		}
		break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + opcionPulsada);
		}
	}

}

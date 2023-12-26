package layouts;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class UsoBoxLayoutGlue extends JFrame{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		new UsoBoxLayoutGlue();
	}
	public UsoBoxLayoutGlue() {
		// TODO Auto-generated constructor stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(crearComponente("Componente 1"));
		panel.add(crearComponente("Componente 2"));
		panel.add(Box.createGlue());
		panel.add(crearComponente("Componente 3"));
		panel.add(crearComponente("Componente 4"));
		panel.add(crearComponente("Componente 5"));
		panel.add(Box.createVerticalStrut(15));
		panel.add(crearComponente("Componente 6"));
		add(panel);
		setSize(600,600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	private JComponent crearComponente(String str) {
		Border borde=BorderFactory.createTitledBorder("Borde");
		JLabel etiqueta=new JLabel("------"+str+"------");
		etiqueta.setBorder(borde);
		etiqueta.setHorizontalAlignment(JLabel.CENTER);
		etiqueta.setAlignmentX(Component.CENTER_ALIGNMENT);
		return etiqueta;
	}
}

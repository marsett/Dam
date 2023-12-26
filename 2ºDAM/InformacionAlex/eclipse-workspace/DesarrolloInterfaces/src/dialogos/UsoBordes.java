package dialogos;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class UsoBordes extends JFrame{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		new UsoBordes();
	}
	public UsoBordes() {
		// TODO Auto-generated constructor stub
		setSize(500,300);
		setLayout(new GridLayout(2,4));
		Border borde1=new TitledBorder("Un titulo");
		add(obtenerPanelConBorde(borde1));
		add(obtenerPanelConBorde(new EtchedBorder()));
		add(obtenerPanelConBorde(new LineBorder(Color.GREEN,15)));
		Border matteBorde=new MatteBorder(5,5,30,15,Color.MAGENTA);
		add(obtenerPanelConBorde(matteBorde));
		add(obtenerPanelConBorde(new BevelBorder(BevelBorder.RAISED)));
		add(obtenerPanelConBorde(new SoftBevelBorder(SoftBevelBorder.LOWERED)));
		add(obtenerPanelConBorde(new CompoundBorder(new EtchedBorder(),new LineBorder(Color.RED))));
		BasicStroke basic=new BasicStroke();
		add(obtenerPanelConBorde(new StrokeBorder(basic)));
		setVisible(true);
	}
	public JPanel obtenerPanelConBorde(Border tipo) {
		JPanel retorno=new JPanel();
		retorno.setLayout(new BorderLayout());
		String nm=tipo.getClass().getName();
		System.out.println(nm);
		nm=nm.substring(nm.lastIndexOf('.')+1);
		retorno.add(new JLabel(nm,JLabel.CENTER),BorderLayout.CENTER);
		retorno.setBorder(tipo);
		//retorno.setBackground(Color.cyan);
		return retorno;
	}
}

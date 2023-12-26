package componentes;
import java.awt.*;
import javax.swing.*;

public class UsandoSplitPane extends JFrame{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		new UsandoSplitPane();
	}
	public UsandoSplitPane() {
		JPanel panel1=new JPanel(new FlowLayout());
		panel1.add(new JButton("Ok"));
		panel1.add(new JButton("Cancelar"));
		JPanel panel2=new JPanel(new FlowLayout());
		panel2.add(new JLabel("Nombre:"));
		panel2.add(new JTextField(20));
		JSplitPane splitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panel1,panel2);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(50);
		this.getContentPane().add(splitPane,BorderLayout.CENTER);
		setSize(600,200);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}

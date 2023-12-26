package componentes;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

public class UsandoTextAreaConDocument extends JFrame{
	private static final long serialVersionUID = 1L;
	JTextArea textArea1=new JTextArea();
	JTextArea textArea2;
	JTextArea textArea3;
	public static void main(String[] args) {
		new UsandoTextAreaConDocument();
	}
	public UsandoTextAreaConDocument() {
		// TODO Auto-generated constructor stub
		super("Usando Document");
		Document documento=textArea1.getDocument();
		textArea2=new JTextArea();
		textArea2.setDocument(documento);
		textArea3=new JTextArea(documento);
		//textArea3.setDocument(documento);
		setLayout(new GridLayout(3,1));
		add(new JScrollPane(textArea1));
		add(new JScrollPane(textArea2));
		add(new JScrollPane(textArea3));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,300);
		setVisible(true);
	}
}

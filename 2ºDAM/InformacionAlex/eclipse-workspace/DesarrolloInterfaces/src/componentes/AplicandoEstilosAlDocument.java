package componentes;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;

public class AplicandoEstilosAlDocument extends JFrame{
	JTextPane textPane;
	public static void main(String[] args) {
		new AplicandoEstilosAlDocument();
	}
	public AplicandoEstilosAlDocument() {
		// TODO Auto-generated constructor stub
		setSize(400,200);
		textPane=new JTextPane();
		textPane.setFont(new Font("Times New Roman",Font.PLAIN, 24));
		SimpleAttributeSet rojo=new SimpleAttributeSet();
		StyleConstants.setForeground(rojo, Color.RED);
		SimpleAttributeSet azul=new SimpleAttributeSet();
		StyleConstants.setForeground(azul, Color.BLUE);
		StyleConstants.setBold(azul, true);
		SimpleAttributeSet italica=new SimpleAttributeSet();
		StyleConstants.setItalic(italica, true);
		StyleConstants.setForeground(italica, Color.BLACK);
		StyleConstants.setBackground(italica, Color.WHITE);
		SimpleAttributeSet tamano=new SimpleAttributeSet();
		StyleConstants.setFontSize(tamano, 40);
		StyleConstants.setBackground(tamano, Color.BLACK);
		StyleConstants.setForeground(tamano, Color.WHITE);
		anadir("Hola, soy ",null);
		anadir("Mario\n",rojo);
		anadir("Inglaterra da asco",italica);
		add(new JScrollPane(textPane));
		setVisible(true);
	}
	private void anadir(String cadena,AttributeSet estilo) {
		Document document=textPane.getDocument();
		document.addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				System.out.println("removeUpdate()");
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				System.out.println("insertUpdate()");
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				System.out.println("changedUpdate()");
			}
		});
		try {
			document.insertString(document.getLength(),cadena,estilo);
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

package componentes;
import javax.swing.*;
import javax.swing.text.*;

public class UsandoDocumentFilter {
	public static void main(String[] args) {
		new UsandoDocumentFilter();
	}
	public UsandoDocumentFilter() {
		// TODO Auto-generated constructor stub
		//el filtro actua como si fuera un evento
		//esto actua sobre el modelo de datos del componente que estemos usando
		JTextField caja=new JTextField();
		DocumentFilter filtroDocumento=new DocumentFilter() {
			@Override
			public void replace(FilterBypass fb, int offset, int length, String texto, AttributeSet attrs)
					throws BadLocationException {
				// TODO Auto-generated method stub
				//System.out.println("Reemplazando: "+texto+" offset "+offset+" length: "+length);
				//fb.replace(offset,length,texto,attrs);
				switch(texto) {
				case "a":case "e":case "i":case "o":case "u":
					try {
						fb.replace(offset, length, texto, attrs);
					}catch(BadLocationException ex) {
						ex.printStackTrace();
					}
						System.out.println("Insertstring offset: "+offset);
						break;
					default:
						System.out.println("ignoro "+texto);
				}
			}
			@Override
			public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
				// TODO Auto-generated method stub
				System.out.println("Remove: offset "+offset+" length: "+length);
				//super.remove(fb, offset, length);
				fb.remove(offset, length);
			}
			@Override
			public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
					throws BadLocationException {
				// TODO Auto-generated method stub
				
				System.out.println("Insertando: offset "+offset);
				super.insertString(fb, offset, string, attr);
			}
		};
		AbstractDocument documento=(AbstractDocument)caja.getDocument();
		documento.setDocumentFilter(filtroDocumento);
		JFrame frame=new JFrame("Usando document filter");
		frame.add(caja);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setVisible(true);
	}
}

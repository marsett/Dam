package wordapp;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;

public class AppWord2DAM extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel panelNorte, panelCentral;
	private JLabel nombreArchivo;
	private JMenu menu;
	private JMenuItem cargar,guardar,salir;
	private JMenuBar barra;
	private JTextField cajaNombreArchivo;
	private JFileChooser fileDialog;
	private JTextArea textoArea;
	private JScrollPane scroll;
	public static void main(String[] args) {
		new AppWord2DAM();
	}
	public AppWord2DAM() {
		// TODO Auto-generated constructor stub
		super("Aplicacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		panelNorte=new JPanel();
		panelCentral=new JPanel();
		add(panelNorte,BorderLayout.NORTH);
		add(panelCentral,BorderLayout.CENTER);
		panelCentral.setLayout(null);
		fileDialog=new JFileChooser();
		menu=new JMenu("Fichero");
		cargar=new JMenuItem("Cargar");
		KeyStroke atajoCargar=KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK);
		cargar.setAccelerator(atajoCargar);
		cargar.addActionListener(e->{
			fileDialog.setBounds(400,400,400,400);
			fileDialog.showOpenDialog(this);
			File ficheroSeleccionado=fileDialog.getSelectedFile();
			System.out.println("La ruta del fichero cargado es "+ficheroSeleccionado);
			System.out.println("El nombre del fichero cargado es "+ficheroSeleccionado.getName());
			cajaNombreArchivo.setText(ficheroSeleccionado.getName());
			try {
				BufferedReader br=new BufferedReader(new FileReader(ficheroSeleccionado));
				/*String linea = br.readLine();
				while (linea!=null){
				   textoArea.append(linea);
				   linea=br.readLine();
				}*/
				StringBuilder sb=new StringBuilder();
				/*char[] chars=new char[1024];
				while(true) {
					int n=br.read(chars);
					if(n<0) 
						break;
					sb.append(chars,0,n);
					textoArea.append(sb.toString());
				}*/
				int byteRead;
				while((byteRead=br.read())!=-1) {
					sb.append((char)byteRead);
				}
				textoArea.append(sb.toString());
				br.close();
			}catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		guardar=new JMenuItem("Guardar");
		KeyStroke atajoGuardar=KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK);
		guardar.setAccelerator(atajoGuardar);
		guardar.addActionListener(e->{
			fileDialog.setDialogTitle("Elige donde guardar");
			fileDialog.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			String contenidoArea=textoArea.getText();
			String nombreArchivo=cajaNombreArchivo.getText();
			File ficheroSeleccionado=new File(nombreArchivo);
			fileDialog.setSelectedFile(ficheroSeleccionado);
			fileDialog.showSaveDialog(this);
			try {
				BufferedWriter bw=new BufferedWriter(new FileWriter(fileDialog.getSelectedFile()));
				bw.write(contenidoArea);
				bw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "El fichero ha sido almacenado","Informacion",JOptionPane.INFORMATION_MESSAGE);
		});
		salir=new JMenuItem("Exit");
		KeyStroke atajoExit=KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK);
		salir.setAccelerator(atajoExit);
		salir.addActionListener(e->{
			System.out.println("Cerrando el programa...");
			System.exit(0);
		});
		nombreArchivo=new JLabel("Nombre Archivo:");
		menu.add(cargar);
		menu.add(guardar);
		menu.add(salir);
		FlowLayout fl=new FlowLayout();
		fl.setAlignment(FlowLayout.LEFT);
		barra=new JMenuBar();
		barra.setLayout(fl);
		barra.add(menu);
		this.setJMenuBar(barra);
		panelNorte.add(nombreArchivo);
		cajaNombreArchivo=new JTextField(31);
		panelNorte.add(cajaNombreArchivo);
		textoArea=new JTextArea();
		textoArea.setLineWrap(true);
		//textoArea.setBounds(60,100,300,200);
		textoArea.setEditable(true);
		textoArea.setBorder(new CompoundBorder(new EtchedBorder(),new LineBorder(Color.BLACK)));
		//panelCentral.add(textoArea);
		scroll=new JScrollPane(textoArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(5,30,430,430);
		panelCentral.add(scroll);
		setSize(470,600);
		setVisible(true);
	}
}

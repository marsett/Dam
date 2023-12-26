package gestorbasedatos;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class VentanaUno extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel serverHost, userName, password, defaultSchema, port, conectar;
	private JTextField cuadroServerHost, cuadroUserName, cuadroPassword, cuadroDefaultSchema, cuadroPort;
	private JButton btConectar;
	private Modelo modelo;
	public static void main(String[] args) {
		new VentanaUno();	
	}
	public VentanaUno() {
		super("Ventana 1");
		System.out.println("VentanaUno en ejecucion...");
		serverHost=new JLabel("Server Host");
		userName=new JLabel("Username");
		password=new JLabel("Password");
		defaultSchema=new JLabel("Default Schema");
		port=new JLabel("Port");
		cuadroServerHost=new JTextField("localhost");
		cuadroUserName=new JTextField("root");
		cuadroPassword=new JTextField("mysql");
		cuadroDefaultSchema=new JTextField("bdgestion");
		cuadroPort=new JTextField("3306");
		conectar=new JLabel("Conectar:");
		btConectar=new JButton("Conectar");
		add(serverHost);
		add(cuadroServerHost);
		add(userName);
		add(cuadroUserName);
		add(password);
		add(cuadroPassword);
		add(defaultSchema);
		add(cuadroDefaultSchema);
		add(port);
		add(cuadroPort);
		add(conectar);
		add(btConectar);
		btConectar.addActionListener(e->{
			try {
				modelo=new Modelo(cuadroServerHost.getText(),cuadroUserName.getText(),cuadroPassword.getText(),cuadroDefaultSchema.getText(),cuadroPort.getText());
				System.out.println(modelo);
				@SuppressWarnings("unused")
				VentanaDos vd=new VentanaDos(modelo);
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(6,2));
		setSize(280,280);
		setVisible(true);
	}
	public class Modelo {
		protected String cuadroServerHost=null;
		protected String cuadroUserName=null;
		protected String cuadroPassword=null;
		protected String cuadroDefaultSchema =null;
		protected String cuadroPort=null;
		public Modelo(String cuadroServerHost, String cuadroUserName, String cuadroPassword, String cuadroDefaultSchema, String cuadroPort) {
			this.cuadroServerHost=cuadroServerHost;
			this.cuadroUserName=cuadroUserName;
			this.cuadroPassword=cuadroPassword;
			this.cuadroDefaultSchema=cuadroDefaultSchema;
			this.cuadroPort=cuadroPort;
			System.out.println("Creando "+toString());
		}
		@Override
		public String toString() {
			return "Modelo [cuadroServerHost=" + cuadroServerHost + ", cuadroUserName=" + cuadroUserName
					+ ", cuadroPassword=" + cuadroPassword + ", cuadroDefaultSchema=" + cuadroDefaultSchema
					+ ", cuadroPort=" + cuadroPort + "]";
		}
	}
}

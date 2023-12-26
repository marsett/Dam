package ultima_practica;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class Main_Principal {
	public static void main(String[] args) {
		Ventana ventana = new Ventana();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}
}
class Ventana extends JFrame{
	public Ventana() {
		setBounds(300,300,900,500);
		setTitle("TIENDA DE ENCURTIDOS");
		
		LaminaPrincipal laminaPrincipal = new LaminaPrincipal();
		add(laminaPrincipal);		
	}
}
class LaminaPrincipal extends JPanel implements ActionListener {
	JLabel etiqueta_oculta, codigo, nombre, fecalta, preciokg;
	JButton insertar, modificar, consultar, limpiar;
	JTextField cod, nom, fec, pre;
	private Connection miConexion;
	
	public LaminaPrincipal() {
		
		setLayout(new FlowLayout());
		JPanel laminaMenu = new JPanel();
		laminaMenu.setLayout(new GridLayout(5,3,3,3));
		
		insertar = new JButton("Insertar");
		add(insertar);
		insertar.addActionListener(this);
		
		modificar = new JButton("Modificar");
		add(modificar);
		modificar.addActionListener(this);
		
		consultar = new JButton("Consultar");
		add(consultar);
		consultar.addActionListener(this);
		
		limpiar = new JButton("Campos Limpios");
		add(limpiar);
		limpiar.addActionListener(this);
		
		codigo = new JLabel("CÓDIGO");
		laminaMenu.add(codigo);
		
		cod = new JTextField(15);
		laminaMenu.add(cod);
		
		nombre = new JLabel("NOMBRE");
		laminaMenu.add(nombre);
		
		nom = new JTextField();
		laminaMenu.add(nom);
		
		fecalta = new JLabel("FECALTA");
		laminaMenu.add(fecalta);
		
		fec = new JTextField();
		laminaMenu.add(fec);
		
		preciokg = new JLabel("PRECIOKG");
		laminaMenu.add(preciokg);
		
		pre = new JTextField();
		laminaMenu.add(pre);
		
		etiqueta_oculta = new JLabel();
		laminaMenu.add(etiqueta_oculta);
		
		add(laminaMenu);
		
		//Conexión a la Base de Datos
		//Statement sentencia = null;
		try {
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/TIENDA","root","");
		}catch(SQLException e) {
			System.out.println("Error en main");
		    printSQLException(e);
		}
		
	}
	
	//Esta práctica se ha realizado con trazas; sin embargo, para mejor presentación, se han eliminado del código.

	@Override
	public void actionPerformed(ActionEvent e) {
		Object botonPulsado = e.getSource();
		if(botonPulsado == consultar) {
			try {
			Statement sentencia = null;
			sentencia = miConexion.createStatement();
			if(cod.getText().isEmpty()) {
				etiqueta_oculta.setText("El Código está vacío. Por favor, rellénalo, gracias.");
			}else {
				ResultSet rs = sentencia.executeQuery("SELECT * FROM ENCURTIDOS WHERE CODIGO = '" + cod.getText() + "';");
				while(rs.next()) {
					cod.setText(rs.getString(1));
					nom.setText(rs.getString(2));
					fec.setText(rs.getString(3));
					pre.setText(rs.getString(4));
					etiqueta_oculta.setText("Consulta ejecutada correctamente");
				}
				ResultSet rs2 = sentencia.executeQuery("SELECT * FROM ENCURTIDOS");
				while(rs2.next()) {
					System.out.println(rs2.getString(1) + " " + rs2.getString(2) + " " + rs2.getString(3) + " " + rs2.getString(4));
				}
				rs.close();
				rs2.close();
			}
			sentencia.close();
			}catch(SQLException e2) {
				System.out.println("Error en main");
			    printSQLException(e2);
			}
		}else if(botonPulsado == insertar) {
			try {
			Statement sentencia = null;
			sentencia = miConexion.createStatement();
			if(cod.getText().isEmpty() || nom.getText().isEmpty() || fec.getText().isEmpty() || pre.getText().isEmpty()  ) {
				etiqueta_oculta.setText("Se deben rellenar todos los espacios existentes, gracias.");
			}else {
				ResultSet rs = sentencia.executeQuery("SELECT CODIGO FROM ENCURTIDOS WHERE CODIGO = '" + cod.getText() + "';");
				if(rs.next()) {
					etiqueta_oculta.setText("Ya existe ese Codigo");
				}else {
					int insertar = sentencia.executeUpdate(
							"INSERT INTO ENCURTIDOS (Codigo, Nombre, FecAlta, PrecioKg) VALUES ('" + cod.getText() + "'"
							+ ",'" + nom.getText() + "','" + fec.getText() + "'," + pre.getText() + ");");
				}
				ResultSet rs2 = sentencia.executeQuery("SELECT * FROM ENCURTIDOS");
				while(rs2.next()) {
					System.out.println(rs2.getString(1) + " " + rs2.getString(2) + " " + rs2.getString(3) + " " + rs2.getString(4));
				}
				etiqueta_oculta.setText("Consulta ejecutada correctamente");
			}
			
			}catch(SQLException e2) {
				System.out.println("Error en main");
			    printSQLException(e2);
			}
		}else if(botonPulsado == modificar) {
			try {
			Statement sentencia = null;
			sentencia = miConexion.createStatement();
			if(cod.getText().isEmpty() || nom.getText().isEmpty() || fec.getText().isEmpty() || pre.getText().isEmpty()  ) {
				etiqueta_oculta.setText("Se deben rellenar todos los espacios existentes, gracias.");
			}else {
				ResultSet rs = sentencia.executeQuery("SELECT CODIGO FROM ENCURTIDOS WHERE CODIGO = '" + cod.getText() + "';");
				if(rs.next()) {
					int actualizar = sentencia.executeUpdate("UPDATE ENCURTIDOS SET NOMBRE ='" + nom.getText() + "'" + ", FecAlta='" + fec.getText() + "', PrecioKg=" + pre.getText() + ";");
					etiqueta_oculta.setText("Consulta ejecutada correctamente");
					ResultSet rs2 = sentencia.executeQuery("SELECT * FROM ENCURTIDOS");
					while(rs2.next()) {
						System.out.println(rs2.getString(1) + " " + rs2.getString(2) + " " + rs2.getString(3) + " " + rs2.getString(4));
					}
				}else {
					etiqueta_oculta.setText("No ha sido posible realizar la modificación.");
				}
			}
			}catch(SQLException e2) {
				System.out.println("Error en main");
			    printSQLException(e2);
			}
		}else if (limpiar == e.getSource()) {
			cod.setText("");
			nom.setText("");
			fec.setText("");
			pre.setText("");
			etiqueta_oculta.setText("Los campos se han limpiado.");
		}
	}
	
	private void printSQLException(SQLException ex) {
		System.err.println("SQLState :" + ex.getSQLState());
		System.err.println("Error Code :" + ex.getErrorCode());
		System.err.println("Message :" + ex.getMessage());
		Throwable t = ex.getCause();
		while (t != null) {
			System.err.println("Cause :" + t);
			t = t.getCause();
		}
	 }
}

package practica03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class VentanaEncurtidos extends JFrame {
	public VentanaEncurtidos(int ancho, int alto) {
	  int alturaVentana=(int)(alto*0.6);
	  int anchoVentana=(int)(ancho*0.3);
	  setBounds(100,100,anchoVentana,alturaVentana);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setTitle("Gestión de Encurtidos");
			  
	  Lamina laminaMarco = new Lamina();
	  add(laminaMarco);		
	  setVisible(true);
	}
}

class Lamina extends JPanel implements ActionListener {
	private JTextField codigo;
	private JTextField nombre;
	private JTextField fechaalta;
	private JTextField precio;
	private JButton botonAnadir;
	private JButton botonConsultar;
	private JButton botonModificar;
	private JButton botonLimpiar;
	private JLabel respuesta;
	public Connection miConexion;
	
    
	Lamina () {
		setLayout(new GridLayout(3,1,10,10));
		JPanel lam_top = new JPanel();
		JPanel lam_center = new JPanel();
		JPanel lam_bottom = new JPanel();
		lam_top.setLayout(new FlowLayout(FlowLayout.CENTER, 80,10));
		add(lam_top);
		add(lam_center);
		add(lam_bottom);
		
		JLabel labelcodigo = new JLabel("  CODIGO: ");
		lam_top.add(labelcodigo);		
		codigo = new JTextField();
		lam_top.add(codigo);
		codigo.setColumns(10);

		JLabel labelnombre = new JLabel("  NOMBRE: ");
		lam_top.add(labelnombre);	
		nombre = new JTextField();
		lam_top.add(nombre);
		nombre.setColumns(10);
		JLabel labelfecha = new JLabel("    FECHA:  ");
		lam_top.add(labelfecha);
		fechaalta = new JTextField();
		lam_top.add(fechaalta);
		fechaalta.setColumns(10);
		JLabel labelprecio = new JLabel("PRECIO KG:");
		lam_top.add(labelprecio);
		precio = new JTextField();
		lam_top.add(precio);
		precio.setColumns(10);
	
		botonAnadir = new JButton("AÑADIR");
		lam_center.add(botonAnadir);
		botonAnadir.addActionListener(this);
		
		botonConsultar = new JButton("CONSULTAR");
		lam_center.add(botonConsultar);
		botonConsultar.addActionListener(this);
		
		botonModificar = new JButton("MODIFICAR");
		lam_center.add(botonModificar);
		botonModificar.addActionListener(this);
		
		botonLimpiar = new JButton("LIMPIAR CAMPOS");
		lam_center.add(botonLimpiar);
		botonLimpiar.addActionListener(this);

		respuesta = new JLabel("");
		lam_bottom.add(respuesta);

}

public void actionPerformed (ActionEvent e) {
	//------ Conexión con Base de Datos -------
    try {
	  miConexion = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/TIENDA","root","Solaris");
	} catch (SQLException ex) {			
			    System.out.println("Error en main");
			    printSQLException(ex);
	}
	Object botonPulsado = e.getSource();
	if (botonPulsado == botonConsultar) 
		this.consultar();
	if (botonPulsado == botonAnadir) 
		this.anadir();
	if (botonPulsado == botonModificar) 
		this.modificar();
	if (botonPulsado == botonLimpiar)  {
		codigo.setText("");
		nombre.setText("");
		fechaalta.setText("");
		precio.setText("");
	}
	imprimirTabla();
}

private void imprimirTabla() {
	try {
		Statement miStatement = miConexion.createStatement();
		String consulta = "SELECT * FROM encurtidos ";
		ResultSet resultado = miStatement.executeQuery(consulta);
		System.out.println("Tabla de Encurtidos");
		while (resultado.next()) {
		  System.out.println(resultado.getString(1) + " " +
				  resultado.getString(2) + " " +
				  resultado.getString(3) + " " +
				  resultado.getString(4) + " ");
		}
	} catch (SQLException ex) {			
	    System.out.println("Error en imprimirTabla");
	    printSQLException(ex);
    }
}

private void consultar() {
  if (codigo.getText().length()==0) {
		respuesta.setText("Complete el campo codigo");
  }else {
	try {
		Statement miStatement = miConexion.createStatement();
		String consulta = "SELECT * FROM encurtidos WHERE Codigo='"+codigo.getText()+"'";
		ResultSet resultado = miStatement.executeQuery(consulta);
		if (resultado.next()) {
			nombre.setText(resultado.getString("Nombre"));
			fechaalta.setText(resultado.getString("FecAlta"));
			precio.setText(resultado.getString("PrecioKg"));
			respuesta.setForeground(Color.blue); 	
			respuesta.setText("Consulta ejecutada correctamente");
		}
		else {
			respuesta.setForeground(Color.red); 	
			respuesta.setText("No existe el registro");
		}
	    if (resultado != null) {  // liberar los ResultSet
	    	resultado.close();
	    }
	} catch (SQLException e) {			
	    System.out.println("Error en consultar");
	    printSQLException(e);
    }
  }
}

private void anadir() {
  if(codigo.getText().length()==0 || nombre.getText().length()==0 || fechaalta.getText().length()==0 || precio.getText().length()==0 ) {
	  respuesta.setForeground(Color.red); 	
	  respuesta.setText("Por favor rellene todos los campos");
  }
  else {
	respuesta.setText("");
	try {
	  Statement miStatement = miConexion.createStatement();
	  String sentencia = "SELECT * FROM encurtidos WHERE Codigo='"+codigo.getText()+"'";
	  ResultSet resultado;
	  resultado = miStatement.executeQuery(sentencia);
	  if (resultado.next()) {
		respuesta.setForeground(Color.red); 	
		respuesta.setText("Ya existe el registro");
	  }
   	  else {
		String insertar = "INSERT INTO encurtidos (Codigo,Nombre,FecAlta,PrecioKg) VALUES ('"+codigo.getText()+"','"+nombre.getText()+"','"+fechaalta.getText()+"',"+precio.getText()+")";
		miStatement.executeUpdate(insertar);
		respuesta.setForeground(Color.blue); 	
		respuesta.setText("Añadido correctamente");
	  }
	} catch (SQLException e) {			
	    System.out.println("Error en anadir");
	    printSQLException(e);
    }
  }
}	
  
private void modificar() {
  if(codigo.getText().length()==0 || nombre.getText().length()==0 || fechaalta.getText().length()==0 || precio.getText().length()==0 ) {
	  respuesta.setForeground(Color.red); 		
	  respuesta.setText("Por favor rellene todos los campos");
  }
  else {
	try {
		Statement miStatement = miConexion.createStatement();
		String sentencia1 = "SELECT * FROM encurtidos WHERE Codigo='"+codigo.getText()+"'";
		ResultSet resultado = miStatement.executeQuery(sentencia1);
		if (resultado.next()) {
			String cambiar = "UPDATE encurtidos SET Nombre='"+nombre.getText()+"', FecAlta='"+fechaalta.getText()+"', PrecioKg="+precio.getText()+"WHERE Codigo='"+codigo.getText()+"'" ;
			miStatement.executeUpdate(cambiar);
			respuesta.setForeground(Color.blue); 	
			respuesta.setText("Modificado correctamente");
		}else {
			respuesta.setForeground(Color.red); 	
			respuesta.setText("No se ha encontrado el registro");
		}		
	    if (resultado != null) {  // liberar los ResultSet
	    	resultado.close();
	    }
	} catch (SQLException e) {			
	    System.out.println("Error en anadir");
	    printSQLException(e);
    }
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
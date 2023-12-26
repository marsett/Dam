package examen3EVAL;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.*;


public class AplicacionConsulta {
	public static void main(String[] args) {
		Ventana ventana=new Ventana();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);	
    }
}

class Ventana extends JFrame{
	public Ventana() {
		setBounds(500,300,450,450);
		setTitle("Examen Recuperación 3era Evaluación");
		 	
		LaminaPrincipal laminaPrincipal = new LaminaPrincipal();
		add(laminaPrincipal);		
	}
}

class LaminaPrincipal extends JPanel implements ActionListener {
	private JComboBox jcb_nombre;
	private JTextField fechaAlta;
	private JTextArea areaResultado;
	private JButton botonConsulta;
	private JButton botonModificar;
	private JLabel respuesta;
	
	private Connection miConexion;
	
	public LaminaPrincipal () {
	 setLayout(new BorderLayout());
	 JPanel laminaMenu = new JPanel();
	 laminaMenu.setLayout(new FlowLayout());
	 JPanel laminaBotones = new JPanel();
	 laminaBotones.setLayout(new FlowLayout());
		
	 jcb_nombre = new JComboBox();
	 jcb_nombre.setEditable(false);
	 jcb_nombre.addItem("Todos");
	 
	 areaResultado = new JTextArea(4,50);
	 areaResultado.setEditable(false);
	 JLabel lc =new JLabel("Encurtido: ");
	 laminaMenu.add(lc);
	 laminaMenu.add(jcb_nombre);
	 JLabel fec =new JLabel("Fecha Alta: ");
	 laminaMenu.add(fec);
	 fechaAlta = new JTextField();
	 fechaAlta.setColumns(10);
	 laminaMenu.add(fechaAlta);
	 add(laminaMenu,BorderLayout.NORTH);
	 add(areaResultado,BorderLayout.CENTER);
	 botonConsulta = new JButton ("Consulta");
	 botonModificar = new JButton ("Modificar FechaAl");
	 
	 add(laminaBotones,BorderLayout.SOUTH);
	 laminaBotones.add(botonConsulta);
	 laminaBotones.add(botonModificar);
	 respuesta = new JLabel("");
	 laminaBotones.add(respuesta);
	
	 botonConsulta.addActionListener(this);
	 botonModificar.addActionListener(this);
	 	
	 //------ Conexión con Base de Datos -------
	 Statement sentencia = null;
	 try {
	  miConexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/TIENDA","root","Solaris");
	  sentencia = miConexion.createStatement();
	  String consulta = "SELECT DISTINCT NOMBRE FROM ENCURTIDOS";
	  ResultSet rs = sentencia.executeQuery(consulta);	
	  while(rs.next()) {
		  jcb_nombre.addItem(rs.getString(1));
	  }
	  respuesta.setForeground(Color.blue); 	
	  respuesta.setText("");
	  rs.close();
	  sentencia.close(); 
	 } catch (SQLException e) {			
		    System.out.println("Error en main");
		    printSQLException(e);
     }
 }

 public void actionPerformed (ActionEvent e) {
   Object botonPulsado = e.getSource();
   Statement sentencia = null; 
   String nombre = (String)jcb_nombre.getSelectedItem();
  	if (botonPulsado == botonConsulta) {  
	  String consulta = "SELECT * FROM ENCURTIDOS";
	  if ( !nombre.equals("Todos") )
	     consulta += " WHERE NOMBRE = '" + nombre + "'";
	  consulta +=" ORDER BY CODIGO";
	  areaResultado.setText("");
	  try {
 	   sentencia = miConexion.createStatement();
	   //System.out.println(consulta);
	   ResultSet rs = sentencia.executeQuery(consulta); 
	   while(rs.next()) {   
 	    areaResultado.append(rs.getString(1) + " " + rs.getString(2) + " " 
	     + rs.getString(3) + " " + rs.getString(4) + "\n");
	   }
	   respuesta.setForeground(Color.blue); 	
	   respuesta.setText("Consulta OK");
	  } catch (SQLException ex) {			
		    System.out.println("Error de Consulta en BD");
		    printSQLException(ex);
	  }    
	 }
	 if (botonPulsado == botonModificar) {
	   try {
		 if (!fechaAlta.getText().equals("")) {
		  String cambiar = "UPDATE encurtidos SET FECALTA = '" + fechaAlta.getText() + "'";
		  String select = "SELECT * FROM encurtidos";
		  if ( !nombre.equals("Todos") ) {
			  cambiar += " WHERE NOMBRE = '" + nombre + "'";
			  select += " WHERE NOMBRE = '" + nombre + "'";
		  }
		    System.out.println(cambiar);

		  sentencia = miConexion.createStatement(); 	
		  sentencia.executeUpdate(cambiar);
		  
		  respuesta.setForeground(Color.blue); 	
		  respuesta.setText("Modificación OK");		  
		    System.out.println(select);

		  ResultSet rs = sentencia.executeQuery(select);
		  areaResultado.setText("");
		  while(rs.next()) {   
			  areaResultado.append(rs.getString(1) + " " + rs.getString(2) + " " 
			     + rs.getString(3) + " " + rs.getString(4) + "\n");
		  }
  		 }else {
			respuesta.setForeground(Color.red); 	
			respuesta.setText("FecAlta está vacío");
		 }		
	   } catch (SQLException ex) {			
		    System.out.println("Error de Modificación en BD");
		    printSQLException(ex);
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

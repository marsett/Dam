package aplicacionConsultaPreparada;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		setBounds(500,300,400,400);
		setTitle("Aplicación de Consulta");
		 	
		LaminaPrincipal laminaPrincipal = new LaminaPrincipal();
		add(laminaPrincipal);		
	}
}

class LaminaPrincipal extends JPanel implements ActionListener {
	private JComboBox jcb_curso;
	private JComboBox jcb_edad;
	private JTextArea areaResultado;
	private JButton botonConsulta;
	private Connection miConexion;
	
	public LaminaPrincipal () {
	 setLayout(new BorderLayout());
	 JPanel laminaMenu = new JPanel();
	 laminaMenu.setLayout(new FlowLayout());
		
	 jcb_curso = new JComboBox();
	 jcb_curso.setEditable(false);
	 jcb_curso.addItem("Todos");
		
	 jcb_edad = new JComboBox();
	 jcb_edad.setEditable(false);
	 jcb_edad.addItem("Todos");
		
	 areaResultado = new JTextArea(4,50);
	 areaResultado.setEditable(false);
	 JLabel lc =new JLabel("Curso: ");
	 laminaMenu.add(lc);
	 laminaMenu.add(jcb_curso);
	 JLabel le =new JLabel("Edad: ");
	 laminaMenu.add(le);
	 laminaMenu.add(jcb_edad);
	 add(laminaMenu,BorderLayout.NORTH);
	 add(areaResultado,BorderLayout.CENTER);
	 botonConsulta = new JButton ("Consulta");
	 add(botonConsulta,BorderLayout.SOUTH);
	 botonConsulta.addActionListener(this);
	 	
	 //------ Conexión con Base de Datos -------
	 Statement sentencia = null;
	 try {
	  miConexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/COLEGIO","root","Solaris");
	  sentencia = miConexion.createStatement();
	  String consulta = "SELECT DISTINCT CURSO FROM ALUMNOS";
	  ResultSet rs = sentencia.executeQuery(consulta);	
	  while(rs.next()) {
	   jcb_curso.addItem(rs.getString(1));
	  }
	  rs.close();
	  consulta = "SELECT DISTINCT EDAD FROM ALUMNOS";
	  rs = sentencia.executeQuery(consulta);	
	  while(rs.next()) {
		  jcb_edad.addItem(rs.getString(1));
	  }
	  rs.close();
	  sentencia.close(); 
	 } catch (SQLException e) {			
		    System.out.println("Error en main");
		    printSQLException(e);
     }
 }

 public void actionPerformed (ActionEvent e) {
 	String curso = (String)jcb_curso.getSelectedItem(); 
	String edad = (String)jcb_edad.getSelectedItem();
	String consultaPre = "SELECT * FROM ALUMNOS "
	 + "WHERE CURSO LIKE ? AND EDAD LIKE ? ORDER BY IDALUMNO";
	try {
	  PreparedStatement sentenciaPre = miConexion.prepareStatement(consultaPre);
	  if (curso.equals("Todos")) 
			sentenciaPre.setString(1, "%");
	  else 
			sentenciaPre.setString(1, curso);
	  if (edad.equals("Todos")) 
			sentenciaPre.setString(2, "%");
	  else 
			sentenciaPre.setString(2, edad);
	  areaResultado.setText("");
	  System.out.println(sentenciaPre.toString());
	  ResultSet rs = sentenciaPre.executeQuery();	
	  while(rs.next()) {
		  areaResultado.append(rs.getString(1) + " " + rs.getString(2) 
		  + " " + rs.getString(3) + " " + rs.getString(4) 
		  + " " + rs.getString(5));
		  areaResultado.append("\n");
	  }
	  rs.close();
	  sentenciaPre.close(); 
	 } catch (SQLException e1) {			
		    System.out.println("Error en main");
		    printSQLException(e1);
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
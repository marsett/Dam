
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;
	

public class Principal {
	public static void main(String[] args) {
		Toolkit pantalla=Toolkit.getDefaultToolkit();
		Dimension resolucionPantalla=pantalla.getScreenSize();
		int anchoPantalla=resolucionPantalla.width; 
		int altoPantalla=resolucionPantalla.height; 

		Ventana ventana=new Ventana(anchoPantalla,altoPantalla);
		}
}


 class Ventana extends JFrame{
	JRadioButton cocido=new JRadioButton("Cocido");
	JRadioButton lentejas=new JRadioButton("Lentejas");
	JRadioButton judias=new JRadioButton("Judias");
	int valores[] = {0,0,0,0,0,0,0,0,0,0,0,0};
	int ingredientesCocido[] = {0,1,0,0,1,1,0,0,0,1,0,0};
	int ingredientesLentejas[] = {1,0,0,0,1,0,0,0,1,1,0,1};
	int ingredientesJudias[] = {0,0,1,1,1,0,1,1,1,0,0,0};
	
	JCheckBox len=new JCheckBox("Lentejas");
	JCheckBox gar=new JCheckBox("Garbanzos");
	JCheckBox jud=new JCheckBox("Judias");
	JCheckBox nue=new JCheckBox("Nuez Moscada");
	JCheckBox cho=new JCheckBox("Chorizo");
	JCheckBox mor=new JCheckBox("Morcilla");
	JCheckBox col=new JCheckBox("Colorante");
	JCheckBox lau=new JCheckBox("Laurel");
	JCheckBox ceb=new JCheckBox("Cebolla");
	JCheckBox zan=new JCheckBox("Zanahoria");
	JCheckBox pes=new JCheckBox("Pescado");
	JCheckBox pim=new JCheckBox("Pimenton");
	
	JButton comprobar=new JButton("Comprobar");
	JLabel etiqueta = new JLabel();
	private String botonRPulsado = "";
		
	public Ventana(int ancho, int alto) {
		  int alturaVentana = (int)((alto/2)*0.93);
		  int anchoVentana=(int)ancho/2;	
		  setBounds(ancho/3,0,anchoVentana, alturaVentana);		 
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		  setTitle("Chef 4000");	
		  setLayout(new BorderLayout());
		  LaminaN laminaMarcoN = new LaminaN();
		  add(laminaMarcoN, BorderLayout.NORTH);
		  LaminaC laminaMarcoC = new LaminaC();
		  add(laminaMarcoC, BorderLayout.CENTER);			
		  LaminaS laminaMarcoS = new LaminaS();
		  add(laminaMarcoS, BorderLayout.SOUTH);
				
		  //Hace visible la segunda ventana
		  //Lo ponemos lo último, porque sino a veces no veremos en pantalla lo que se haya definido después de hacerla visible
		  setVisible(true);	
		}

 class LaminaN extends JPanel implements ActionListener {	
	LaminaN(){
	  add(cocido);
	  add(lentejas);
	  add(judias);
	  cocido.addActionListener(this);
	  lentejas.addActionListener(this);
	  judias.addActionListener(this);
   }
  public void actionPerformed (ActionEvent e) {
	Object botonPulsado = e.getSource();
	  if (botonPulsado == cocido) {
		  botonRPulsado = "cocido";
		  lentejas.setSelected(false);
		  judias.setSelected(false);
	  }	  
	  else if (botonPulsado == lentejas) {
		  botonRPulsado = "lentejas";
		  cocido.setSelected(false);
		  judias.setSelected(false);
	  }	  
	  else if (botonPulsado == judias) {
		  botonRPulsado = "judias";
		  lentejas.setSelected(false);
		  cocido.setSelected(false);
	  }	  
	}
 }
 
 class LaminaC extends JPanel implements ActionListener{	
	LaminaC(){
		//setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
		setLayout(new GridLayout(3,4));
		add(len);len.addActionListener(this);add(gar);gar.addActionListener(this);
		add(jud);jud.addActionListener(this);add(nue);nue.addActionListener(this);
		add(cho);cho.addActionListener(this);add(mor);mor.addActionListener(this);
		add(col);col.addActionListener(this);add(lau);lau.addActionListener(this);
		add(ceb);ceb.addActionListener(this);add(zan);zan.addActionListener(this);
		add(pes);pes.addActionListener(this);add(pim);pim.addActionListener(this);
	}
	public void actionPerformed (ActionEvent e) {
		  Object botonPulsado = e.getSource();
			if (botonPulsado == len)
			 if (len.isSelected()) valores[0]=1; else valores[0]=0;
			else if (botonPulsado == gar)
			 if (gar.isSelected()) valores[1]=1; else valores[1]=0;
			else if (botonPulsado == jud)
			 if (jud.isSelected()) valores[2]=1; else valores[2]=0;
			else if (botonPulsado == nue)
			 if (nue.isSelected()) valores[3]=1; else valores[3]=0;
			else if (botonPulsado == cho)
			 if (cho.isSelected()) valores[4]=1; else valores[4]=0;
			else if (botonPulsado == mor)
			 if (mor.isSelected()) valores[5]=1; else valores[5]=0;
			else if (botonPulsado == col)
			 if (col.isSelected()) valores[6]=1; else valores[6]=0;
			else if (botonPulsado == lau)
			 if (lau.isSelected()) valores[7]=1; else valores[7]=0;
			else if (botonPulsado == ceb)
			 if (ceb.isSelected()) valores[8]=1; else valores[8]=0;
			else if (botonPulsado == zan)
			 if (zan.isSelected()) valores[9]=1; else valores[9]=0;
			else if (botonPulsado == pes)
			 if (pes.isSelected()) valores[10]=1; else valores[10]=0;
			else if (botonPulsado == pim)
			 if (pim.isSelected()) valores[11]=1; else valores[11]=0;
		}	
 }	
 class LaminaS extends JPanel implements ActionListener {	
	LaminaS(){
	  add(comprobar);
	  add(etiqueta);
	  comprobar.addActionListener(this);
	}
	public void actionPerformed (ActionEvent e) {
		 System.out.print("\nvalores: ");
		 for (int i=0; i<12; i++) 
			 System.out.print(valores[i] + " ");	
		 if (botonRPulsado == "cocido") {
			 System.out.print("\ncocido: ");
			 for (int i=0; i<12; i++) 
					 System.out.print(ingredientesCocido[i] + " ");
				
			 if ( Arrays.equals(valores, ingredientesCocido) ) 
				 etiqueta.setText("Correcto");
			 else 
				 etiqueta.setText("MAL");
		  }	else if (botonRPulsado == "lentejas") {
			System.out.print("\nlentejas: ");
			for (int i=0; i<12; i++) 
						 System.out.print(ingredientesLentejas[i] + " ");
			  if ( Arrays.equals(valores, ingredientesLentejas) ) 
					 etiqueta.setText("Correcto");
				 else 
					 etiqueta.setText("MAL");
		  } else if (botonRPulsado == "judias") {
			 System.out.print("\njudias: ");
			 for (int i=0; i<12; i++) 
					 System.out.print(ingredientesJudias[i] + " ");
			  if ( Arrays.equals(valores, ingredientesJudias) ) 
					 etiqueta.setText("Correcto");
				 else 
					 etiqueta.setText("MAL");
		  }
		}
  }		
}
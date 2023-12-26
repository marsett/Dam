package examenDI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class Interfaz extends Frame implements ActionListener, ItemListener, WindowListener{
	private TextField nombre, apellidos;
	private Checkbox matriculado;
	private Choice provincia, localidad;
	private Button btnEnviar;
	private boolean valorMatriculado;
	public static void main(String[] args) {
		new Interfaz("Examen de Interfaces 2º DAM");
	}
	public Interfaz(String titulo) {
		super(titulo);
		addWindowListener(this);
		Panel panel1=new Panel();
		FlowLayout fl=new FlowLayout();
		fl.setAlignment(FlowLayout.CENTER);
		
		Label etiqueta=new Label("FORMULARIO DE ENTRADA");
		Label etiquetaNombre=new Label("Nombre");
		Label etiquetaApellidos=new Label("Apellidos");
		Label etiquetaMatriculado=new Label("Matriculado");
		Label etiquetaProvincia=new Label("Provincia");
		Label etiquetaLocalidad=new Label("Localidad");
		
		nombre=new TextField("Nombre",20);
		apellidos=new TextField("Apellidos",20);
		
		matriculado=new Checkbox("si");
		matriculado.addItemListener(this);
		
		provincia=new Choice();
		provincia.addItem("Ciudad Real");
		provincia.addItem("Madrid");
		localidad=new Choice();
		
		provincia.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Choice prov=(Choice)e.getSource();
				switch(e.getStateChange()) {
				case 1:
					if(prov.getSelectedItem().equals("Ciudad Real")) {
						localidad.addItem("Almodovar");
						localidad.addItem("Tarancon");
					}
				break;
				case 2:
					if(prov.getSelectedItem().equals("Madrid")){
						localidad.addItem("Vallecas");
						localidad.addItem("Vicalvaro");
					}
					break;
				}
			}
		});

		btnEnviar=new Button("Enviar");
		btnEnviar.addActionListener(this);
		
		add(panel1);
		panel1.add(etiqueta);
		panel1.add(etiquetaNombre);
		panel1.add(nombre);
		panel1.add(etiquetaApellidos);
		panel1.add(apellidos);
		panel1.add(etiquetaMatriculado);
		panel1.add(matriculado);
		panel1.add(etiquetaProvincia);
		panel1.add(provincia);
		panel1.add(etiquetaLocalidad);
		panel1.add(localidad);
		panel1.add(btnEnviar);
		
		panel1.setLayout(fl);
		setSize(700,700);
		setVisible(true);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		
		Checkbox emisor=(Checkbox)e.getSource();
		if(emisor==matriculado) {
			if(e.getStateChange()==ItemEvent.SELECTED) {
				valorMatriculado=true;
			}else {
				valorMatriculado=false;
			}
		}
		
		
		
		
		
	}
	Usuario usuario;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(btnEnviar==(Button)e.getSource()) {
			String valorNombre=nombre.getText();
			String valorApellidos=apellidos.getText();
			String valorProvincia=provincia.getSelectedItem();
			String valorLocalidad=localidad.getSelectedItem();
			
			usuario=new Usuario(valorNombre,valorApellidos,valorMatriculado,valorProvincia, valorLocalidad);
			System.out.println(usuario.toString());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		int numero=0;
		System.exit(numero);
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}

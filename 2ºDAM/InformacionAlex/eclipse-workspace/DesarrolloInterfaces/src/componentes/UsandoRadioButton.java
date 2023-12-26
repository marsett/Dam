package componentes;
import java.awt.*;
import java.awt.event.*;
public class UsandoRadioButton extends Frame implements ItemListener{
	private static final long serialVersionUID = 1L;
	private Checkbox cb1, cb2, cb3;
	public static void main(String[] args) {
		new UsandoRadioButton();
	}
	public UsandoRadioButton() {
		CheckboxGroup grupo=new CheckboxGroup();
		cb1=new Checkbox("Opcion 1", grupo, false);
		cb1.addItemListener(this);
		cb2=new Checkbox("Opcion 2", grupo ,false);
		cb2.addItemListener(this);
		cb3=new Checkbox("Opcion 3", grupo, false);
		cb3.addItemListener(this);
		setLayout(new FlowLayout());
		TextField etiqueta=new TextField("Etiqueta",60);
		etiqueta.setEnabled(false);	//deshabilita que se modifique el componente
		add(etiqueta);
		add(cb1);
		add(cb2);
		add(cb3);
		setSize(950,400);
		setVisible(true);
		//manejador:clase que indica al componente que debe de hacer
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		System.out.println("itemStateChanged");
		Checkbox cb=(Checkbox)(e.getSource());	//referencia al elemento que ha recibido el evento
		if(e.getStateChange()==ItemEvent.SELECTED) {
			System.out.println("Se ha hecho la seleccion");
			cb.setBackground(Color.green);
		}
		if(e.getStateChange()==ItemEvent.DESELECTED) {
			System.out.println("Se ha quitado la seleccion");
			cb.setBackground(Color.red);
		}
	}
}
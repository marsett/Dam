package componentes;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class UsandoChoices extends Frame implements ActionListener, ItemListener{
	private static final long serialVersionUID = 1L;
	private Choice combo;
	private Button btnSelecPrimer, btnSelecBusqueda, btnInsertar;
	private Dimension dim;
	private String valor;
	private TextField cajaTextoInsertar;
	public static void main(String[] args) {
		new UsandoChoices("Ejemplo COMBOBOX");
	}
	public UsandoChoices(String title) {
		super(title);
		combo=new Choice();
		btnSelecPrimer=new Button("Seleccionar Primero");
		btnSelecBusqueda=new Button("Seleccionar Busqueda");
		btnInsertar=new Button("Añadir");
		Label etiqueta=new Label("Etiqueta");
		cajaTextoInsertar=new TextField(valor,60);
		dim=etiqueta.getSize();
		@SuppressWarnings("unused")
		int ancho=(int)dim.getHeight()+50;
		@SuppressWarnings("unused")
		int alto=(int)dim.getHeight()+50;
		etiqueta.setSize(dim);
		combo.addItem("Opcion 1");
		combo.addItem("Opcion 2");
		combo.addItem("Opcion 3");
		combo.addItem("Opcion 4");
		combo.addItem("Opcion 5");
		combo.addItemListener(this);
		btnInsertar.addActionListener(this);
		setLayout(new FlowLayout());
		add(etiqueta);
		add(cajaTextoInsertar);
		add(btnSelecPrimer);
		add(btnSelecBusqueda);
		add(btnInsertar);
		add(combo);
		setSize(500,500);
		setVisible(true);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Choice emisor=(Choice)e.getSource();	//el objeto que habia recibido la interaccion del usuario
		//lista los items del elemento seleccionado
		int numeroOpciones=emisor.getItemCount();
		for(int i=0;i<numeroOpciones;i++) {
			System.out.println(">>>>"+emisor.getItem(i));
		}
		if(emisor==combo) {
			if(e.getStateChange()==ItemEvent.SELECTED) {
					String opcionSeleccionada=emisor.getSelectedItem();
				System.out.println("Seleccionado: "+opcionSeleccionada);
					int indice=emisor.getSelectedIndex();
				System.out.println("Seleccionado: "+indice);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
		if(btnInsertar==(Button)e.getSource()) {	//elemento que ha recibido el evento= getSource
			String valorCaja=cajaTextoInsertar.getText();
			combo.addItem(valorCaja);
		}
	}
}

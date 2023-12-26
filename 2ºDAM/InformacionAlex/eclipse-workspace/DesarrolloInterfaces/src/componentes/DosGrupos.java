package componentes;
import java.awt.*;
public class DosGrupos extends Frame{
	private static final long serialVersionUID = 1L;
	private Checkbox hombre, mujer, otrogenero, estudiante, trabajador, otrocargo;
	public static void main(String[] args) {
		new DosGrupos();
	}
	public DosGrupos() {
		CheckboxGroup grupo1=new CheckboxGroup();
		hombre=new Checkbox("Hombre", grupo1, false);
		mujer=new Checkbox("Mujer", grupo1, false);
		otrogenero=new Checkbox("OtroGenero", grupo1, false);
		CheckboxGroup grupo2=new CheckboxGroup();
		estudiante=new Checkbox("Estudiante", grupo2, false);
		trabajador=new Checkbox("Trabajador", grupo2, false);
		otrocargo=new Checkbox("OtroCargo", grupo2, false);
		setLayout(new FlowLayout());
		TextField etiqueta=new TextField("Etiqueta",60);
		etiqueta.setEnabled(false);	//deshabilita que se modifique el componente
		add(etiqueta);
		add(hombre);
		add(mujer);
		add(otrogenero);
		add(estudiante);
		add(trabajador);
		add(otrocargo);
		setSize(950,400);
		setVisible(true);
	}
}

package arboles.renderizado;
import java.util.*;

public class NodoArbolVector<Empleado> extends Vector<Empleado>{
	private static final long serialVersionUID = 1L;
	String nombre;
	public NodoArbolVector(String nombre) {
		this.nombre=nombre;
	}
	public NodoArbolVector(String nombre, Empleado[] empleados) {
		this.nombre=nombre;
		for(int i=0, n=empleados.length;i<n;i++) {
			add(empleados[i]);
		}
	}
	@Override
	public String toString() {
		//return "NodoArbolVector [nombre=" + nombre + "]";
		return nombre;
	}
}

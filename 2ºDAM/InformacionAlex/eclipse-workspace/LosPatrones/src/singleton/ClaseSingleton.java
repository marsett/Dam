package singleton;

public class ClaseSingleton {
	private String contenido;
	private static ClaseSingleton instancia=new ClaseSingleton();
	private ClaseSingleton() {
		setContenido("Contenido Inicial");
	}
	public static ClaseSingleton getInstancia() {
		return instancia;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	@Override
	public String toString() {
		return "ClaseSingleton [contenido=" + contenido + "]";
	}
}

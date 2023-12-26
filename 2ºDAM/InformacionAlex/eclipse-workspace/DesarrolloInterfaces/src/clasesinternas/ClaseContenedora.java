package clasesinternas;

public class ClaseContenedora {
	int valor=10;
	static int valorEstatico=10;
	public static void metodo2() {
		System.out.println("acceso "+valorEstatico);
	}
	public void metodo() {
		System.out.println("acceso "+valor);
		// no se puede directamente acceder al metodo de metodoClaseAnidada();
	}
	static class ClaseAnidada{
		public ClaseAnidada() {
			System.out.println(valorEstatico);
			metodo2();
		}
		public void metodoClaseAnidada() {
			
		}
		static class SubClaseAnidada {
			public SubClaseAnidada() {
			System.out.println(valorEstatico);
			metodo2();
			}
		}
		class SubClase {
			public SubClase() {
			System.out.println(valorEstatico);
			metodo2();
			}
		}
	}
}

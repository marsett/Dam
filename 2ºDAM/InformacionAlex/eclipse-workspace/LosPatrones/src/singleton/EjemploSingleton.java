package singleton;

public class EjemploSingleton {
	public static void main(String[] args) {
		ClaseSingleton ap1=ClaseSingleton.getInstancia();
		ap1.setContenido("Algo");
		
		ClaseSingleton ap2=ClaseSingleton.getInstancia();
		ap2.setContenido("Otra Cosa");
		System.out.println(ap2);
		System.out.println(ap1);
	}
}

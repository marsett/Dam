package gestionFicheros;

public class ArchivoLinuxWindows {

	/*
	 * Creo un String cuyo valor sera el nombre del SO (obtenido con el metodo
	 * getProperty de la clase System) y lo paso a minusculas con toLowerCase()
	 */

	private static String SO = System.getProperty("os.name").toLowerCase();

	/*
	 * Creo dos metodos que devuelven una booleana que da true si 3 de las primeras
	 * letras de la variable SO coinciden con tres letras del nombre del sistema
	 * (windows, linux, unix...)
	 */

	public static boolean esWindows() {
		return (SO.indexOf("win") >= 0);
	}

	public static boolean esLinux() {
		return (SO.indexOf("nix") >= 0 || SO.indexOf("nux") >= 0 || SO.indexOf("aix") >= 0);
	}

	public static void main(String[] args) {

		String x;

		/*
		 * Por ultimo, paso esas booleanas por estructuras de control if para que el
		 * sistema devuelva cual es su SO
		 */
		if (esWindows() == true) {
			x = "Estamos en Windows";
			System.out.println(x);
		}

		if (esLinux() == true) {
			x = "Estamos en Linux";
			System.out.println(x);
		}

	}

}

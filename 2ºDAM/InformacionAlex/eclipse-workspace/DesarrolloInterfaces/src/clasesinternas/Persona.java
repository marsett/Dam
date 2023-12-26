package clasesinternas;

public class Persona {
	private String nombre;
	private int edad;

	public Persona() {
		this.nombre = "anonimo";
		this.edad = 18;
	}

	public void metodo() {
		class Direccion {
			private String nombreCalle;
			private int numero;
			private int piso;
			private int codPostal;

			public Direccion(String nombreCalle, int numero, int piso, int codPostal) {
				this.nombreCalle = nombreCalle;
				this.numero = numero;
				this.piso = piso;
				this.codPostal = codPostal;
			}
		}
		Direccion direccion = new Direccion("Sin calle", 0, 0, 0);
	}
}

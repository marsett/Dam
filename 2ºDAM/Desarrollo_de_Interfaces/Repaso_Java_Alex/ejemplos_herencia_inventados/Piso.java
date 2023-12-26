

class Piso extends Vivienda implements Precio_Piso{
	
	public Piso(double valor, double tamano, String nombreDueno, String nombreVivienda, String ubicacion, boolean servicios, boolean seguridad) {
		super(valor,tamano,nombreDueno,nombreVivienda,ubicacion,servicios,seguridad);
	}
	
	
	public String dameDescripcion() {
		return"El piso tiene un tamano de "+tamano+" cuyo dueno es "
				+ nombreDueno+" cuya ubicacion es "+ubicacion;
	}
	
	public void metodoabstracto() {
		System.out.println("El precio final es "+PRECIO_FINAL);
	}
	
	static int numColumnas=9;
	
	public static void metodoestatico() {
		System.out.println("El numero de columnas en el piso es de "+numColumnas);
	}
	
}

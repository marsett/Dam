

public class Apartamento extends Vivienda{
	public Apartamento(String nombreVivienda, double valor, double tamano, String ubicacion) {
		super(nombreVivienda,valor,tamano,ubicacion);
    }
	
	public String dameDescripcion() {
		return"El nombre de la vivienda es "+nombreVivienda+" tiene servicios -->"
				+servicios+" y seguridad "+seguridad;
	}
	
}

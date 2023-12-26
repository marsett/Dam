abstract class Vivienda {
	double valor;
    double tamano;
    String nombreDueno;
    String nombreVivienda;
    String ubicacion;
    boolean servicios;
    boolean seguridad;
    
    public Vivienda(double valor, double tamano, String nombreDueno, String nombreVivienda, String ubicacion, boolean servicios, boolean seguridad) {
    	this.valor=valor;
        this.tamano=tamano;
        this.nombreDueno=nombreDueno;
        this.nombreVivienda=nombreVivienda;
        this.ubicacion=ubicacion;
        this.servicios=servicios;
        this.seguridad=seguridad;
    }
    public Vivienda(String nombreVivienda, double valor, double tamano, String ubicacion) {
    	this.nombreVivienda=nombreVivienda;
        this.valor=valor;
        this.tamano=tamano;
        this.ubicacion=ubicacion;
    }
    
    public abstract String dameDescripcion();
    
    public void subeValor(double porcentaje) {
    	double aumento=valor*porcentaje/100;
		valor+=aumento;
    }
    
}
package examen2;

public class Docencia extends Aula {
	
	Docencia (int alumnos){
    	this.setMagnitud((int)(getMagnitud()*1.2));
    	this.setUsuarios(alumnos);
    	System.out.println("Docencia --> magnitud:" + this.getMagnitud() + " usuarios:" + this.getUsuarios());
    }
    
	public void avisoExcesoCapacidad() {
		if (this.limiteCapacidad()) 
		  System.out.println("***Cuidado, ha superado la capacidad máxima del aula***");
	}
}

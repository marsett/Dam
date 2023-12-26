package examen2;

public class Informatica extends Aula {
 private int numPCs;
 
 Informatica (int alumnos){
 	this.setMagnitud((int)(getMagnitud()*0.8));
 	this.setUsuarios(alumnos);
 	this.numPCs = (int)(this.getMagnitud()/2);
 	System.out.println("Informática --> magnitud:" + this.getMagnitud() + " usuarios:" + this.getUsuarios());

 }
 Informatica (int alumnos, int numpcs){
	 	this.setMagnitud((int)(getMagnitud()*0.8));
	 	this.setUsuarios(alumnos);
	 	this.numPCs = numpcs;
 }
 
 public int getNumPCs() {
	 return this.numPCs;
 }
 public void setNumPCs(int numPCs) {
	 this.numPCs = numPCs;
 }
 
 public boolean limiteCapacidad() {
	 if (numPCs >= this.getUsuarios()) {
		 return false;
	 }
	 else return true;
 }
 
 public void avisoExcesoCapacidad() {
		if (this.limiteCapacidad()) 
		  System.out.println("***Cuidado, ha superado la capacidad máxima del aula***");
 }
 
}

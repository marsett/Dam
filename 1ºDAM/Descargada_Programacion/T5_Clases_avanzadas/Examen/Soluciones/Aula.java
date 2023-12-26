package examen2;

public abstract class Aula {
 private int magnitud = 60; //tamaño en m2
 private int usuarios = 0; //número de alumnos
 
 public int getMagnitud() {
	 return magnitud;
 }
 
 public void setMagnitud(int magnitud) {
	 this.magnitud = magnitud;
 }
 
 public int getUsuarios() {
	 return usuarios;
 }
 
 public void setUsuarios(int usuarios) {
	 this.usuarios = usuarios;
 }
 
 public boolean limiteCapacidad() {
	 //System.out.println("Dentro de limiteCapacidad en Aula: " + ((int)(magnitud/usuarios)>=1));
	 if (magnitud/usuarios >= 1) {
		 return false;
	 } else return true;
 }
 
 public abstract void avisoExcesoCapacidad();
}

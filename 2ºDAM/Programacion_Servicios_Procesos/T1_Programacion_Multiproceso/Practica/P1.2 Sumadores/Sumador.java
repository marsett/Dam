package sumas_procesos;

public class Sumador {
	
	 public int sumar(String ... pasarray){
		 int resultado=0;
		 for (int i=0;i<pasarray.length;i++){
			 resultado+=Integer.parseInt(pasarray[i]);
		 }
		 return resultado;
	 }
	 
	 /*public static void main(String[] args){
		 Sumador s=new Sumador();
		 int resultado=s.sumar(args);
		 System.out.println(resultado);
	}*/
	 
}
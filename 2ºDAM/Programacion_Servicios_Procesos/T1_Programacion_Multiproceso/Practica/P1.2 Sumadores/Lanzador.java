package sumas_procesos;

public class Lanzador {
	
	 public void lanzarSumador(){
		 String clase="sumas_procesos.Sumador";
		 ProcessBuilder pb;
		 try {
			 pb = new ProcessBuilder("java",clase);
			 pb.start();
		 } 
		 catch (Exception e) {
			 e.printStackTrace();
		 }
	 }
	 
	 public static void main(String[] args){
		 Lanzador l=new Lanzador();
		 l.lanzarSumador();
		 System.out.println("Ok");
	 }
	 
}

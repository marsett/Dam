package examenquitado;

import java.io.*;
import java.util.*;

public class ClasePrincipal {
	public static void main(String[] args) throws IOException{
		ArrayList<String> lista = new ArrayList<>();
		ProcessBuilder pb = new ProcessBuilder();
		File directorioBin = new File("C:\\Users\\jimen\\eclipse-workspace\\ServiciosProcesos\\bin");
		int sumaTotal = 0;
		for(int i=0; i<3; i++) {
			pb.command("java", "examenquitado.ClaseSecundaria", args[i]);
			pb.directory(directorioBin);
			Process proceso = pb.start();
			InputStream is = proceso.getInputStream();
			int numero;
			String s="";
			while((numero = is.read()) !=-1) {
				s+=(char)numero;
			}
			lista.add(s);
		}
		for(int i=0; i<3; i++) {
			sumaTotal += Integer.parseInt(lista.get(i));
		}
		System.out.println("La suma de los 3 procesos es "+sumaTotal);
		ClasePrincipal cp=new ClasePrincipal();
		cp.fichero(sumaTotal);
	}
	public void fichero(int suma) throws IOException{
		File result=new File("C:\\Users\\jimen\\eclipse-workspace\\ServiciosProcesos\\resultado.txt");
		result.createNewFile();
		FileWriter fw=new FileWriter(result);
		fw.write("La Suma Total es "+String.valueOf(suma));
		fw.close();
		ProcessBuilder pb=new ProcessBuilder();
		pb.command("notepad.exe","C:\\Users\\jimen\\eclipse-workspace\\ServiciosProcesos\\resultado.txt");
		pb.start();
	}
}

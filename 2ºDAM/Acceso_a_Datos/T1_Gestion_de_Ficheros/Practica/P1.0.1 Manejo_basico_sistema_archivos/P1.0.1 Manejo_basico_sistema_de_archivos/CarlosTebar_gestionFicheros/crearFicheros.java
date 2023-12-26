package gestionFicheros;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class crearFicheros {

	public static void main(String[] args) {
		

		FileWriter fichero = null;
		Path ruta2 = Paths.get("C:\\Imagenes\\Subdirectorio1");
		Path ruta3 = Paths.get("C:\\Imagenes\\Subdirectorio2");
		Path ruta4 = Paths.get("C:\\Imagenes\\Subdirectorio3");

		File fichero1 = new File(ruta2.toString());
		File fichero2_1 = new File ( ruta2.toString() ,"ejemplo1_1.txt");
		File fichero2_2 = new File ( ruta2.toString() ,"ejemplo1_2.txt");
		File fichero3_1 = new File ( ruta3.toString() ,"ejemplo2_1.txt");
		File fichero3_2 = new File ( ruta3.toString() ,"ejemplo2_2.txt");
		File fichero4_1 = new File ( ruta4.toString() ,"ejemplo3_1.txt");
		File fichero4_2 = new File ( ruta4.toString() ,"ejemplo3_2.txt");
		
		try {
			fichero1.mkdir();

			if (fichero1.exists()) {
				Files.createDirectories(ruta2);
				
				

				if (Files.exists(ruta2)) {
					Files.createDirectories(ruta3);
					fichero2_1.createNewFile();
					fichero2_2.createNewFile();
				}

				if (Files.exists(ruta3)) {
					Files.createDirectories(ruta4);
					fichero3_1.createNewFile();
					fichero3_2.createNewFile();
				}

				if (Files.exists(ruta4)) {
					fichero4_1.createNewFile();
					fichero4_2.createNewFile();
				}

				
				
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No se han podido crear uno o varios directorios");
		}

	}

}

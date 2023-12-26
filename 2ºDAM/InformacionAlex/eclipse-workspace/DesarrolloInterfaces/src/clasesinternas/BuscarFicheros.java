package clasesinternas;
import java.io.*;

public class BuscarFicheros {
	public static void recursiva(File directorio) {
		File[] lista=directorio.listFiles();//obtengo files y directorios
		if(lista==null) {
			//System.out.print("no ha podido revisar ");
			//System.out.println(directorio);
			return;
		}
		for(int i=0;i<lista.length;i++) {
			if(lista[i].isDirectory()) {
				recursiva(lista[i]);
			} else if(lista[i].getAbsolutePath().endsWith(".txt")) {
				System.out.println(lista[i].getAbsolutePath());
			}
		}
	}
	public static void main(String[] args) {
		File directorio=new File("C:\\Users\\jimen\\Downloads");
		//las raices se obtienen con el listRoots
		//funcion recursiva
		//File[] listaFiles=File.listRoots();
		
		//super clase abstracta anonima 
		FilenameFilter filtro=new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");
			}
		};
		//String[]listaFiles2=directorio.list(new Filtro(".class"));
		File[] listaFiles2=directorio.listFiles(filtro);
		/*for(int i=0;i<listaFiles.length;i++) {
			recursiva(listaFiles[i]);
		}*/
		//listaFiles en la recursiva
		/*for(int i=0;i<listaFiles2.length;i++) {
			System.out.println(listaFiles2[i]);
		}*/
		for(File file:listaFiles2) {
			System.out.println(file.getAbsolutePath());
		}
		/*******************/
		File[] listaFiles3=directorio.listFiles();
	}
	//clase anonima (que se crea sin instancia)
}
/*class Filtro implements FilenameFilter{
	String extension;
	public Filtro(String extension){
		this.extension=extension;
	}
	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(extension);
	}
}*/

package archivosbinarios;

import java.io.*;

public class ArchivoAppPerson {
	public static void main(String[] args) {
		Person[] persona=new Person[2];
		persona[0]= new Person(4000, "Ditario", 24, true);
		persona[1]= new Person(6000, "Crispulo", 977, true);
		try {
			FileOutputStream fileOut = new FileOutputStream("personicas.txt");
			ObjectOutputStream salida = new ObjectOutputStream(fileOut);
			for(int i=0;i<persona.length;i++) {
				salida.writeObject(persona[i]);
			}
			salida.close();
			FileInputStream fileIn = new FileInputStream("personicas.txt");
			ObjectInputStream entrada = new ObjectInputStream(fileIn);
			for(int i=0;i<persona.length;i++) {
				Person obj1 = (Person) entrada.readObject();
				System.out.println("Se llama " + obj1.getName());
				System.out.println(obj1);
			}
			entrada.close();
		} catch (FileNotFoundException f) {
			System.out.println(f);
		} catch (IOException i) {
			System.out.println(i);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

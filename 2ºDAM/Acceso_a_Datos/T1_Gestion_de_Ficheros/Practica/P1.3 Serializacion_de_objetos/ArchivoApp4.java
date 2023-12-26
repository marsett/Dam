package serializacion;

import java.io.*;

public class ArchivoApp4 {
	public static void main(String[] args) {
		Lista lista1=new Lista(new int[] {12,15,11,4,32});
		try {
			ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("media.obj"));
			salida.writeObject("guardar este string y un objeto\n");
			salida.writeObject(lista1);
			salida.close();
			ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("media.obj"));
			String str=(String) entrada.readObject();
			Lista obj1=(Lista) entrada.readObject();
			System.out.println("Valor medio "+obj1.valorMedio());
			System.out.println("-------------------------------");
			System.out.println(str+obj1);
			System.out.println("-------------------------------");
			entrada.close();
		}
		catch(IOException ex) {
			System.out.println(ex);
		}
		catch(ClassNotFoundException ex) {
			System.out.println(ex);
		}
		try {
			//espera la pulsacion de una tecla; luego, retorno
			System.in.read();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}

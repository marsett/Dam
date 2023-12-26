package unicast;
import java.net.*;
import java.io.*;

public class ServidorUDP {
	 public static void main (String args[]) {
		 try {
			 //se crea un objeto de la clase DatagramSocket, en cuyo constructor se le pasa el número de puerto
			 //que coincidirá con el de la clase ClienteUDP
			 DatagramSocket socketUDP = new DatagramSocket(6789);
			 //se crea un array de bytes con 1000 posiciones
			 byte[] bufer = new byte[1000];
			 	while (true) {
			 		//se crea el DatagramPacket con el objetivo de recibir peticiones del ClienteUDP
			 		DatagramPacket peticion =new DatagramPacket(bufer, bufer.length);
			 		//se lee la peticion del DatagramPocket
			 		socketUDP.receive(peticion);
			 		//se imprime por pantalla el datagrama recibido del cliente y desde qué puerto viene
			 		System.out.print("Datagrama recibido del host: " +
			 				peticion.getAddress());
			 		System.out.println(" desde el puerto remoto: " +
			 				peticion.getPort());
			 		//se crea el DatagramPacket para enviar la respuesta
			 		DatagramPacket respuesta =new DatagramPacket(peticion.getData(), peticion.getLength(),peticion.getAddress(), peticion.getPort());
			 		//se envia la respuesta a modo ECO
			 		socketUDP.send(respuesta);
			 		socketUDP.close();
			 	}
			 	//saltarian estas excepciones si algo fallase en la ejecucion
		 }catch (SocketException e) {
			 System.out.println("Socket: " + e.getMessage());
		 }catch (IOException e) {
			 System.out.println("IO: " + e.getMessage());
		 }
	 }
} 

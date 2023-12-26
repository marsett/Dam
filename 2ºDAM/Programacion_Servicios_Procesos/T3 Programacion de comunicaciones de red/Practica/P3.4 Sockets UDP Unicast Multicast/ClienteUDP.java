package unicast;
import java.net.*;
import java.io.*;

public class ClienteUDP {
	//los argumentos pasados en run configurations son el mensaje que se quiere mandar
	//al servidor y el nombre del mismo
	 public static void main(String args[]) {
		 try {
			 //se crea un objeto DatagramSocket en cuyo constructor se pasa el número de puerto
			 DatagramSocket socketUDP = new DatagramSocket(7000);
			 //se crea un array de bytes que recibira el mensaje que se introduzca en el primer argumento
			 byte[] mensaje = args[0].getBytes();
			 //este objeto InetAddress recogerá la direccion introducida en el segundo argumento
			 InetAddress hostServidor = InetAddress.getByName(args[1]);
			 int puertoServidor = 6789;
			 //se crea un datagrama DatagramPacket donde se le pasa el mensaje, 
			 //la longitud  del primer argumento, el host y puerto del servidor
			 DatagramPacket peticion =new DatagramPacket(mensaje, args[0].length(), hostServidor,puertoServidor);
			 //se envia el datagrama al ServidorUDP
			 socketUDP.send(peticion);
			 //se crea de igual forma el DatagramPacket que recibirá la respuesta del servidor
			 byte[] bufer = new byte[1000];
			 DatagramPacket respuesta =new DatagramPacket(bufer, bufer.length);
			 socketUDP.receive(respuesta);
			 //se envia la respuesta del servidor a la salida estandar
			 System.out.println("Respuesta: " + new String(respuesta.getData()));
			 //se cierra el socket
			 socketUDP.close();
			 //excepciones recogidas que saltaran si algo falla en la ejecucion
		 }catch (SocketException e) {
			 System.out.println("Socket: " + e.getMessage());
		 }catch (IOException e) {
			 System.out.println("IO: " + e.getMessage());
		 }
	 }
} 
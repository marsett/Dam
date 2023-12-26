package multicast;
import java.net.*;
import java.io.*;
public class MiembroMulticast {
	 public static void main(String args[]) {
		 //en este caso args[0] es el mensaje enviado al grupo y args[1] la direccion del mismo
		 try {
			 //el objeto InetAddress recoge la direccion del grupo
			 InetAddress grupo = InetAddress.getByName(args[1]);
			 //se crea el objeto MulticastSocket, al cual se le pasa el numero de puerto
			 MulticastSocket socket = new MulticastSocket(6723);
			 //este socket se une al grupo
			 socket.joinGroup(grupo);
			 //se envia el mensaje a traves del objeto DatagramPacket
			 byte[] m = args[0].getBytes();
			 DatagramPacket mensajeSalida =new DatagramPacket(m, m.length, grupo, 6723);
			 socket.send(mensajeSalida);
			 byte[] bufer = new byte[1000];
			 String linea;
			 //se queda a la espera de mensajes al grupo hasta recibir "Adios"
			 	while (true) {
			 		DatagramPacket mensajeEntrada =new DatagramPacket(bufer, bufer.length);
			 		socket.receive(mensajeEntrada);
			 		linea = new String(mensajeEntrada.getData(), 0, mensajeEntrada.getLength());
			 		System.out.println("Recibido:" + linea);
			 		if (linea.equals("Adios")) break;
			 	}
			 //si recibe "Adios" abandona el grupo
			 socket.leaveGroup(grupo);
		 } catch (SocketException e) {
			 System.out.println("Socket:" + e.getMessage());
		 } catch (IOException e) {
			 System.out.println("IO:" + e.getMessage());
		 }
	 }
} 
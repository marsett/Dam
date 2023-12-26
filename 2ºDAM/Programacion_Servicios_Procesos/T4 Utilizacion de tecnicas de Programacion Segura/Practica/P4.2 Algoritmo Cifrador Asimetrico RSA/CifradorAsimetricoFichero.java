package encriptacion;
import java.io.*;
import java.security.*;
import java.security.spec.*;
import java.util.*;
import javax.crypto.*;

public class CifradorAsimetricoFichero {
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
		//se crea el cifrador RSA perteneciente a la clase Cipher
		Cipher cifradorRsa;
		//se generan el par de claves RSA
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		//se guardan el par de claves pública y privada en variables
	    PublicKey publicKey = keyPair.getPublic();
	    PrivateKey privateKey = keyPair.getPrivate();
	    //se establece el tipo de cifrado (por parámetro se establece el cifrado RSA)
	    cifradorRsa = Cipher.getInstance("RSA/ECB/PKCS1Padding");
	    //se crea un objeto de la clase Scanner
	    Scanner entrada=new Scanner(System.in);
	    //a este objeto se le establece un delimitador (salto de línea)
	    entrada.useDelimiter("\n");
		System.out.println("Escribe la ruta del fichero a codificar");
		//se escribe la ruta del fichero cuyo contenido va a ser codificado
		String fichero=entrada.nextLine();
		entrada.close();
		String contenido=null;
		try {
			//se crea el objeto de tipo File que va a recoger por parámetro la ruta insertada
			File f=new File(fichero);
			//se crea el FileReader y BufferedReader encargados de leer el contenido del fichero
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			//dentro del bucle que lee el contenido, se hará el cifrado y descifrado
			while((contenido=br.readLine())!=null) {
				//cada línea se almacena en otro String diferente
				String texto=contenido;
				//se encripta la línea llamando al método init, con la clave pública
			    cifradorRsa.init(Cipher.ENCRYPT_MODE, publicKey);
			    //se almacena en un array de bytes la información del fichero
			    byte[] encriptado = cifradorRsa.doFinal(texto.getBytes());
			    //por cada byte guardado, se realiza una conversión hexadecimal
			    for (byte b : encriptado) {
			    	System.out.print(Integer.toHexString(0xFF & b));
			    }
			    //se imprime el texto encriptado (la colección de bytes)
			    System.out.println("\nEl texto encriptado es: "+encriptado.toString());
			    //se desencripta con el mismo método init pero pasando por parámetro la clave privada
			    cifradorRsa.init(Cipher.DECRYPT_MODE, privateKey);
			    //en otro array de bytes, se almacena la información desencriptada
			    byte[] bytesDesencriptados = cifradorRsa.doFinal(encriptado);
			    //se muestra el array de bytes, convirtiéndose a String
			    String textoDesencripado = new String(bytesDesencriptados);
			    //se imprime por pantalla cada línea desencriptada del fichero
			    System.out.println("El texto desencriptado es: "+textoDesencripado);
			}
			//se cierra el BufferedReader
			br.close();
		}catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
		}catch (IOException e2) {
			System.out.println(e2.getMessage());
		}
	}
}
package persistenciafichero;
import java.io.*;

public class Aplicacion {
	static final File fichero=new File("C:\\Users\\jimen\\eclipse-workspace\\DesarrolloInterfaces\\datos.dat");
	public static void main(String[] args) {
		Persona p=new Persona(1,"Robustiano",1);
		insertar(p);
	}
	private static void listarPersonas() {
		DataInputStream dis=null;
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(fichero);
			dis=new DataInputStream(fis);
			while(true) {
				int id=dis.readInt();
				String nombre=dis.readUTF();
				int edad=dis.readInt();
				Persona personaLeida=new Persona(id,nombre,edad);
				System.out.println(personaLeida);
			}
		}catch (EOFException eos) {
			// TODO Auto-generated catch block
			System.out.println("Leidos los Datos");
			eos.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				dis.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	private static void insertar(Persona p) {
		OutputStream oos=null;
		DataOutputStream dos=null;
		try {
			oos=new FileOutputStream(fichero, true);
			dos=new DataOutputStream(oos);
			dos.writeInt(p.getId());
			dos.writeUTF(p.getNombre());
			dos.writeInt(p.getEdad());
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				dos.close();
				oos.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}

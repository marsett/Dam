import java.io.*;
public class Calc{
    public static void main(String[] args){
        Console cons = System.console();
        System.out.println("Introduce el usuario");
        String usuario=cons.readLine();
        System.out.println("El nombre de usuario es "+usuario);
        System.out.println("Introduce la contrasena");
        //String contrasena=cons.readLine();
        int contrasena=Integer.parseInt(cons.readLine());
        //contrasena.equals("1234")
        if(usuario.equalsIgnoreCase("mario") && contrasena==1234){
            System.out.println("Acceso Permitido");
        }
        else{
            System.out.println("Fallo en el acceso");
        }
    }
}
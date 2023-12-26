import java.io.*;
public class Usando_Metodos{
    public static void main(String[] args){
        Console consola=System.console();
        System.out.println("Introduzca un numero");
        String x=consola.readLine();
        System.out.println(x);
    }
}
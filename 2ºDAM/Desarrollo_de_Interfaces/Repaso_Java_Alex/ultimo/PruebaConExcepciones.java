import java.io.*;
public class PruebaConExcepciones{
    public static void main(String[] args){
        int a=introducirNumero();
        int b=introducirNumero();
        System.out.println(a+b);
    }

    public static int introducirNumero(){  
        int numero=0;
        Console cons=System.console();
        System.out.println("Introduce un numero");
        try{  
            numero=Integer.parseInt(cons.readLine());
        }
        catch(NumberFormatException e){
           System.out.println("Pon un numero de una vez, por favor");
           return introducirNumero();
        }
         return numero;    
    }
}
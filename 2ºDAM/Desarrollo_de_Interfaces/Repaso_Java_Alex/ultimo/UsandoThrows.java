import java.io.*;
public class UsandoThrows{
    public static void main(String[] args) throws Exception{
        try{
        FileOutputStream fos;
        fos=new FileOutputStream("c:\\javat\\fichero.txt");
        }
        catch(FileNotFoundException e){
            
        }
    }

    public static void metodoSinThrows() throws Exception{
        System.out.println("metodoSinThrows()");
        metodoConThrows();
    }
    public static void metodoConThrows() throws Exception{
        System.out.println("metodoConThrows()");
        metodoSinThrows();
    }
}
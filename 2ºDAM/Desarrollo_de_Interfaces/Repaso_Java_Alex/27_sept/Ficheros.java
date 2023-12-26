import java.io.*;
public class Ficheros{
    public static void main(String[] args){
        File ficheroDestino=new File(pathname:"c:\\javat\\inventario.xml");
        Properties props=new Properties();
        props.put(key:"valor",value:"value");
        FileOutputStream out=new FileOutputStream();
        props.store(out,"comentario");
        
    }
}
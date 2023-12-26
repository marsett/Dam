public class TestHerenciaInterface{
    public static void main(String[] args){
        //se estan instanciando en la clase hija
        Mascota m1=new Perro();
        m1.decirHola();
        Mascota m2=new Gato();
        m2.decirHola();
        //Connection connection=DriverManager.getConnection(url);
        //try que funciona como un metodo
        try(FileOutputStream fos=new FileOutputStream("c:\\fichero.bin");){
            fos.write(10);
        }
        //evita hacer el fos.close();
        
    }
}
public class Bombero extends Persona{
    String nombreParque;
    int idBombero;
    public Bombero(String nombre,String apellidos){
        super(nombre,apellidos);
    }
    public void conducirCamionBombero(){
        System.out.println("El bombero "+nombre+" conduce el camion");
    }
}
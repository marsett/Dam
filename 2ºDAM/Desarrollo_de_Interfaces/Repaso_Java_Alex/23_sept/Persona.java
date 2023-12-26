public class Persona{
    String nombre;
    String apellidos;
    int edad;
    public Persona(String nombre, String apellidos){
        this(nombre,apellidos,0);
    }
    public Persona(String nombre, String apellidos, int edad){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.edad=edad;
    }
}
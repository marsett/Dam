

// =========== EJEMPLO DB4O  === DEFINICI�N CLASES ============================>>>

 

public class Persona {
 
    private String nombre;
    private int edad;
    private double peso;
    private double altura;
 
    public Persona() {
    }
 
    public Persona(String nombre, int edad, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public int getEdad() {
        return edad;
    }
 
    public void setEdad(int edad) {
        this.edad = edad;
    }
 
    public double getPeso() {
        return peso;
    }
 
    public void setPeso(double peso) {
        this.peso = peso;
    }
 
    public double getAltura() {
        return altura;
    }
 
    public void setAltura(double altura) {
        this.altura = altura;
    }
 
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + ", altura=" + altura + '}';
    }
 
}



// =========== EJEMPLO DB4O  ======= CREAR MAIN ====================================>>>


import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;



// Creamos la conexi�n


ObjectContainer db = Db4oEmbedded.openFile("personas.db4o");


// Creamos los objetos
Persona p1 = new Persona("Fernando", 30, 1.73, 73);
Persona p2 = new Persona("Pepe", 30, 1.75, 80);
Persona p3 = new Persona("Alfredo", 20, 1.9, 90);
Persona p4 = new Persona("Roberto", 35, 1.70, 70);
Persona p5 = new Persona("Domingo", 30, 1.73, 80);


// Guardamos los objetos en la base de datos
db.store(p1);
db.store(p2);
db.store(p3);
db.store(p4);
db.store(p5);

 



// Para filtrar objetos con DB4O necesitamos un objeto de ejemplo para que lo filtre por ello. Vamos a ver varios ejemplos.

// Si quisi�ramos mostrar todos los objetos de una base de datos:


// Todas las personas
Persona p = new Persona();
ObjectSet<Persona> result = db.queryByExample(p);

System.out.println("Todas las personas");
while (result.hasNext()) {
    System.out.println(result.next());
}


// Si queremos filtrar por un atributo en concreto, tendremos que darle valor a ese atributo en concreto:

// Todas las personas con la edad de 30


p = new Persona(null, 30, 0, 0);
result = db.queryByExample(p);
 
System.out.println("Personas con 30 a�os");
while (result.hasNext()) {
    System.out.println(result.next());
}


// Si fuera dos par�metros:   Todas las personas con la edad de 30 y 1.73cm de altura


p = new Persona(null, 30, 1.73, 0);
result = db.queryByExample(p);
 
System.out.println("Personas con 30 a�os y 1.73cm de altura");
while (result.hasNext()) {
    System.out.println(result.next());
}



//  Personas con un nombre concreto:  Todas las personas llamadas Domingo


p = new Persona("Domingo", 0, 0, 0);
result = db.queryByExample(p);
 
System.out.println("Personas llamada Domingo");
while (result.hasNext()) {
    System.out.println(result.next());
}





//  BORRAR Personas con un nombre concreto:  Todas las personas llamadas Pepe


p = new Persona("Pepe", 0, 0, 0);
result = db.delete(p);
 
System.out.println("Borradas Personas llamada Pepe");
while (result.hasNext()) {
    System.out.println(result.next());
}





// IMPORTANTE  Cerramos la base de datos 

db.close();

// =========== EJEMPLO DB4O  ======= CREAR MAIN ====================================>>>




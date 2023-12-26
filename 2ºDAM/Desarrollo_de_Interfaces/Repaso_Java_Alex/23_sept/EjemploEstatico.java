public class EjemploEstatico{
    static int variableNoEstatica=13;
    public static void main(String[] args){
       EjemploEstatico e=new EjemploEstatico();
       e.metodo();
       System.out.println("La variable es "+variableNoEstatica);
       MiClase obj1=new MiClase();
       System.out.println(obj1.numero);
       obj1.numero=13;
       System.out.println(obj1.numero);

       System.out.println(obj1.numeroB);
       obj1.numeroB=15;
       System.out.println(obj1.numeroB);

       MiClase obj2=new MiClase();
       obj2.numeroB=69;
       System.out.println(obj2.numeroB);

       System.out.println(obj1.numeroB);
       obj1.numeroB=666;
       System.out.println(obj1.numeroB);
       System.out.println(obj2.numeroB);
    }

    public void metodo(){
        System.out.println("Mi perro se llama Robustiano");
    }

}
class MiClase{
    public int numero=10;
    public static int numeroB=20;
}
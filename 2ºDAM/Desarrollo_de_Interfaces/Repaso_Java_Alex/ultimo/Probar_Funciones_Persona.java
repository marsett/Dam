public class Probar_Funciones_Persona{
    public static void main(String[] args){
        Acciones ac1=new Artista();
        ac1.cantar();
        ac1.VISUALIZAR_DNI();
        ac1.visualizar_datos();
        Acciones ac2=new Manager();
        ac2.info_manager();
    }
}
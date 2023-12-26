public interface UnaInterface{
    final int CONSTANTE=10;
    
    public abstract void metodo1();
    public void metodo2();

    public default void metodoImplementado(){
        metodoImplementadoPrivado();
    }
    public static void metodoImplementadoEstatico(){
        metodoImplementadoPrivado();
    }
    private void metodoImplementadoPrivado(){

    }
}
    

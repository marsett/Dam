public class ExcepcionPersonalizada{
    public static void main(String[] args){
        try{
        tratarNumero(10);
        tratarNumero(13);
        }
        catch(NoMeGustaElNumeroException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    public static void tratarNumero(int numero) throws NoMeGustaElNumeroException{
        NoMeGustaElNumeroException miError=new NoMeGustaElNumeroException();
        if(numero==13){
            //throw new NoMeGustaElNumeroException();
            throw miError;
        }
        System.out.println("Tratado el numero "+numero);
    }
}
public class ClaseErrorMain{
    public static void main(String[] args){
        try{
            ClaseQueNoSeEnteraDeNada cn=new ClaseQueNoSeEnteraDeNada();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
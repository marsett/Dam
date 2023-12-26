public class UsoExcepciones{
    public static void main(String[] args){
        try{
        String cadena="15.2";
        int numero=Integer.parseInt(cadena);

        int a=10;
        int b=0;
        int c=a/b;

        int[] array=new int[10];
        array[20]=111;
        }
        catch(NumberFormatException e){
            System.out.println("Error al transformar");
        }
        catch(ArithmeticException e2){

        }
        finally{
            
        }

        

    }
}
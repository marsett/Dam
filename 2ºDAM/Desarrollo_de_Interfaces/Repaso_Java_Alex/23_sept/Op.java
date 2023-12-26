public class Op{
    public static void main(String[] args){
        System.out.println("El resultado de la suma es igual a "
        +suma(2,3,4));
    }

    public static int suma(int... a){
        int resultado=0;
        for(int i=0;i<a.length;i++){
            resultado+=a[i];
        }
        return resultado;
    }

}


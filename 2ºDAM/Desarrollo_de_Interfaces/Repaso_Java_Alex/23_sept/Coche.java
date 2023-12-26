class Coche{
    int matricula;
    String modelo;

    public void imprimir(){
        System.out.println("La matricula es "+matricula+" y el modelo es "+modelo);
    }

    public Coche(int matricula, String modelo){
        this.matricula=matricula;
        this.modelo=modelo;
    }
    protected void finalize() throws Throwable{
        System.out.println("Finalizando el Objeto");
        super.finalize();
    }
}



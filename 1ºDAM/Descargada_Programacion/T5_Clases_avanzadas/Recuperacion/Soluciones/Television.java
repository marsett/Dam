package recu;

public class Television extends Electrodomestico{
	private int resolucion = 20;
    
    Television(int resolucion, int peso){
    	this.resolucion = resolucion;
    	setPeso(peso);
    }
    Television(int resolucion, int peso, char cargaEnergetica){
    	this.resolucion = resolucion;
        setPeso(peso);
        setConsumoEnergetico(cargaEnergetica);
    }
 
    public int precioFinal () {
		int plus = super.precioFinal();
		int ret = 0;
		if (resolucion > 40)
			ret =  (int)(plus*1.3);
		else 
		   ret = plus;
		//System.out.println("precioFinal de tv " + ret);
		return ret;

	}
}

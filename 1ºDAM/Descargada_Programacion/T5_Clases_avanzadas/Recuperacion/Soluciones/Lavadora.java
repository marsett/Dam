package recu;

public class Lavadora extends Electrodomestico {
    private int carga = 5;
    
    Lavadora(int carga, int peso){
    	this.carga = carga;
    	setPeso(peso);
    }
    Lavadora(int carga, int peso, char cargaEnergetica){
    	this.carga = carga;
    	setPeso(peso);
    	setConsumoEnergetico(cargaEnergetica);
    }
 
    public int precioFinal () {
		int precio = super.precioFinal();
		if (carga > 30)
			precio += 50;
		//System.out.println("precioFinal de lav " + precio);
		return precio;
		
	}
}


package recu;

public class Electrodomestico {
    private int precioBase = 100;
    private char consumoEnergetico = 'D';
    private int peso = 5;
    public static int numeroElectrodomesticos = 0;
    
    public Electrodomestico() {
    	numeroElectrodomesticos ++;
    }
	
    public void setConsumoEnergetico(char letra) {
    	this.consumoEnergetico = letra;
    }
    public char getConsumoEnergetico() {
    	return this.consumoEnergetico;
    }
    public void setPeso(int peso) {
    	this.peso = peso;
    }
    public int getPeso() {
    	return this.peso;
    }
    public int getPrecioBase() {
    	return this.precioBase;
    }
	public boolean comprobarConsumoEnergetico () {
	 if (consumoEnergetico == 'A' || consumoEnergetico == 'B' || consumoEnergetico == 'C' || consumoEnergetico == 'D') 
		return true;
	 else 
		return false;
	}
	
	public int precioFinal () {
		int plus = (int)(this.peso / 10) * 30;
		//System.out.println("plus de elec " + plus);
		
		switch (consumoEnergetico) {
		case 'A':
			plus += 100;
			break;
		case 'B':
			plus += 80;
			break;
		case 'C':
			plus += 60;
			break;
		case 'D':
			plus += 40;
			break;
		default:
			break;
		}
		//System.out.println("precioFinal de elec " + (this.precioBase + plus));
		return this.precioBase + plus;
	}
}

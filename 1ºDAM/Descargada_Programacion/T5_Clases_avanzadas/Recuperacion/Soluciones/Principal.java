package recu;

public class Principal {
  public static int precioElectrodomesticos = 0;
  
  public static void calcularPrecioTotal(Electrodomestico elec) {
	 if (elec.comprobarConsumoEnergetico()) {
		 precioElectrodomesticos += elec.precioFinal();
	 }
	 else {
		System.out.println("*** Electrodoméstico con "
				+ "consumo energético no aceptado ***");
	 }
	}
	
	public static void main(String[] args) {
	   // Creamos los objetos
		Electrodomestico lista[] = new Electrodomestico[5];
	
		Lavadora lav1 = new Lavadora(60, 30, 'B');
		lista[0] = lav1;
		//100+90+80+50=320
		Television tv1 = new Television(30, 35, 'C');
		lista[1] = tv1;
		//100+90+60=250
		Lavadora lav2 = new Lavadora(45, 30, 'F');
		lista[2] = lav2;
		//0
		Television tv2 = new Television(50, 20, 'A');
		lista[3] = tv2;
		//100+60+100+26+26+26= 338
		Television tv3 = new Television(50, 20, 'E');
		lista[4] = tv3;
		
		for (int i=0; i < 5; i++) {
			calcularPrecioTotal(lista[i]);
		}
		
		System.out.println("Precio de todos los electrodomésticos: "+ precioElectrodomesticos);
		System.out.println("Número de electrodomésticos: "+ Electrodomestico.numeroElectrodomesticos);
		System.out.println("Fin programa.");
	 } //main
		
}

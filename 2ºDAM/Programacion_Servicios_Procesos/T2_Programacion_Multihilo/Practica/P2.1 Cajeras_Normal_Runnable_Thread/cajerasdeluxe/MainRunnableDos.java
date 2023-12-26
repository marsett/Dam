package cajerasdeluxe;

import cajeras.Cajera;
import cajeras.Cliente;

public class MainRunnableDos implements Runnable{
	private Cliente cliente;
	private Cajera cajera;
	private long initialTime;
	
	public MainRunnableDos (Cliente cliente, Cajera cajera, long initialTime){
		this.cajera = cajera;
		this.cliente = cliente;
		this.initialTime = initialTime;
	}

	public static void main(String[] args) {
		//Se ejecutan varios hilos a la vez (implementando Runnable)
		Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
		Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });
		Cliente cliente3 = new Cliente("Cliente 3", new int[] { 3, 1, 2, 3, 7, 2 });
		Cliente cliente4 = new Cliente("Cliente 4", new int[] { 4, 5, 3, 6, 1 });
		Cliente cliente5 = new Cliente("Cliente 5", new int[] { 5, 2, 3, 1, 4, 2 });
		
		Cajera cajera1 = new Cajera("Cajera 1");
		Cajera cajera2 = new Cajera("Cajera 2");
		Cajera cajera3 = new Cajera("Cajera 3");
		Cajera cajera4 = new Cajera("Cajera 4");
		Cajera cajera5 = new Cajera("Cajera 5");
		
		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();
		
		Runnable proceso1 = new MainRunnableDos(cliente1, cajera1, initialTime);
		Runnable proceso2 = new MainRunnableDos(cliente2, cajera2, initialTime);
		Runnable proceso3 = new MainRunnableDos(cliente3, cajera3, initialTime);
		Runnable proceso4 = new MainRunnableDos(cliente4, cajera4, initialTime);
		Runnable proceso5 = new MainRunnableDos(cliente5, cajera5, initialTime);
		
		new Thread(proceso1).start();
		new Thread(proceso2).start();
		new Thread(proceso3).start();
		new Thread(proceso4).start();
		new Thread(proceso5).start();
	}
	@Override
	public void run() {
		this.cajera.procesarCompra(this.cliente, this.initialTime);
	}
}

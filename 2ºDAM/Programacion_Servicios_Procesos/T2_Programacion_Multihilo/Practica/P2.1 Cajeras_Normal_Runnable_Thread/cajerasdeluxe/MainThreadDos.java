package cajerasdeluxe;

import cajeras.Cajera;
import cajeras.Cliente;

class CajeraThread extends Thread {
	private String nombre;
	private Cliente cliente;
	private long initialTime;

	// Constructor, getter & setter
	
	public CajeraThread(String nombre, Cliente cliente, long initialTime) {
		this.nombre=nombre;
		this.cliente=cliente;
		this.initialTime=initialTime;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente=cliente;
	}
	
	public long getInitialTime() {
		return initialTime;
	}
	
	public void setInitialTime(long initialTime) {
		this.initialTime=initialTime;
	}

	@Override
	public void run() {
		Cajera cajera=new Cajera(this.nombre);
		cajera.procesarCompra(this.cliente, this.initialTime);
	}

}

public class MainThreadDos {
	public static void main(String[] args) {
		//Se ejecutan varios hilos a la vez (extendiendo Thread)
		Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
		Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });
		Cliente cliente3 = new Cliente("Cliente 3", new int[] { 4, 1, 3, 6, 2, 7, 8 });
		Cliente cliente4 = new Cliente("Cliente 4", new int[] { 1, 1, 2, 6 });
		Cliente cliente5 = new Cliente("Cliente 5", new int[] { 7, 8, 1, 1, 1 });

		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();
		Thread cajera1 = new CajeraThread("Cajera 1", cliente1, initialTime);
		Thread cajera2 = new CajeraThread("Cajera 2", cliente2, initialTime);
		Thread cajera3 = new CajeraThread("Cajera 3", cliente3, initialTime);
		Thread cajera4 = new CajeraThread("Cajera 4", cliente4, initialTime);
		Thread cajera5 = new CajeraThread("Cajera 5", cliente5, initialTime);
		cajera1.start();
		cajera2.start();
		cajera3.start();
		cajera4.start();
		cajera5.start();
	}
}

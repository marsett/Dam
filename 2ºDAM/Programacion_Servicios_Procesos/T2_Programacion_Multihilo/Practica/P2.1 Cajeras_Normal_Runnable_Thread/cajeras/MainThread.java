package cajeras;

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

public class MainThread {
	public static void main(String[] args) {
		//Se ejecutan varios hilos a la vez (extendiendo Thread)
		Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
		Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });

		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();
		Thread cajera1 = new CajeraThread("Cajera 1", cliente1, initialTime);
		Thread cajera2 = new CajeraThread("Cajera 2", cliente2, initialTime);
		
		cajera1.start();
		cajera2.start();
	}
} 

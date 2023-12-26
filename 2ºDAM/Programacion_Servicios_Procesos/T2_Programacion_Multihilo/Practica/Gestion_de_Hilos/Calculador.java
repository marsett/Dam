package gestionhilos;

public class Calculador implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int num=0;
		while(num<5) {
			System.out.println("Calculando...");
			try {
				long tiempo=(long)(1000*Math.random()*10);
				if(tiempo>8000) {
					Thread hilo=Thread.currentThread();
					System.out.println("Terminando hilo "+hilo.getName());
					hilo.join();
				}
				Thread.sleep(tiempo);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Calculado y Reiniciando");
			num++;
		}
		Thread hilo=Thread.currentThread();
		String miNombre=hilo.getName();
		System.out.println("Hilo terminado: "+miNombre);
	}

}

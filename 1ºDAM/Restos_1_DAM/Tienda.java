package poo;

public class Tienda {
	
	//Atributos
	
	private int camisas;
	private int pantalones;
	
	//Constructores
	
	public Tienda(int camisas, int pantalones) {
		this.camisas = camisas;
		this.pantalones = pantalones;
	}
	
	//Métodos
	
	public int getcamisas() {
		return camisas;
	}
	
	public int getpantalones() {
		return pantalones;
	}
	
	public void addcamisas(int camisas) {
		this.camisas += camisas;
	}
	
	public void addpantalones(int pantalones) {
		this.pantalones += pantalones;
	}
	
	public void remcamisas(int camisas) {
		this.camisas -= camisas;
	}
	
	public void rempantalones(int pantalones) {
		this.pantalones -= pantalones;
	}
	
	public int getstockcamisetas() {
		if(camisas < 5) {
			System.out.println("Es necesario hacer un pedido de camisas");
		}else if(camisas >= 5 && camisas <= 10) {
			System.out.println("Próximamente será necesario hacer un pedido de camisas");
		}else if(camisas > 10) {
			System.out.println("De momento no es necesario hacer pedido de camisas");
		}
		
		return camisas;
	}
	
	public int getstockpantalones() {
		if(pantalones < 5) {
			System.out.println("Es necesario hacer un pedido de camisas");
		}else if(pantalones >= 5 && pantalones <= 10) {
			System.out.println("Próximamente será necesario hacer un pedido de camisas");
		}else if(pantalones > 10) {
			System.out.println("De momento no es necesario hacer pedido de camisas");
		}
		
		return pantalones;
	}

}

package poo;

public class Almacen {
	
		//Atributos
	
		private int papas;
		private int chocos;
		
		
		//Constructor
		
		public Almacen(int papas, int chocos) {
			this.chocos = chocos;
			this.papas= papas;
		}
		
		//Métodos
		
		public int getpapas() {
			return papas;
		}
		
		public int getchocos() {
			return chocos;
		}
		
		public void addpapas(int papas) {
			this.papas+=papas;
		}
		
		public void addchocos(int chocos) {
			this.chocos+=chocos;
		}
		
		public void rempapas(int papas) {
			this.papas-=papas;
		}
		
		public void remchocos(int chocos) {
			this.chocos-=chocos;
		}
		
		public int getcomensales() {
			int comensales;
			if(getchocos() < getpapas()) {
				comensales = getchocos() * 4;
			}else {
				comensales = getpapas() * 4;
			}
			return comensales;
		}
}

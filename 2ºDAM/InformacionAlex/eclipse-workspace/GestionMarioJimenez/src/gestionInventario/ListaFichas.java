package gestionInventario;
import java.util.ArrayList;

public class ListaFichas {
	private static ArrayList<FichasInventario> lista=new ArrayList<>();
		public void insertarFicha(FichasInventario ficha) {
			lista.add(ficha);
		}
		public ArrayList<FichasInventario>getLista(){
			return lista;
		}
		public void setLista(ArrayList<FichasInventario>lista) {
			this.lista=lista;
		}
}

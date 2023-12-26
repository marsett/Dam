package gestionInventario;

import java.util.ArrayList;

public class ArrayArticulos {
	Articulo articulo1=new Articulo(1,"silla","Ikea","modelo 3345","mueble","referencia1");
	Articulo articulo2=new Articulo(2,"mesa","Ikea","modelo 234","mueble","referencia2");
	Articulo articulo3=new Articulo(3,"ordenador","Lenovo","modelo 456","material electronico","referencia3");
	Articulo articulo4=new Articulo(4,"television","LG","modelo 987","material electronico","referencia4");
	Articulo articulo5=new Articulo(5,"impresora","HP","modelo 123","material electronico","referencia5");
	private static ArrayList<Articulo> lista=new ArrayList<>();
	public void insertarArticulo(Articulo articulo) {
		lista.add(articulo);
	}
	public ArrayList<Articulo>getLista(){
		return lista;
	}
	public void setLista(ArrayList<Articulo>lista) {
		this.lista=lista;
	}
	public void inserta() {
		insertarArticulo(articulo1);
		insertarArticulo(articulo2);
		insertarArticulo(articulo3);
		insertarArticulo(articulo4);
		insertarArticulo(articulo5);
	}
	
}

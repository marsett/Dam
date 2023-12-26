package poo;

public class Parque {
    private int personasRestantes;
    private int chanclasAlmacen;
    private int souvenirsAlmacen;

    private int personasOriginal;
    private int chanclasOriginal;

    public Parque(int personas, int chanclas, int souvenirs) {
	personasRestantes = personas;
	chanclasAlmacen = chanclas;
	souvenirsAlmacen = souvenirs;

	personasOriginal = personas;
	chanclasOriginal = chanclas;
    }

    public int getChanclasAlmacen() {
	return chanclasAlmacen;
    }

    public int getSouvenirsAlmacen() {
	return souvenirsAlmacen;
    }

    public void vendeEntradas(int entradas, int ofertaChanclas) {
	remEntradas(entradas);
	remChanclas(entradas * ofertaChanclas); // promoción
    }

    public void remEntradas(int entradas) {
	personasRestantes -= entradas;
    }

    public void vendeChanclas(int chanclas, int ofertaSouvenir) {
	remChanclas(chanclas);
	remSouvenirs(chanclas * ofertaSouvenir); // promoción
    }

    public void remChanclas(int chanclas) {
	chanclasAlmacen -= chanclas;
    }

    public void vendeSouvenirs(int souvenirs, int ofertaSouvenir) {
	remSouvenirs(souvenirs * ofertaSouvenir); // promoción
    }

    public void remSouvenirs(int souvenirs) {
	souvenirsAlmacen -= souvenirs;
    }

    public int getChanclasVendidas() {
	return (chanclasOriginal - chanclasAlmacen);
    }

    public int getPersonasParque() {
	return (personasOriginal - personasRestantes);
    }

}

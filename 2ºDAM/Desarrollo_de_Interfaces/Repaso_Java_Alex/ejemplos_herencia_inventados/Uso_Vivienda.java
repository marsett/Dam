public class Uso_Vivienda{
	public static void main(String[] args) {

		Vivienda[] viviendas=new Vivienda[2];
		viviendas[0]=new Piso(340000,459,"Alvaro Morata","Piso 1","Madrid",true,true);
		viviendas[1]=new Apartamento("Apartamento 1",120000,160,"Barcelona");

		for(Vivienda v: viviendas) {
			System.out.println(v.dameDescripcion());
			v.subeValor(7);
		}

		Piso p=new Piso(280000,378,"Koke Resurreccion","Piso 2","Madrid",true,true);
		p.metodoabstracto();
		Piso.metodoestatico();

	}
}



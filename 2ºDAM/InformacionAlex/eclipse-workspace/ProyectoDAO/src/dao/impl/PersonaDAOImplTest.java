package dao.impl;

import java.util.ArrayList;

import dao.PersonaDAO;
import modelo.Persona;

public class PersonaDAOImplTest implements PersonaDAO{
	static ArrayList<Persona>listaPersonas;
	//la base de datos sera un arraylist como prueba
	public PersonaDAOImplTest() {
		listaPersonas=new ArrayList<>();
	}
	@Override
	public Persona insertar(Persona persona) {
		// TODO Auto-generated method stub
		listaPersonas.add(persona);
		int id= listaPersonas.size();
		persona.setId(id);
		return persona;
	}

	@Override
	public void modificar(Persona p) {
		// TODO Auto-generated method stub
		//borrar(id);
		insertar(p);
	}

	@Override
	public boolean borrar(int id) {
		// TODO Auto-generated method stub
		boolean retorno=false;
		for(Persona p: listaPersonas) {
			if(p.getId()==id) {
				retorno=listaPersonas.remove(p);
			}
		}
		return retorno;
	}

	@Override
	public ArrayList<Persona> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Persona> getPersonaByGenero(String genero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona getPersonaById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

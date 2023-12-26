package dao;
import java.util.ArrayList;

import modelo.Persona;

public interface PersonaDAO {
	public Persona insertar(Persona persona);
	public void modificar(Persona p);
	public boolean borrar(int id);
	public ArrayList<Persona>getAll();
	public ArrayList<Persona>getPersonaByGenero(String genero);
	public Persona getPersonaById(int id);
}

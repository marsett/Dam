package perros;

public class PerrosCallejeros {
	private String nombre;
	private String color;
	private long id;
	public PerrosCallejeros(String nombre, String color) {
		this.nombre = nombre;
		this.color = color;
	}
	public PerrosCallejeros(long id, String nombre, String color) {
		this.id=id;
		this.nombre = nombre;
		this.color = color;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public String getColor() {
		return color;
	}
	public void setRaza(String color) {
		this.color = color;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}

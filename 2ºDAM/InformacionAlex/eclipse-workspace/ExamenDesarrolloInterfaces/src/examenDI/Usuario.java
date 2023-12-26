package examenDI;

public class Usuario {
	private String nombre, apellidos;
	private boolean matriculado;
	private String provincia, localidad;
	
	public Usuario() {
		
	}
	public Usuario(String nombre, String apellidos, boolean matriculado, String provincia, String localidad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.matriculado = matriculado;
		this.provincia = provincia;
		this.localidad = localidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public boolean isMatriculado() {
		return matriculado;
	}
	public void setMatriculado(boolean matriculado) {
		this.matriculado = matriculado;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellidos=" + apellidos + ", matriculado=" + matriculado
				+ ", provincia=" + provincia + ", localidad=" + localidad + "]";
	}
}

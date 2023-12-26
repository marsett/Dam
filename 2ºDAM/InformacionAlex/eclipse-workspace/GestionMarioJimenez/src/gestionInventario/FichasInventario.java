package gestionInventario;

public class FichasInventario {
	private int codigoArticulo;
	private String fechaFichaInventario;
	private double precioFichaInventario;
	private String ubicacionFichaInventario;
	private int codigoFichaInventario;
	static int contador=1;
	public FichasInventario() {
		
	}
	public FichasInventario(int codigoArticulo) {
		super();
		this.codigoArticulo = codigoArticulo;
	}
	public FichasInventario(int codigoArticulo, String fechaFichaInventario, double precioFichaInventario,
			String ubicacionFichaInventario) {
		super();
		this.codigoArticulo = codigoArticulo;
		this.fechaFichaInventario = fechaFichaInventario;
		this.precioFichaInventario = precioFichaInventario;
		this.ubicacionFichaInventario = ubicacionFichaInventario;
		this.codigoFichaInventario =contador;
		contador++;
	}
	public int getCodigoArticulo() {
		return codigoArticulo;
	}
	public void setCodigoArticulo(int codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	public String getFechaFichaInventario() {
		return fechaFichaInventario;
	}
	public void setFechaFichaInventario(String fechaFichaInventario) {
		this.fechaFichaInventario = fechaFichaInventario;
	}
	public double getPrecioFichaInventario() {
		return precioFichaInventario;
	}
	public void setPrecioFichaInventario(double precioFichaInventario) {
		this.precioFichaInventario = precioFichaInventario;
	}
	public String getUbicacionFichaInventario() {
		return ubicacionFichaInventario;
	}
	public void setUbicacionFichaInventario(String ubicacionFichaInventario) {
		this.ubicacionFichaInventario = ubicacionFichaInventario;
	}
	public int getCodigoFichaInventario() {
		return codigoFichaInventario;
	}
	public void setCodigoFichaInventario(int codigoFichaInventario) {
		this.codigoFichaInventario = codigoFichaInventario;
	}
	@Override
	public String toString() {
		return "FichasInventario [codigoArticulo=" + codigoArticulo + ", fechaFichaInventario=" + fechaFichaInventario
				+ ", precioFichaInventario=" + precioFichaInventario + ", ubicacionFichaInventario="
				+ ubicacionFichaInventario + ", codigoFichaInventario="
						+ codigoFichaInventario + "]";
	}
}

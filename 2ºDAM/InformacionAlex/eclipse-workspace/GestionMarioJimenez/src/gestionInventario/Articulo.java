package gestionInventario;

public class Articulo {
	private int codigoArticulo;
	private String descripcionArticulo;
	private String marcaArticulo;
	private String modeloArticulo;
	private String tipoArticulo;
	private String referenciaArticulo;
	public Articulo() {
		
	}
	public Articulo(int codigoArticulo) {
		super();
		this.codigoArticulo = codigoArticulo;
	}
	public Articulo(int codigoArticulo, String descripcionArticulo, String marcaArticulo, String modeloArticulo,
			String tipoArticulo, String referenciaArticulo) {
		super();
		this.codigoArticulo = codigoArticulo;
		this.descripcionArticulo = descripcionArticulo;
		this.marcaArticulo = marcaArticulo;
		this.modeloArticulo = modeloArticulo;
		this.tipoArticulo = tipoArticulo;
		this.referenciaArticulo = referenciaArticulo;
	}
	public int getCodigoArticulo() {
		return codigoArticulo;
	}
	public void setCodigoArticulo(int codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}
	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}
	public String getMarcaArticulo() {
		return marcaArticulo;
	}
	public void setMarcaArticulo(String marcaArticulo) {
		this.marcaArticulo = marcaArticulo;
	}
	public String getModeloArticulo() {
		return modeloArticulo;
	}
	public void setModeloArticulo(String modeloArticulo) {
		this.modeloArticulo = modeloArticulo;
	}
	public String getTipoArticulo() {
		return tipoArticulo;
	}
	public void setTipoArticulo(String tipoArticulo) {
		this.tipoArticulo = tipoArticulo;
	}
	public String getReferenciaArticulo() {
		return referenciaArticulo;
	}
	public void setReferenciaArticulo(String referenciaArticulo) {
		this.referenciaArticulo = referenciaArticulo;
	}
	@Override
	public String toString() {
		return "Articulo [codigoArticulo=" + codigoArticulo + ", descripcionArticulo=" + descripcionArticulo
				+ ", marcaArticulo=" + marcaArticulo + ", modeloArticulo=" + modeloArticulo + ", tipoArticulo="
				+ tipoArticulo + ", referenciaArticulo=" + referenciaArticulo + "]";
	}
}

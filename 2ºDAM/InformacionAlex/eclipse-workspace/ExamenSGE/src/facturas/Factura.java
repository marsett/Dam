package facturas;

public class Factura {
	private int numFactura;
	private String fechaEmision;
	private String nombreCliente;
	private String concepto;
	private double baseImponible;
	private int tipoIva;
	private double importeTotal;
	public Factura() {
		
	}
	public Factura(int numFactura) {
		super();
		this.numFactura = numFactura;
	}
	public Factura(int numFactura, String fechaEmision, String nombreCliente, String concepto, double baseImponible,
			int tipoIva, double importeTotal) {
		super();
		this.numFactura = numFactura;
		this.fechaEmision = fechaEmision;
		this.nombreCliente = nombreCliente;
		this.concepto = concepto;
		this.baseImponible = baseImponible;
		this.tipoIva = tipoIva;
		this.importeTotal = importeTotal;
	}
	public int getNumFactura() {
		return numFactura;
	}
	public void setNumFactura(int numFactura) {
		this.numFactura = numFactura;
	}
	public String getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public double getBaseImponible() {
		return baseImponible;
	}
	public void setBaseImponible(double baseImponible) {
		this.baseImponible = baseImponible;
	}
	public int getTipoIva() {
		return tipoIva;
	}
	public void setTipoIva(int tipoIva) {
		this.tipoIva = tipoIva;
	}
	public double getImporteTotal() {
		return importeTotal;
	}
	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}
	@Override
	public String toString() {
		return "Factura [numFactura=" + numFactura + ", fechaEmision=" + fechaEmision + ", nombreCliente="
				+ nombreCliente + ", concepto=" + concepto + ", baseImponible=" + baseImponible + ", tipoIva=" + tipoIva
				+ ", importeTotal=" + importeTotal + "]";
	}
	
}

package ejercicio3;

public class Factura extends DocumentoConFecha {
	private double costo;
	
	public Factura(double costo, int dia, int mes, String doctor) {
		super(dia,mes,doctor);
		this.costo = costo;
	}
	public Factura(double costo, Fecha fecha, String doctor) {
		super(fecha,"Doctor: "+doctor);
		this.costo = costo;
	}
	
	@Override
	public String toString() {
		return "Factura: Costo " + costo + "\n\t"+ super.leer()+"\n";
	}
}

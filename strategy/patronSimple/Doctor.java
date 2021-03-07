package strategy;

public interface Doctor {
	String examinar(String nino);
	void enviarResultado(String resultado);
	void factura();
}

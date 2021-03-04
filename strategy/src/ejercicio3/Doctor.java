package ejercicio3;

public interface Doctor {
	Resultado examinar();
	void resultado(Resultado resultado) throws ErrorFormato;
	void factura() throws ErrorFormato;
	void setIO(EntradaSalida io);
}

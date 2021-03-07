package ejercicio3;

import java.io.IOException;

public interface EntradaSalida {
	String input() throws IOException;
	void output(DocumentoConFecha obj) throws ErrorFormato;
}

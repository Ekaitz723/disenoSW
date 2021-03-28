package DecoratorPatron;

import java.util.ArrayList;
import java.util.List;

public class NinoVanilla implements Nino {
	private List<String> libros;
	
	public NinoVanilla() {
		libros = new ArrayList<String>();
	}
	
	@Override
	public String leerPremios() {
		return "";
	}

	@Override
	public void darLibro(String libro) {
		libros.add(libro);
	}

	@Override
	public String leerLibros() {
		return ""+libros;
	}
	
	@Override
	public String toString() {
		return leerPremios()+"\n"+leerLibros();
	}
}

package ejercicio3;

public class Documento {
	protected String texto;
	
	public Documento(String texto) {
		this.texto = texto;
	}
	
	public Documento(Documento doc) {
		this.texto = doc.getTexto();
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getTexto() {
		return texto;
	}

	@Override
	public String toString() {
		return texto;
	}
}

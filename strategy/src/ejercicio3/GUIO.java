package ejercicio3;

public class GUIO implements EntradaSalida {
	private GUIDoctores output;
	private static GUIO instancia = new GUIO();
	
	private GUIO() {
		this.output = GUIDoctores.instancia();
	}
	
	public static GUIO instancia() {
		if(instancia==null)
			instancia = new GUIO();
		return instancia;
	}
	
	public static void instanciaFlush() {
		if(instancia!=null)
			instancia = null;
	}
	
	@Override
	public String input() {
		return output.getTaText();
	}

	@Override
	public void output(DocumentoConFecha obj) {
		output.appendTaText(""+obj);
	}
}

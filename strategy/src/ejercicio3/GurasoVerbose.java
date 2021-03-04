package ejercicio3;

public class GurasoVerbose extends Guraso {
	private static GUIO output = GUIO.instancia();
	
	public GurasoVerbose(int id) {
		super(id);
	}
	
	@Override
	public void output(DocumentoConFecha obj) throws ErrorFormato {
		super.output(obj);
		String copiaTexto = obj.getTexto();
		obj.setTexto("ID: "+id+"\n\t"+copiaTexto);
		output.output(obj);
		obj.setTexto(copiaTexto);
	}
}

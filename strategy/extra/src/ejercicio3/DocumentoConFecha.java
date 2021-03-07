package ejercicio3;

public abstract class DocumentoConFecha extends Documento implements DocumentoEntregable, Fechable {
	protected Fecha fecha;
	
	public DocumentoConFecha(int dia, int mes, String texto) {
		super(texto);
		fecha = new Fecha(dia, mes);
	}
	public DocumentoConFecha(Documento doc, int dia, int mes) {
		super(doc);
		fecha = new Fecha(dia, mes);
	}
	public DocumentoConFecha(Fecha fecha, String texto) {
		super(texto);
		this.fecha = fecha;
	}
	
	public DocumentoConFecha(Documento doc, Fecha fecha) {
		super(doc);
		this.fecha = fecha;
	}
	/*public DocumentoConFecha(DocumentoConFecha docf) {
		super(docf);
		this.fecha = new Fecha(docf.getFecha());
	}*/
	
	@Override
	public String getTexto() {
		return super.getTexto();
	}
	@Override
	public void setTexto(String texto) {
		super.setTexto(texto);
	}
	@Override
	public Fecha getFecha() {
		return fecha;
	}
	
	public String leer() {
		return "Fecha: "+fecha+"\n\t"+texto;
	}
}

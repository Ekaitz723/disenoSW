package ejercicio3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class Guraso implements EntradaSalida {
	private List<DocumentoConFecha> documentos;
	protected int id;
	
	public Guraso(int id) {
		documentos = new ArrayList<DocumentoConFecha>();
		this.id = id;
	}
	
	private static PrintWriter abrir(String nombre) throws IOException {
		/*File datosAbrir = new File("Guraso.txt");
		if (!datosAbrir.exists())
			datosAbrir.createNewFile();
		PrintWriter datos = new PrintWriter(new FileWriter("Guraso.txt",true));
		return datos;*/
		File datosAbrir = new File(nombre);
		if(!datosAbrir.exists()) {
			//datosAbrir.createNewFile();
		}
		PrintWriter datos = new PrintWriter(new FileWriter(datosAbrir));
		return datos;
	}
	@Override
	public String toString() {
		String texto = "Documentos:\n";
		for(DocumentoConFecha d: documentos) {
			texto+=d;
		}
		return texto+"\n";
	}
	public int getId() {
		return id;
	}

	@Override
	public String input() throws IOException {
		String input = "Id: "+id+"\n"+this+"\n";
		
		//Pasar a fichero.
		PrintWriter pw = abrir("documentosGuraso/Guraso"+id+".txt");
		pw.write(input);
		pw.close();
		return input;
	}
	
	@Override
	public void output(DocumentoConFecha obj) throws ErrorFormato {
		if(!(obj instanceof DocumentoEntregable))
			throw new ErrorFormato("No se puede entregar "+ obj.getClass() + " a " + this.getClass()+"\n");
		if(PruebaDoctores.getFecha().getMes()!=((DocumentoConFecha)obj).getFecha().getMes() && PruebaDoctores.getFecha().getDia() >=((DocumentoConFecha)obj).getFecha().getDia())
			throw new ErrorCaducado(new ErrorFormato("Documento caducado"));
		
		documentos.add(obj);
	}
}

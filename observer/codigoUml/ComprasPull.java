package observer.corregido.corregidoUtil;

import java.util.Observable;
import java.util.Observer;
@SuppressWarnings("deprecation")

public class ComprasPull implements Observer{
	private Observable o;
	
	//Sin constructor nulo. Se le pasa un Observable por composicion.
	public ComprasPull(Observable o) {
		this.o = o;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println(((Biblioteca)this.o).getAlarmaLibro()+" (ComprasPull)");
	}
}
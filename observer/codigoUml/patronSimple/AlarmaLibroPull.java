package observer;

import java.util.Observable;
import java.util.Observer;
@SuppressWarnings("deprecation")

public class AlarmaLibroPull extends Observable implements Observer{
	private Observable o;
	
	//Sin constructor nulo. Se le pasa un Observable por composicion.
	public AlarmaLibroPull(Observable o) {
		this.o = o;
	}
	
	public Biblioteca getBiblioteca() {
		return (Biblioteca)o;
	}
	public String alarma() {
		return " (AlarmaLibroPull.";
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.print("\n"+getBiblioteca().getEstadoLibro());
		if(!((EstadoLibro)arg).getEstado()) {
			setChanged();
			notifyObservers();
			clearChanged();
		}
		
	}
}
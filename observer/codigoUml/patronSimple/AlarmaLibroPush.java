package observer;

import java.util.Observable;
import java.util.Observer;
@SuppressWarnings("deprecation")

public class AlarmaLibroPush extends Observable implements Observer{
	
	//Constructor por defecto.
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.print("\n"+((Biblioteca) o).getEstadoLibro());
		if(!((EstadoLibro)arg).getEstado()) {
			setChanged();
			notifyObservers(o);
			clearChanged();
		}
	}
}
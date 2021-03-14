package observer;

import java.util.Observable;
import java.util.Observer;
@SuppressWarnings("deprecation")

public class StockPull implements Observer{
	private Observable o;
	
	//Sin constructor nulo. Se le pasa un Observable por composicion.
	public StockPull(Observable o) {
		this.o = o;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.print(((AlarmaLibroPull)this.o).alarma()+"StockPull)");
	}
}
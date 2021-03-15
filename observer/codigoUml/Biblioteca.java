package observer.corregido.corregidoUtil;

import java.util.Observable;
@SuppressWarnings("deprecation")

public class Biblioteca extends Observable{
	//Existe lista de Observers.
	private AlarmaLibro alarmaLibro;
	
	//Existe addObserver(Observer observer).
	//Existe deleteObserver(Observer observer).
	//Existe notifyObservers(Object arg)
	//	aunque me parece un desperdicio de tiempo de ejecucion
	//	tener que pasar this y un objeto aunque se implemente
	//	mediante el modelo pull.
	
	public AlarmaLibro getAlarmaLibro() {
		return alarmaLibro;
	}
	public void devuelveLibro(AlarmaLibro s) {
		alarmaLibro = s;
		if(!alarmaLibro.getEstado()) {
			setChanged();
			notifyObservers(alarmaLibro);
			clearChanged();
		}
		else {
			System.out.println(alarmaLibro);
		}
	}
	public void devuelveLibro(String s) {
		devuelveLibro(new AlarmaLibro(s));
	}
	public void devuelveLibro(String s, boolean e) {
		devuelveLibro(new AlarmaLibro(s,e));
	}
}

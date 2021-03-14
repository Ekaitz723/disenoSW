package observer;

import java.util.Observable;
@SuppressWarnings("deprecation")

public class Biblioteca extends Observable{
	//Existe lista de Observers.
	private EstadoLibro estadoLibro;
	
	//Existe addObserver(Observer observer).
	//Existe deleteObserver(Observer observer).
	//Existe notifyObservers(Object arg)
	//	aunque me parece un desperdicio de tiempo de ejecucion
	//	tener que pasar this y un objeto aunque se implemente
	//	mediante el modelo pull.
	
	public EstadoLibro getEstadoLibro() {
		return estadoLibro;
	}
	public void devuelveLibro(EstadoLibro s) {
		estadoLibro = s;
		setChanged();
		notifyObservers(estadoLibro);
		clearChanged();
	}
	public void devuelveLibro(String s) {
		devuelveLibro(new EstadoLibro(s));
	}
	public void devuelveLibro(String s, boolean e) {
		devuelveLibro(new EstadoLibro(s,e));
	}
}

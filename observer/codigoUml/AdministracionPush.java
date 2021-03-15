package observer.corregido.corregidoUtil;

import java.util.Observable;
import java.util.Observer;
@SuppressWarnings("deprecation")

public class AdministracionPush implements Observer{
	
	//Constructor por defecto.
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println(((AlarmaLibro)arg)+" (AdministracionPush)");
	}
}
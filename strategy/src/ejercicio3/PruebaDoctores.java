package ejercicio3;

import java.io.IOException;

public abstract class PruebaDoctores {
	private static Fecha fecha;
	private static final String path = "Guraso";
	
	//Estan puestos a mano, por lo que mejor no cambiarlo a menos de que introduzcas otro a mano o implementes hacerlo mediante consola o GUI.
	//Este ejercicio es para practicar los patrones, por lo que lo voy a dejar asi.
	private static final int cantidadDoctores = 2;
	
	public static Fecha getFecha() {
		//Innecesario en el caso de usar Consola como EntradaSalida.
		return new Fecha(fecha);
	}
	public static String getPath() {
		return path;
	}
	
	public static void main(int dias, int cantidadNinos, boolean porConsola, boolean verbose) {
		EntradaSalida io[] = null;
		EntradaSalida tmp = null;
		
		//Solo estan por array de todos de un mismo tipo, pero se pueden convinar y funcionaria perfectamente, ahora bien, que tenga sentido... eso ya no.
		if(!porConsola) {
			io = new EntradaSalida[cantidadNinos];
			for(int i=0;i<cantidadNinos;i++)
				io[i] = (verbose?new GurasoVerbose(i):new Guraso(i));
		}
		
		Doctor doctores[] = new Doctor[cantidadDoctores];
		doctores[0] = new TrabajaDia15(new Oculista("Wang"));
		doctores[1] = new TrabajaDia28(new Logopeda("Fong"));
		
		fecha = new Fecha();
		int iteraciones;
		int ninos;
		
		try {
			for(iteraciones = dias;iteraciones>0;iteraciones--) {
				for(ninos=0;ninos<cantidadNinos;ninos++) {
					
					//Por consola, todos los ninos usan una misma consola. Se diferencian por el orden por el que aparecen.
					//En el resto, cada nino usa su guraso como io.
					tmp = (porConsola?GUIO.instancia():io[ninos]);
					
					for(Doctor d: doctores) {
						d.setIO(tmp);
						d.resultado(d.examinar());
						d.factura();
					}
				}
				fecha.sigDia();
				//if(fecha.sigDia())
					//en caso de necesitar comprobar cuando cambia de mes, descomentar. (y comentar fecha.sigDia();).
			}
		} catch (ErrorFormato e) {
			e.printStackTrace();
		}
		if(!porConsola)
			try {
				for(EntradaSalida es: io)
					es.input();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}

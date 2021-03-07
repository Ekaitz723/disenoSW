package ejercicio3;

public class Oculista extends DoctorIO {
	
	public Oculista() {
		super();
	}
	public Oculista(String nombre) {
		super(nombre);
	}
	public Oculista(EntradaSalida io, String nombre) {
		super(io,nombre);
	}
	
	@Override
	public Resultado examinar() {
		int res = (int) (Math.floor(Math.random()*4));
		return new Resultado(pruebaRealizadaPor()+(res!=0?"Ve bien":"Ta ciego :("),res!=0,PruebaDoctores.getFecha());
	}

	@Override
	public void factura() throws ErrorFormato {
		io.output(new Factura(Math.random()*15 + 5, PruebaDoctores.getFecha(), nombre));
	}

	@Override
	public void resultado(Resultado resultado) throws ErrorFormato {
		io.output(resultado);
	}
	
	@Override
	public void revision() throws ErrorFormato {
		resultado(examinar());
		factura();
	}
}

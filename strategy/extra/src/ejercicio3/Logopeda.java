package ejercicio3;

public class Logopeda extends DoctorIO {

	public Logopeda() {
		super();
	}
	public Logopeda(String nombre) {
		super(nombre);
	}
	public Logopeda(EntradaSalida io, String nombre) {
		super(io,nombre);
	}
	@Override
	public Resultado examinar() {
		int res = (int) (Math.floor(Math.random()*4));
		return new Resultado(pruebaRealizadaPor()+(res!=0?"Habla bien":"Tiene problemas del habla"),res!=0,PruebaDoctores.getFecha());
	}

	@Override
	public void resultado(Resultado resultado) throws ErrorFormato {
		io.output(resultado);
	}

	@Override
	public void factura() throws ErrorFormato {
		io.output(new Factura(Math.random()*20 + 5, PruebaDoctores.getFecha(), nombre));
	}
	
	@Override
	public void revision() throws ErrorFormato {
		resultado(examinar());
		factura();
	}
}
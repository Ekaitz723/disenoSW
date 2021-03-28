package DecoratorPatron;

public class NinoSemana extends Premiado {
	
	public NinoSemana(Nino n) {
		super(n);
	}
	
	@Override
	public String leerPremios() {
		return super.leerPremios()+"NinoSemana"+"\n";
	}
}

package DecoratorPatron;

public class Pegatinado extends Premiado {
	
	public Pegatinado(Nino n) {
		super(n);
	}
	
	@Override
	public String leerPremios() {
		return super.leerPremios()+"Pegatinado"+"\n";
	}
}

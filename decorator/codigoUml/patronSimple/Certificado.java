package DecoratorPatron;

public class Certificado extends Premiado {

	public Certificado(Nino n) {
		super(n);
	}

	@Override
	public String leerPremios() {
		return super.leerPremios() + "Certificado"+"\n";
	}
}

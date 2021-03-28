package DecoratorPatron;

public class NinoSemanaSingleton extends Premiado {

	private static Nino instance = null;
	
	public static Nino setNinoSemana(Nino n) {
		if(instance==null || !(instance instanceof NinoSemanaSingleton))
			instance = new NinoSemanaSingleton(n);
		((NinoDecorator)instance).setNino(n);
		return instance;
	}
	
	public static Nino getNinoSemana() {
		return instance;
	}
	
	private NinoSemanaSingleton(Nino n) {
		super(n);
	}
	
	@Override
	public String leerPremios() {
		return super.leerPremios()+"El niño de la semana";
	}
	
	@Override
	public void darLibro(String libro) {
		super.darLibro(libro);
	}
}

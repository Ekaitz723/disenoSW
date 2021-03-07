package strategy;

public class Logopeda implements Doctor {

	@Override
	public String examinar(String nino) {
		return nino+" examinado por el logopeda";
	}

	@Override
	public void enviarResultado(String resultado) {
		System.out.println("Enviando resultado:"+resultado);
	}

	@Override
	public void factura() {
		System.out.println("Enviando factura");
	}
	
}

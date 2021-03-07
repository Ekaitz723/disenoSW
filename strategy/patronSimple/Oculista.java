package strategy;

public class Oculista implements Doctor {
	
	@Override
	public String examinar(String nino) {
		return nino+" examinado por el oculista";
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

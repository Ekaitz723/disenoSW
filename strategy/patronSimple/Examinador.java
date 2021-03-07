package strategy;

public class Examinador {
	private Doctor doctor;
	
	public Examinador(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public String examinar(String nino) {
		return doctor.examinar(nino);
	}

	public void enviarResultado(String resultado) {
		doctor.enviarResultado(resultado);
	}

	public void factura() {
		doctor.factura();
	}
}

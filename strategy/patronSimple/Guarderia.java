package strategy;

public class Guarderia {
	public static void main(String[] args) {
		Examinador exam = new Examinador(new Oculista());
		exam.enviarResultado(exam.examinar("Paco"));
		exam.factura();
		
		exam = new Examinador(new Logopeda());
		exam.enviarResultado(exam.examinar("Yeray"));
		exam.factura();
	}
}

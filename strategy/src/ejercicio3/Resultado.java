package ejercicio3;

public class Resultado extends DocumentoConFecha {
	private boolean evaluacion;
	
	public Resultado(String resultado, boolean evaluacion, int dia, int mes) {
		super(dia,mes,resultado);
		this.evaluacion = evaluacion;
	}
	public Resultado(String resultado, boolean evaluacion, Fecha fecha) {
		super(fecha,resultado);
		this.evaluacion = evaluacion;
	}
	
	@Override
	public String toString() {
		return "Resultado "+ super.leer() + "\n\tEvaluacion: " + (evaluacion?"Correcto":"Mal")+"\n";
	}
}

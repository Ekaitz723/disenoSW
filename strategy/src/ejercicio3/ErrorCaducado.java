package ejercicio3;

public class ErrorCaducado extends ErrorFormato {
	private static final long serialVersionUID = 1L;
	protected Exception errorFormato;
	
	public ErrorCaducado(ErrorFormato error) {
		super(error.getMessage());
		errorFormato = error;
	}
}
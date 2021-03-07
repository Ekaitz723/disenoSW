package ejercicio3;

public class ErrorFormato extends Exception {
	private static final long serialVersionUID = 1L;
	private String errorMensaje;
	
	public ErrorFormato(String error){
		errorMensaje = error;
	}
	@Override
	public String getMessage() {
		return errorMensaje;
	}
}

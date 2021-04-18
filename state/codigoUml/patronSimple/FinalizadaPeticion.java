package StatePatronBien;

public class FinalizadaPeticion implements PeticionState, PeticionTransicionesEstado{
	private PeticionLibro peticionLibro;
	
	public FinalizadaPeticion(PeticionLibro peticionLibro) {
		this.peticionLibro = peticionLibro;
	}
	
	@Override
	public PeticionLibro getPeticion() {
		return peticionLibro;
	}
	
	@Override
	public void process() {
		//Se termino, no hace nada.
	}
}

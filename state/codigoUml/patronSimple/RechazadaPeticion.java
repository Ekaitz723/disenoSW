package StatePatronBien;

public class RechazadaPeticion implements PeticionState, PeticionTransicionesEstado{
	private PeticionLibro peticionLibro;
	
	public RechazadaPeticion(PeticionLibro peticionLibro) {
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

package StatePatronBien;

public class CursadaPeticion implements PeticionState, PeticionTransicionesEstado{
	private PeticionLibro peticionLibro;
	
	public CursadaPeticion(PeticionLibro peticionLibro) {
		this.peticionLibro = peticionLibro;
	}
	
	@Override
	public PeticionLibro getPeticion() {
		return peticionLibro;
	}
	
	@Override
	public void process() {
		//Si se devuelve tarde, se considerara que el libro esta en mal estado.
		if(peticionLibro.isCaducado())
			peticionLibro.getLibro().setEstadoLibro(EstadoLibro.MAAAAAL);
		devolverPeticion();
	}

	@Override
	public void devolverPeticion() {
		peticionLibro.setFechaCaducidad(null);
		peticionLibro.setEstadoActual(Estados.FINALIZADA);
	}
}

package StatePatronBien;

import java.time.LocalDate;

public class CreadaPeticion implements PeticionState, PeticionTransicionesEstado{
	private PeticionLibro peticionLibro;
	
	public CreadaPeticion(PeticionLibro peticionLibro) {
		this.peticionLibro = peticionLibro;
	}
	
	@Override
	public PeticionLibro getPeticion() {
		return peticionLibro;
	}
	
	@Override
	public void process() {
		if(peticionLibro.getCuentaUsuario().isActiva())
			admitirPeticion();
		else
			rechazarPeticion();
	}

	@Override
	public void admitirPeticion() {
		peticionLibro.setFechaCaducidad(LocalDate.now().plusDays(2));
		peticionLibro.setEstadoActual(Estados.ADMITIDA);
	}

	@Override
	public void rechazarPeticion() {
		peticionLibro.setFechaCaducidad(null);
		peticionLibro.setEstadoActual(Estados.RECHAZADA);
	}

}

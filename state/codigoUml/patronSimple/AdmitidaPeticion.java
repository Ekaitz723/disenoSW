package StatePatronBien;

import java.time.LocalDate;

public class AdmitidaPeticion implements PeticionState, PeticionTransicionesEstado{
	private PeticionLibro peticionLibro;
	
	public AdmitidaPeticion(PeticionLibro peticionLibro) {
		this.peticionLibro = peticionLibro;
	}
	
	@Override
	public PeticionLibro getPeticion() {
		return peticionLibro;
	}
	
	@Override
	public void process() {
		if(peticionLibro.isNotCaducado())
			recogerPeticion();
		else
			rechazarPeticion();
	}

	@Override
	public void recogerPeticion() {
		peticionLibro.setFechaCaducidad(LocalDate.now().plusDays((peticionLibro.getCuentaUsuario().getTipoUsuario()==TipoUsuario.ALUMNO)?15:10));
		peticionLibro.setEstadoActual(Estados.CURSADA);
	}

	@Override
	public void rechazarPeticion() {
		peticionLibro.setFechaCaducidad(null);
		peticionLibro.setEstadoActual(Estados.RECHAZADA);
	}
}

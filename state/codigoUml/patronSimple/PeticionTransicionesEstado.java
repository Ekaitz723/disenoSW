package StatePatronBien;

public interface PeticionTransicionesEstado {
	default void admitirPeticion() {
		throw new IllegalStateException("pickupLibraryLoan not available");
	}
	default void recogerPeticion() {
		throw new IllegalStateException("pickupLibraryLoan not available");
	}
	default void devolverPeticion() {
		throw new IllegalStateException("pickupLibraryLoan not available");
	}
	default void rechazarPeticion() {
		throw new IllegalStateException("pickupLibraryLoan not available");
	}
}
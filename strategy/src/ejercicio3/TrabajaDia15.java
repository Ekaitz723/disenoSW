package ejercicio3;

public class TrabajaDia15 extends TrabajaXDia {
	public TrabajaDia15(Doctor doctor) {
		super(doctor);
	}

	protected boolean trabaja() {
		return (PruebaDoctores.getFecha().getDia()==15);
	}
}

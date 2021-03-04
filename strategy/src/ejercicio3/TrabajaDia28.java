package ejercicio3;

public class TrabajaDia28 extends TrabajaXDia {

	public TrabajaDia28(Doctor doctor) {
		super(doctor);
	}

	@Override
	protected boolean trabaja() {
		return PruebaDoctores.getFecha().getDia()==28;
	}
}
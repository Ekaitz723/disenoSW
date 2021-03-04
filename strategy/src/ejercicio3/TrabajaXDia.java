package ejercicio3;

//Se que seria muchisimo mas facil pasar el dia por el contructor, pero este ejercicio es mas que nada para practicar los patrones.
public abstract class TrabajaXDia implements Doctor {
	protected Doctor trabajaXDia;
	
	public TrabajaXDia(Doctor doctor) {
		trabajaXDia = doctor;
	}
	
	protected abstract boolean trabaja();
	
	public Resultado examinar() {
		if(trabaja())
			return trabajaXDia.examinar();
		return null;
	}

	@Override
	public void factura() throws ErrorFormato {
		if(trabaja())
			trabajaXDia.factura();
	}

	@Override
	public void resultado(Resultado resultado) throws ErrorFormato {
		if(trabaja())
			trabajaXDia.resultado(resultado);
	}
	
	public void setIO(EntradaSalida io) {
		if(trabajaXDia instanceof DoctorIO)
			((DoctorIO) trabajaXDia).setIO(io);
	}
}

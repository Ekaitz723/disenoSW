package ejercicio3;

//Se que seria muchisimo mas facil pasar el dia por el contructor, pero este ejercicio es mas que nada para practicar los patrones.
public abstract class TrabajaXDia extends Examinador implements Doctor {
	
	public TrabajaXDia(Doctor doctor) {
		super(doctor);
	}
	
	protected abstract boolean trabaja();
	
	@Override
	public Resultado examinar() {
		if(trabaja())
			return super.examinar();
		return null;
	}

	@Override
	public void factura() throws ErrorFormato {
		if(trabaja())
			super.factura();
	}

	@Override
	public void resultado(Resultado resultado) throws ErrorFormato {
		if(trabaja())
			super.resultado(resultado);
	}
	
	@Override
	public void revision() throws ErrorFormato {
		if(trabaja())
			super.revision();
	}
}

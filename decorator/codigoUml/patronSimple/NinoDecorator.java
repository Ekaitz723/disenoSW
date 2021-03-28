package DecoratorPatron;

public interface NinoDecorator {
	Nino getNino();
	void setNino(Nino n);
	Nino limpiarDecoradores();
	//Recoje un new TipoDecorador(el Nino que estas limpiando mismamente)
	//Solo elimina el ultimo anadido.
	Nino limpiarDecorador(Nino n);
}

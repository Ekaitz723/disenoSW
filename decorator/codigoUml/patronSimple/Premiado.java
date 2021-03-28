package DecoratorPatron;

public class Premiado implements Nino,NinoDecorator{
	Nino n = null;
	
	public Premiado(Nino n) {
		this.n = n;
	}
	
	@Override
	public Nino getNino() {
		return n;
	}
	
	public void setNino(Nino n) {
		this.n = n;
	}
	
	@Override
	public String leerPremios() {
		return n.leerPremios();
	}
	
	@Override
	public void darLibro(String libro) {
		n.darLibro(libro);
	}
	
	@Override
	public String leerLibros() {
		return n.leerLibros();
	}
	
	@Override
	public String toString() {
		return n.leerPremios()+"\n"+n.leerLibros();
	}
	
	@Override
	public Nino limpiarDecoradores() {
		Nino i = this.getNino();
		while(i instanceof NinoDecorator)
			i = ((NinoDecorator)i).getNino();
		return i;
	}

	@Override
	//Solo deja de devolver this en un caso, pero es o ponerle que devuelva Nino o ponerle un getNino a el propio nino (el no decorador)
	public Nino limpiarDecorador(Nino n) {
		if(this.getClass() == ((NinoDecorator) n).getClass())
			return this.getNino();
		if(!(this.getNino() instanceof NinoDecorator)) {
			return this;
		}

		//Por si acaso no pusieron al propio Nino.
		((NinoDecorator) n).setNino(this);
		
		//Los decoradores al final son una lista enlazada. Con "saltarme" un elemento lo estaria eliminando.
		while(((NinoDecorator) ((NinoDecorator) n).getNino()).getNino().getClass() != ((NinoDecorator) n).getClass()) {
			((NinoDecorator) n).setNino(((NinoDecorator)((NinoDecorator) n).getNino()).getNino());
			if(!(((NinoDecorator) ((NinoDecorator) n).getNino()).getNino() instanceof NinoDecorator))
				return this;
		}
		((NinoDecorator)((NinoDecorator) n).getNino()).setNino(((NinoDecorator)((NinoDecorator)((NinoDecorator) n).getNino()).getNino()).getNino());
		
		//Llama al gc para librarse de ese new Decorador.
		n=null;
		System.gc();
		return this;
	}
}

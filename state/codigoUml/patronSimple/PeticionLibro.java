package StatePatronBien;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class PeticionLibro extends Observable{
	//private PeticionState peticionState;
	private List<PeticionState> estados = new ArrayList<PeticionState>(6);
	private Estados estadoActual;
	/*	estados [
			ACTUAL,
			CREADA,
			ADMITIDA,
			CURSADA,
			FINALIZADA,
			RECHAZADA
		]
	*/
	private Biblioteca biblioteca;
	private Libro libro;
	private CuentaUsuario cuentaUsuario;
	private LocalDate fechaCreacion;
	private LocalDate fechaCaducidad;

	public void process() {
		//Podria poner un 0 sin mas y me duele no ponerlo,
		// pero de esta forma aumenta la comprensivilidad del codigo.
		this.estados.get(Estados.ACTUAL.indice()).process();
	}
	
	public PeticionLibro(Biblioteca biblioteca, Libro libro, CuentaUsuario cuentaUsuario) {
		this.setBiblioteca(biblioteca);
		this.setLibro(libro);
		this.setCuentaUsuario(cuentaUsuario);
		
		cuentaUsuario.setObservable(this);
		addObserver(cuentaUsuario);
		
		//Ya que por algun motivo no funciona la capacidad inicial del arraylist, lo pongo en orden:
		estados.add(null);
		estados.add(new CreadaPeticion(this));
		estados.add(new AdmitidaPeticion(this));
		estados.add(new CursadaPeticion(this));
		estados.add(new FinalizadaPeticion(this));
		estados.add(new RechazadaPeticion(this));
		estados.set(Estados.ACTUAL.indice(), estados.get(Estados.CREADA.indice()));
		
		estadoActual = Estados.CREADA;
		/*
		estados.set(Estados.CREADA.indice(),new CreadaPeticion(this));
		estados.set(Estados.ADMITIDA.indice(),new AdmitidaPeticion(this));
		estados.set(Estados.CURSADA.indice(),new CursadaPeticion(this));
		estados.set(Estados.FINALIZADA.indice(),new FinalizadaPeticion(this));
		estados.set(Estados.RECHAZADA.indice(),new RechazadaPeticion(this));
		estados.set(Estados.ACTUAL.indice(), estados.get(Estados.CREADA.indice()));
		*/
	}
	
	//De esta forma, en el caso de que tengamos que controlar el acceso o parecidos,
	// tenemos mayor control de ello haciendo que todo pase por el mismo lado de una
	// forma homogenea.
	public PeticionState getEstado(int cual) {
		return estados.get(cual);
	}
	public PeticionState getEstado(Estados cual) {
		return getEstado(cual.indice());
	}
	
	public PeticionState getEstadoActual() {
		//Aca en vez de usar otro puntero en la lista podria hacerse de otra forma,,
		// pero entoces, no se accederia de la misma forma y se perderia homogeneidad (estoy muy seguro de que esa no es la palabra, ¿Cual es la manera correcta de decirlo? ¿Generalidad en el acceso? No se).
		return getEstado(Estados.ACTUAL.indice());
	}
	public Estados getTipoEstadoActual() {
		return estadoActual;
	}
	
	private void setTipoEstadoActual(Estados cual) {
		estadoActual = cual;
	}
	private void setEstadoActual(int cual) {
		estados.set(Estados.ACTUAL.indice(), estados.get(cual));
		setChanged();
		notifyObservers();
		clearChanged();
	}
	public void setEstadoActual(Estados cual) {
		setFechaCreacion(LocalDate.now());
		setTipoEstadoActual(cual);
		setEstadoActual(cual.indice());
	}
	public boolean isTerminado() {
		return getEstadoActual().equals(getEstado(Estados.FINALIZADA))||getEstadoActual().equals(getEstado(Estados.RECHAZADA));
	}
	
	public boolean isCaducado() {
		return getFechaCaducidad().isBefore(LocalDate.now());
	}
	public boolean isNotCaducado() {
		return getFechaCaducidad().isAfter(LocalDate.now());
	}
	
	public Libro getLibro() {
		return libro;
	}
	private void setLibro(Libro libro) {
		this.libro = libro;
	}
	public Biblioteca getBiblioteca() {
		return biblioteca;
	}
	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}
	public CuentaUsuario getCuentaUsuario() {
		return cuentaUsuario;
	}
	public void setCuentaUsuario(CuentaUsuario cuentaUsuario) {
		this.cuentaUsuario = cuentaUsuario;
	}
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
}

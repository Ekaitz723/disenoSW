package observer;

public class EstadoLibro {
	//True bien.
	//False mal.
	private boolean estado;
	private String nombre;
	
	public EstadoLibro() {
		this("Libro sin portada",true);
	}
	public EstadoLibro(String nombre) {
		this(nombre,true);
	}
	public EstadoLibro(String nombre, boolean estado) {
		this.estado = estado;
		this.nombre = nombre;
	}
	
	public boolean getEstado() {
		return estado;
	}
	
	@Override
	public String toString() {
		return "El libro "+nombre+" esta en "+(estado?"buen":"mal")+" estado";
	}
}

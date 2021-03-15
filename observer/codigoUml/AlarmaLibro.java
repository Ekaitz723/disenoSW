package observer.corregido.corregidoUtil;

public class AlarmaLibro {
	//True bien.
	//False mal.
	private boolean estado;
	private String nombre;
	
	public AlarmaLibro() {
		this("Libro sin portada",true);
	}
	public AlarmaLibro(String nombre) {
		this(nombre,true);
	}
	public AlarmaLibro(String nombre, boolean estado) {
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

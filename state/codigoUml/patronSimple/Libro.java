package StatePatronBien;

public class Libro {
	private String titulo;
	private String autor;
	private EstadoLibro estadoLibro;
	public Libro(String titulo, String autor, EstadoLibro estadoLibro) {
		this.autor = autor;
		this.estadoLibro = estadoLibro;
		this.titulo = titulo;
	}
	//No quiero contructor vacio, gracias.
	public EstadoLibro getEstadoLibro() {
		return estadoLibro;
	}
	public void setEstadoLibro(EstadoLibro estadoLibro) {
		this.estadoLibro = estadoLibro;
	}
	public String getAutor() {
		return autor;
	}
	public String getTitulo() {
		return titulo;
	}
}

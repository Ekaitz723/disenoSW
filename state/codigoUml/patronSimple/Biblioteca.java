package StatePatronBien;

public class Biblioteca {
	private static Biblioteca instance = new Biblioteca();
	
	private Biblioteca() {}
	
	public void devolverLibro(Libro libro) {
		if(libro.getEstadoLibro().equals(EstadoLibro.MAAAAAL)) {
			System.out.println("Esta en la anterior entrega. Si lo pondría aca, aparte de no tener mucho sentido introducir esto en un ejemplo"
					+ " del patron state, se crea el pifostio padre en el uml. \nEl unico sentido que le encuentro es la \"retrocompativilidad\" "
					+ "pero teniendo en cuenta que el uso de este programa es ejemplificar el patron y guardarlo en un conjunto de apuntes "
					+ "de los diferentes patrones que estamos viendo, me parece contraproducente añadirlo.");
		}
	}
	public static void process(PeticionLibro peticionLibro) {
		peticionLibro.process();
	}

	public static Biblioteca getInstance() {
		//Mejor lo dejo sin restringir el acceso al getInstance();
		return instance;
	}
}

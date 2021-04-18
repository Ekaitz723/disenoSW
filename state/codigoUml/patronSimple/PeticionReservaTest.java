package StatePatronBien;

public class PeticionReservaTest {
	public static void main(String[] args) {
		//Es un singleton, pero ni lo uso, prefiero dejar process como static para este ejemplo de uso.
		//Aun asi lo creo para que se vea que es un singleton.
		//En el caso de que process no sea static pues seria biblioteca.process(laPeticion);
		Biblioteca biblioteca = Biblioteca.getInstance();
		
		Libro libro = new Libro("How to read", "Paco", EstadoLibro.BIEN);
		
		
		CuentaUsuario profesor = new CuentaUsuario("MA","miguel.mesas@u-tad.com",TipoUsuario.PROFESOR,true);
		CuentaUsuario alumno = new CuentaUsuario("Ekaitz","ekaitz.arriola@live.u-tad.com",TipoUsuario.ALUMNO,true);
		
		PeticionLibro peticionProfesor = new PeticionLibro(biblioteca, libro, profesor);
		PeticionLibro peticionAlumno = new PeticionLibro(biblioteca, libro, alumno);
		
		Biblioteca.process(peticionAlumno);
		Biblioteca.process(peticionProfesor);
	}
}

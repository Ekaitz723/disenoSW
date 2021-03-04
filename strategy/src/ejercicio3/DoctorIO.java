package ejercicio3;

public abstract class DoctorIO implements Doctor {
	protected EntradaSalida io;
	protected String nombre;
	
	public DoctorIO() {
		this.io = Consola.instancia();
		nombre = "";
	}
	public DoctorIO(String nombre) {
		this.io = Consola.instancia();
		this.nombre = nombre;
	}
	public DoctorIO(EntradaSalida io, String nombre) {
		this.io = io;
		this.nombre = nombre;
	}

	public void setIO(EntradaSalida io) {
		this.io = io;
	}
	
	protected String pruebaRealizadaPor() {
		return "Prueba realizada por el doctor "+nombre+"\n\t";
	}
}

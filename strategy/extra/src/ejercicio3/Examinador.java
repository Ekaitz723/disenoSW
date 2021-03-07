package ejercicio3;

public class Examinador {
	private Doctor doctor;
	
	public Examinador(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public Resultado examinar() {
		return doctor.examinar();
	}

	public void factura() throws ErrorFormato {
		doctor.factura();
	}

	public void resultado(Resultado resultado) throws ErrorFormato {
		doctor.resultado(resultado);
	}
	
	public void revision() throws ErrorFormato {
		doctor.revision();
	}
	
	public void setIO(EntradaSalida io) {
		if(doctor instanceof DoctorIO)
			((DoctorIO) doctor).setIO(io);
	}
}
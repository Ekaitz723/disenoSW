package StatePatronBien;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class CuentaUsuario implements Observer{
	private String nombre;
	private String correo;
	private TipoUsuario tipoUsuario;
	private Boolean activa;
	private Observable o;
	
	public CuentaUsuario(String nombre, String correo, TipoUsuario tipoUsuario, Boolean activa) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.tipoUsuario = tipoUsuario;
		this.activa = activa;
	}
	public CuentaUsuario(TipoUsuario tipoUsuario) {
		this("Def. Name","",tipoUsuario,true);
	}
	public CuentaUsuario() {
		this(TipoUsuario.ALUMNO);
	}
	
	//La simulacion:
	//¿Llega notificacion de que tiene que aceptar algo? Pregunta si acceptarlo o no.
	@Override
	public void update(Observable o, Object arg) {
		//Parte de recibir la notificacion:
		//this siempre va a ser ((PeticionLibro)this.o).getCuentaUsuario(), pero por poder tener una forma actualizable de acceder a el se usara el segundo.
		//System.out.println("Llega xd" + ((PeticionLibro)this.o).getTipoEstadoActual().toString());
		System.out.println("Usuarix: "+((PeticionLibro)this.o).getCuentaUsuario().getNombre()
				+ ", peticion de reserva "+((PeticionLibro)this.o).getTipoEstadoActual().toString().toLowerCase() 
				+ " en "+((PeticionLibro)this.o).getFechaCreacion().toString()+", "
				+ ( (((PeticionLibro)this.o).getFechaCaducidad()==null)?
						((PeticionLibro)this.o).getLibro().getEstadoLibro().toString()
						: "hasta " + ((PeticionLibro)this.o).getFechaCaducidad().toString()));
		
		////Simulacion:
		//Inmediata. No voy a hacer ninguna simulacion mas que si llega algo, se acepta.
		//Lo que si, esta todo preparado para la simulacion.
		//Ahora se tendria que llamar al lo que gestiona el input y se terminaria el update().
		//Despues cuando se consiga el input, hay se llamara al process() de la peticionLibro.
		
		//Al ser la simulacion totalmente inmediata, lo pongo tambien en el update.
		//Parte a poner en otro lado en caso de pedir input y hacer una simulacion innecesaria:
		((PeticionLibro)this.o).process();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public Boolean isActiva() {
		return activa;
	}
	public void toogleActiva() {
		activa = !activa;
	}
	public void setActiva() {
		activa = true;
	}
	public void clearActiva() {
		activa = false;
	}
	public void setObservable(Observable o) {
		this.o = o;
	}
}
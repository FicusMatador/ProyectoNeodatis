
public class Jugadores {
	private String nombre;
	private String deporte;
	private String ciudad;
	private int edad;
	public Jugadores() {
		// TODO Auto-generated constructor stub
	}
	public String getCiudad() {
		return ciudad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDeporte() {
		return deporte;
	}
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public Jugadores(String nombre, String deporte, String ciudad, int edad) {
		super();
		this.nombre = nombre;
		this.deporte = deporte;
		this.ciudad = ciudad;
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "Jugadores [nombre=" + nombre + ", deporte=" + deporte + ", ciudad=" + ciudad + ", edad=" + edad + "]";
	}
	
	
}

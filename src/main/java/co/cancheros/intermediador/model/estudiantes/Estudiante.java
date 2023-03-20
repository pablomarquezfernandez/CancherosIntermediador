package co.cancheros.intermediador.model.estudiantes;

import java.util.Iterator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.amazonaws.util.json.JSONArray;
import com.amazonaws.util.json.JSONObject;

//@Entity
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	String nombres;
	String apellidos;
	String correo;
	
	public Estudiante( ) {
		super();
		this.nombres = null;
		this.apellidos = null;
		this.correo = null;
	}
	public Estudiante( String nombres, String apellidos, String codigoUniversidad) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
	}
	public long getId() {
		return id;
	}
	public String getNombres() {
		return nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public JSONObject toJSON() throws Exception {
		JSONObject japlicacion = new JSONObject();
		japlicacion.put("id", getId());
		japlicacion.put("nombres", getNombres());
		japlicacion.put("apellidos", getApellidos());
		japlicacion.put("correo", getCorreo());
		return japlicacion;
	}
	
	public static JSONArray toJSONArray( Iterable<Estudiante>estudiantes ) throws Exception {
		JSONArray jestudiantes = new JSONArray();
		Iterator<Estudiante> iestudiantes = estudiantes.iterator();
		while( iestudiantes.hasNext() ) {
			Estudiante estudiante = iestudiantes.next();
			jestudiantes.put( estudiante.toJSON() );
		}
		
		return jestudiantes;
	}
	
}

package co.cancheros.intermediador.model.estudiantes;

import java.util.Iterator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.amazonaws.util.json.JSONArray;
import com.amazonaws.util.json.JSONObject;

@Entity
public class Estudiante {

	
	public static final Integer ESTADO_ACTIVO = 1;
	public static final Integer ESTADO_INACTIVO = 2;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	
	String nombres;
	String apellidos;
	String correo;
	Integer estado;
	
	@ManyToOne()
    @JoinColumn(name = "grupo_id")
	Grupo grupo;
	
	public Estudiante( ) {
		super();
		this.nombres = null;
		this.apellidos = null;
		this.correo = null;
	}
	public Estudiante( String nombres, String apellidos, String correo) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
	}
	public Long getId() {
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
	public void setId(Long id) {
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
	
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	
	public void setValores( String nombres, String apellidos, String correo, Grupo grupo) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.grupo = grupo;
		this.estado = ESTADO_ACTIVO;
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

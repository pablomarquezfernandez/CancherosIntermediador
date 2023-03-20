package co.cancheros.intermediador.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.amazonaws.util.json.JSONArray;
import com.amazonaws.util.json.JSONObject;

import co.cancheros.intermediador.model.estudiantes.Estudiante;

@Entity
public class Aplicacion {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	String numeroGrupo;
	Integer tipo;
	
	@OneToMany
	List<Estudiante>estudiantes = new ArrayList<Estudiante>();

	public Aplicacion() {
		super();
		this.id = null;
		this.numeroGrupo = "";
		this.tipo = -1;
	}
	public Aplicacion(Integer id, String numeroGrupo, Integer tipo, List<Estudiante> estudiantes) {
		super();
		this.id = null;
		this.numeroGrupo = numeroGrupo;
		this.tipo = tipo;
		this.estudiantes = estudiantes;
	}


	public Aplicacion( String numeroGrupo, Integer tipo) {
		this.numeroGrupo = numeroGrupo;
		this.tipo = tipo;
	}
	
	
	public Long getId() {
		return id;
	}
	public String getNumeroGrupo() {
		return numeroGrupo;
	}
	public Integer getTipo() {
		return tipo;
	}


	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	
	public JSONObject toJSON() throws Exception {
		JSONObject japlicacion = new JSONObject();
		japlicacion.put("id", getId());
		japlicacion.put("numeroGrupo", getNumeroGrupo());
		japlicacion.put("tipo", getTipo());
		return japlicacion;
	}
	
	public static JSONArray toJSONArray( Iterable<Aplicacion>aplicaciones ) throws Exception {
		JSONArray japlicaciones = new JSONArray();
		Iterator<Aplicacion> iaplicaciones = aplicaciones.iterator();
		while( iaplicaciones.hasNext() ) {
			Aplicacion aplicacion = iaplicaciones.next();
			japlicaciones.put( aplicacion.toJSON() );
		}
		
		return japlicaciones;
	}
}

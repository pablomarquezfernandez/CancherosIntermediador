package co.cancheros.intermediador.model;

import java.util.Iterator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.util.json.JSONArray;
import com.amazonaws.util.json.JSONObject;

import co.cancheros.intermediador.model.estudiantes.Grupo;
import co.cancheros.intermediador.model.estudiantes.GrupoRepository;

@Entity
public class Aplicacion {

	public static final Integer ESTADO_ACTIVO = 1;
	public static final Integer ESTADO_INACTIVO = 2;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	String nombre;
	Integer tipo;
	
	
//	@Autowired
//	GrupoRepository grupoRepository;
	@OneToOne
	Grupo grupo;
	
	Integer estado;
	
	
	public Aplicacion() {
		super();
		this.id = null;
		this.nombre = null;;
		this.tipo = null;;
		this.estado = ESTADO_ACTIVO;
	}
	
	
	public Long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public void setValoresInsertar(String nombre, Integer tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
	}


	public JSONObject toJSON() throws Exception {
		JSONObject japlicacion = new JSONObject();
		japlicacion.put("id", getId());
		japlicacion.put("nombre", getNombre());
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

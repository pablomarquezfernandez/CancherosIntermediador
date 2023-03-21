package co.cancheros.intermediador.model.estudiantes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Grupo {

	public static final Integer ESTADO_ACTIVO = 1;
	public static final Integer ESTADO_INACTIVO = 2;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private Integer numeroGrupo;
	private String nombre;
	private Integer estado;
	
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "grupo_id")
	List<Estudiante>estudiantes = new ArrayList<Estudiante>();
	
	public Grupo() {
		numeroGrupo = null;
		nombre = null;
		estado = ESTADO_ACTIVO;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumeroGrupo() {
		return numeroGrupo;
	}
	public void setNumeroGrupo(int numeroGrupo) {
		this.numeroGrupo = numeroGrupo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	public void setValores(Integer numeroGrupo, String nombre) {
		this.numeroGrupo = numeroGrupo;
		this.nombre = nombre;
		this.estado = ESTADO_ACTIVO;
	}
	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	
	
//	public void insertarEstudiante( Estudiante estudiante ) {
//		getEstudiantes().add( estudiante );
//	}
//	public void eliminarEstudiante( int posicion ) {
//		getEstudiantes().remove( posicion );
//	}
	
//	@Autowired
//	EstudianteRepository estudianteRepository;
//	@OneToMany
//	List<Estudiante>estudiantes = new ArrayList<Estudiante>();
	
	
	
	
	
}

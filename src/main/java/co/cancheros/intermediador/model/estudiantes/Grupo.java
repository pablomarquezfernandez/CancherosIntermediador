package co.cancheros.intermediador.model.estudiantes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Grupo {

	public static final Integer ESTADO_ACTIVO = 1;
	public static final Integer ESTADO_INACTIVO = 2;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private int numeroGrupo;
	private String nombre;
	private int estado;
	
//	@Autowired
//	EstudianteRepository estudianteRepository;
//	@OneToMany
//	List<Estudiante>estudiantes = new ArrayList<Estudiante>();
	
	
	
}

package co.cancheros.intermediador;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.cancheros.intermediador.model.estudiantes.Estudiante;
import co.cancheros.intermediador.model.estudiantes.EstudianteRepository;
import co.cancheros.intermediador.model.estudiantes.Grupo;
import co.cancheros.intermediador.model.estudiantes.GrupoRepository;

@SpringBootTest
public class EstudianteTest {
	
	
//	@Autowired
//	AplicacionRepository aplicacionRepository;
	
	@Autowired
	GrupoRepository grupoRepository;
	
	@Autowired
	EstudianteRepository estudianteRepository;
	
	@Test
//	@Transactional
	public void pruebaInsercionEdtudiante() {
		try {
			Grupo grupo = grupoRepository.findById((long) 1).get();
			
			Estudiante estudiante = new Estudiante();
			estudiante.setValores("PABLO", "MARQUEZ", "pablo.marquez@dynaco.co", grupo);
			estudianteRepository.save( estudiante );
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue( false, "Error en la aplicación" );
			
		}
	}
}

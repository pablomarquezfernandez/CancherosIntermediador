package co.cancheros.intermediador;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.cancheros.intermediador.model.Aplicacion;
import co.cancheros.intermediador.model.AplicacionRepository;
import co.cancheros.intermediador.model.estudiantes.Grupo;
import co.cancheros.intermediador.model.estudiantes.GrupoRepository;

@SpringBootTest
public class GrupoTest {
	
	
	@Autowired
	AplicacionRepository aplicacionRepository;
	
	@Autowired
	GrupoRepository grupoRepository;
	
	@Test
	public void pruebaInsercionAplicaciones() {
		try {
			Grupo grupo = new Grupo();
			grupo.setValores(1, "Grupo 1");
			grupoRepository.save( grupo );
			
			Aplicacion aplicacion = aplicacionRepository.findById((long) 2).get();
			aplicacion.setGrupo( grupo );
			
			
			aplicacionRepository.save( aplicacion );
			
			Grupo grupoTemp = aplicacion.getGrupo();
			
			assertTrue(  grupoTemp.getNombre().equals( "Grupo 1" )  );
			
			
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue( false, "Error en la aplicación" );
			
		}
	}
}

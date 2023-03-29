package co.cancheros.intermediador;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.cancheros.intermediador.model.Aplicacion;
import co.cancheros.intermediador.model.AplicacionRepository;


@SpringBootTest
public class AplicacionTest {

	@Autowired
	AplicacionRepository aplicacionRepository;
	
	@Test
	public void pruebaInsercionAplicaciones() {
		try {
			Iterator<Aplicacion>aplicaciones = aplicacionRepository.findAll().iterator();
			int cantidad = 0;
			while( aplicaciones.hasNext() ) {
				aplicaciones.next();
				cantidad ++;
			}
			
			Aplicacion aplicacion = new Aplicacion();
			aplicacion.setValoresInsertar("Grupo 1 CLASE", 1);
			aplicacionRepository.save( aplicacion );
			
			aplicacion = new Aplicacion();
			aplicacion.setValoresInsertar("Grupo 2 CLASE", 2);
			aplicacionRepository.save( aplicacion );
			
			aplicacion = new Aplicacion();
			aplicacion.setValoresInsertar("Grupo 3 CLASE", 2);
			aplicacionRepository.save( aplicacion );
			
			
			aplicaciones = aplicacionRepository.findAll().iterator();
			int nuevaCantidad = 0;
			while( aplicaciones.hasNext() ) {
				aplicaciones.next();
				nuevaCantidad ++;
			}
			assertTrue( cantidad + 3 == nuevaCantidad, "Aumento en la cantidad debida" );
//			Iterable<Aplicacion>aplicaciones = 
			
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue( false, "Error en la aplicación" );
			
		}
	}
}

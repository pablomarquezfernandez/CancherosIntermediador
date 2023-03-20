package co.cancheros.intermediador.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.cancheros.intermediador.model.Aplicacion;
import co.cancheros.intermediador.model.AplicacionRepository;
import co.cancheros.intermediador.model.estudiantes.Estudiante;

@RestController
public class EstudianteController {

//	@Autowired
//	EstudianteController estudianteRepository;
	
	@Autowired
	AplicacionRepository aplicacionRepository;
	
	
	@CrossOrigin
	@GetMapping(value = "/estudiantes/{idAplicacion}", produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<String> aplicaciones(@PathVariable Long idAplicacion) throws Exception{
//		Aplicacion aplicacion = new Aplicacion("1111", 1);
		Optional<Aplicacion> aplicacionOp = aplicacionRepository.findById(idAplicacion);
		Aplicacion aplicacion = aplicacionOp.get();
		Iterable<Estudiante>estudiantes = aplicacion.getEstudiantes();
		
		HttpHeaders responseHeaders = new HttpHeaders();
		return  new ResponseEntity<String>( Estudiante.toJSONArray(estudiantes).toString(), responseHeaders, HttpStatus.OK );
	}
}

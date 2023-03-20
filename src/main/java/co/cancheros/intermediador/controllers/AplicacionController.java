package co.cancheros.intermediador.controllers;

import java.util.List;
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

@RestController
public class AplicacionController {

	@Autowired
	AplicacionRepository aplicacionRepository;
	
	
	@CrossOrigin
	@GetMapping(value = "/insertar-aplicacion", produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<String> insertar() throws Exception{
		Aplicacion aplicacion = new Aplicacion("1111", 1);
		aplicacionRepository.save(aplicacion);
		
		
		HttpHeaders responseHeaders = new HttpHeaders();
		return  new ResponseEntity<String>( "{\"respuesta\":\"exito\"}", responseHeaders, HttpStatus.OK );
	}
	
	
	@CrossOrigin
	@GetMapping(value = "/aplicaciones", produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<String> aplicaciones() throws Exception{
//		Aplicacion aplicacion = new Aplicacion("1111", 1);
		Iterable<Aplicacion>aplicaciones = aplicacionRepository.findAll();
		
		
		HttpHeaders responseHeaders = new HttpHeaders();
		return  new ResponseEntity<String>( Aplicacion.toJSONArray(aplicaciones).toString(), responseHeaders, HttpStatus.OK );
	}
	
	@CrossOrigin
	@GetMapping(value = "/aplicacion/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<String> aplicaciones(@PathVariable Long id) throws Exception{
//		Aplicacion aplicacion = new Aplicacion("1111", 1);
		Optional<Aplicacion> aplicacionOp = aplicacionRepository.findById(id);
		
		
		HttpHeaders responseHeaders = new HttpHeaders();
		return  new ResponseEntity<String>( aplicacionOp.get().toJSON().toString(), responseHeaders, HttpStatus.OK );
	}
}

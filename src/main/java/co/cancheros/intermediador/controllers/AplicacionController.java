package co.cancheros.intermediador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.util.json.JSONObject;

import co.cancheros.intermediador.model.Aplicacion;
import co.cancheros.intermediador.model.AplicacionRepository;

@RestController
public class AplicacionController {

	@Autowired
	AplicacionRepository aplicacionRepository;
	
	
	
	@CrossOrigin
	@GetMapping(value = "/aplicacion", produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<String> getAplicaciones(    ) throws Exception{
		Iterable<Aplicacion>aplicaciones = aplicacionRepository.findAll();
		HttpHeaders responseHeaders = new HttpHeaders();
		return  new ResponseEntity<String>( Aplicacion.toJSONArray(aplicaciones).toString(), responseHeaders, HttpStatus.OK );
	}
	@CrossOrigin
	@GetMapping(value = "/aplicacion/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<String> getAplicaciones(  @PathVariable Long id  ) throws Exception{
		Aplicacion aplicacion = aplicacionRepository.findById(id).get();
		HttpHeaders responseHeaders = new HttpHeaders();
		return  new ResponseEntity<String>( aplicacion.toJSON().toString(), responseHeaders, HttpStatus.OK );
	}
	
	
	@CrossOrigin
	@PostMapping(value = "/aplicacion", produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<String> insertarAplicacion(  @RequestParam String nombre, @RequestParam Integer tipo  ) throws Exception{
		Aplicacion aplicacion = new Aplicacion();
		aplicacion.setValoresInsertar(nombre, tipo);
		aplicacionRepository.save(aplicacion);
		
		
		HttpHeaders responseHeaders = new HttpHeaders();
		JSONObject jrta = new JSONObject();
		jrta.put("respuesta", "exito");
		jrta.put("objeto", aplicacion.toJSON());
		
		return  new ResponseEntity<String>( "{\"respuesta\":\"exito\"}", responseHeaders, HttpStatus.OK );
	}
	
	
	
	
	
	
}

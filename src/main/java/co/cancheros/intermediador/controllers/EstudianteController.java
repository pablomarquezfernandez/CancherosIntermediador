package co.cancheros.intermediador.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.cancheros.intermediador.model.estudiantes.Estudiante;
import co.cancheros.intermediador.model.estudiantes.Grupo;
import co.cancheros.intermediador.model.estudiantes.GrupoRepository;

@RestController
public class EstudianteController {


	@Autowired
	GrupoRepository grupoRepository;
	
	@CrossOrigin
	@GetMapping(value = "/grupo/{idGrupo}/estudiantes", produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<String> getEstudiante(  @PathVariable Long idGrupo  ) throws Exception{
		Grupo grupo = grupoRepository.findById((long) idGrupo).get();
		List<Estudiante>estudiantes = grupo.getEstudiantes();
		HttpHeaders responseHeaders = new HttpHeaders();
		return  new ResponseEntity<String>( Estudiante.toJSONArray(estudiantes).toString(), responseHeaders, HttpStatus.OK );
	}
	
	

}

package com.cloud.qualify.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.qualify.app.documents.Qualify;
import com.cloud.qualify.app.services.QualifyServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/qualify")
public class QualifyController {

	@Autowired
	private QualifyServiceImpl _qualifyServ;
	
	@GetMapping("/")
	public ResponseEntity<Flux<Qualify>> getAll(){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_qualifyServ.getAll());
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Mono<Qualify>> create(@RequestBody Qualify qualify){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_qualifyServ.save(qualify));
	}
	
	@PutMapping("/id/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Mono<Qualify>> update(@RequestBody Qualify qualify, @PathVariable String id){
		Mono<Qualify> qualifyDB = _qualifyServ.getById(id).flatMap(q -> {
			q.setIdStudent(qualify.getIdStudent());
			q.setIdCourse(qualify.getIdCourse());
			
			return _qualifyServ.save(q);
		});
		
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(qualifyDB);
	}
	
	@DeleteMapping("/id/{id}")
	public Mono<Void> deleteById(@PathVariable String id) {
		return _qualifyServ.deleteById(id);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Mono<Qualify>> getById(@PathVariable String id){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_qualifyServ.getById(id));
	}
	
	@GetMapping("/idStudent/{idStudent}")
	public ResponseEntity<Flux<Qualify>> getByIdStudent(@PathVariable String idStudent){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_qualifyServ.getByIdStudent(idStudent));
	}
	
	@GetMapping("/idCourse/{idCourse}")
	public ResponseEntity<Flux<Qualify>> getByIdCourse(@PathVariable String idCourse){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_qualifyServ.getByIdCourse(idCourse));
	}
}




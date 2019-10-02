package com.cloud.professor.app.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
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

import com.cloud.professor.app.documents.Professor;
import com.cloud.professor.app.services.ProfessorServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorServiceImpl _professorServ;
	
	@GetMapping("/")
	public ResponseEntity<Flux<Professor>> getAll(){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_professorServ.getAll());
	}
	
	@PostMapping("/")
	public ResponseEntity<Mono<Professor>> create(@RequestBody Professor professor){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_professorServ.save(professor));
	}
	
	@PutMapping("/id/{id}")
	public ResponseEntity<Mono<Professor>> update(@RequestBody Professor professor, @PathVariable String id){
		Mono<Professor> professorDB = _professorServ.getById(id).flatMap(pf -> {
			pf.setFirstName(professor.getFirstName());
			pf.setLastName(professor.getLastName());
			pf.setGende(professor.getGende());
			pf.setBirthdayDate(professor.getBirthdayDate());
			pf.setDocType(professor.getDocType());
			pf.setDocNumber(professor.getDocNumber());
			
			return _professorServ.save(pf);
		});
		
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(professorDB);
	}
	
	@DeleteMapping("/id/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> deleteById(@PathVariable String id) {
		return _professorServ.deleteById(id);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Mono<Professor>> getById(@PathVariable String id){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_professorServ.getById(id));
	}
	
	@GetMapping("/name/{firstName}")
	public ResponseEntity<Flux<Professor>> getByFirstName(@PathVariable String firstName){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_professorServ.getByFirstName(firstName));
	}
	
	@GetMapping("/dates/{date1}/{date2}")
	public ResponseEntity<Flux<Professor>> getByBirthdayDateBetween(@PathVariable @DateTimeFormat(iso = ISO.DATE) LocalDate date1,
																	@PathVariable @DateTimeFormat(iso = ISO.DATE) LocalDate date2){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_professorServ.getByBirthdayDate(date1, date2));
	}
	
}













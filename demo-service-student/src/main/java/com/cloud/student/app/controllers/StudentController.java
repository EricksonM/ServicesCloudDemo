package com.cloud.student.app.controllers;

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

import com.cloud.student.app.documents.Student;
import com.cloud.student.app.services.StudentServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentServiceImpl _studentServ;
	
	@GetMapping("/")
	public ResponseEntity<Flux<Student>> getAll(){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_studentServ.getAll());
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Mono<Student>> create(@RequestBody Student student){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_studentServ.save(student));
	}
	
	@PutMapping("/id/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Mono<Student>> update(@RequestBody Student student, @PathVariable String id){
		Mono<Student> studentDB = _studentServ.getById(id).flatMap(st -> {
					st.setFirstName(student.getFirstName());
					st.setLastName(student.getLastName());
					st.setGender(student.getGender());
					st.setBirthdayDate(student.getBirthdayDate());
					st.setDocType(student.getDocType());
					st.setDocNumber(student.getDocNumber());
					
					return _studentServ.save(st);
				});
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(studentDB);
	}
	
	@DeleteMapping("/id/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> deleteById(@PathVariable String id){
		return _studentServ.deleteById(id);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Mono<Student>> getById(@PathVariable String id){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_studentServ.getById(id));
	}
	
	@GetMapping("/name/{firstName}")
	public ResponseEntity<Flux<Student>> getByFirstName(@PathVariable String firstName){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_studentServ.getByName(firstName));
	}
	
	@GetMapping("/dates/{date1}/{date2}")
	public ResponseEntity<Flux<Student>> getByBrithdayDateBetween(@PathVariable @DateTimeFormat(iso = ISO.DATE) LocalDate date1,
																  @PathVariable @DateTimeFormat(iso = ISO.DATE) LocalDate date2){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_studentServ.getByBirthdayDateBetween(date1, date2));
	}
	
}







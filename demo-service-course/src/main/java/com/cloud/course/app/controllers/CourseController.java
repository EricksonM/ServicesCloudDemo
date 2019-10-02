package com.cloud.course.app.controllers;

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

import com.cloud.course.app.documents.Course;
import com.cloud.course.app.services.CourseServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseServiceImpl _courseServ;
	
	@GetMapping("/")
	public ResponseEntity<Flux<Course>> getAll(){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_courseServ.getAll());
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Mono<Course>> create(@RequestBody Course course){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_courseServ.save(course));
	}
	
	@PutMapping("/id/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Mono<Course>> update(@RequestBody Course course, @PathVariable String id){
		Mono<Course> courseDB = _courseServ.getById(id).flatMap(co -> {
			co.setName(course.getName());
			co.setMin(course.getMin());
			co.setMax(course.getMax());
			co.setIdProfessor(course.getIdProfessor());
			co.setStatus(course.getStatus());
			
			return _courseServ.save(co);
		});
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(courseDB);
	}
	
	@DeleteMapping("/id/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> deleteById(@PathVariable String id) {
		return _courseServ.deleteById(id);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Mono<Course>> getById(@PathVariable String id){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_courseServ.getById(id));
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Flux<Course>> getByName(@PathVariable String name){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_courseServ.getByName(name));
	}
	
	@GetMapping("/idProfessor/{idProfessor}")
	public ResponseEntity<Flux<Course>> getByIdProfessor(@PathVariable String idProfessor){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_courseServ.getByIdProfessor(idProfessor));
	}
	
	@GetMapping("/status/{status}")
	public ResponseEntity<Flux<Course>> getByStatus(@PathVariable String status){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_courseServ.getByStatus(status));
	}
	
}








package com.cloud.course.app.services;

import com.cloud.course.app.documents.Course;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICourseService {

	public Flux<Course> getAll();
	public Mono<Course> save(Course course);
	public Mono<Void> deleteById(String id);
	public Mono<Course> getById(String id);
	public Flux<Course> getByName(String name);
	public Flux<Course> getByIdProfessor(String idProfessor);
	public Flux<Course> getByStatus(String status);
	
}

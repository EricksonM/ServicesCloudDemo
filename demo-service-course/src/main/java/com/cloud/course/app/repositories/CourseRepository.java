package com.cloud.course.app.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.cloud.course.app.documents.Course;

import reactor.core.publisher.Flux;

@Repository
public interface CourseRepository extends ReactiveMongoRepository<Course, String>{

	public Flux<Course> findByName(String name);
	public Flux<Course> findByIdProfessor(String idProfessor);
	public Flux<Course> findByStatus(String status);
}

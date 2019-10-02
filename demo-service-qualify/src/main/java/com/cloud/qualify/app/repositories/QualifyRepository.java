package com.cloud.qualify.app.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.cloud.qualify.app.documents.Qualify;

import reactor.core.publisher.Flux;

@Repository
public interface QualifyRepository extends ReactiveMongoRepository<Qualify, String>{

	public Flux<Qualify> findByIdStudent(String idStudent);
	public Flux<Qualify> findByIdCourse(String idCourse);

}

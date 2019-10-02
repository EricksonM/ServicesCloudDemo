package com.cloud.qualify.app.services;

import com.cloud.qualify.app.documents.Qualify;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IQualifyService {

	public Flux<Qualify> getAll();
	public Mono<Qualify> save(Qualify qualify);
	public Mono<Void> deleteById(String id);
	public Mono<Qualify> getById(String id);
	public Flux<Qualify> getByIdStudent(String idStudent);
	public Flux<Qualify> getByIdCourse(String idCourse);
	
}

package com.cloud.professor.app.services;

import java.time.LocalDate;

import com.cloud.professor.app.documents.Professor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProfessorService {

	public Flux<Professor> getAll();
	public Mono<Professor> save(Professor professor);
	public Mono<Void> deleteById(String id);
	public Mono<Professor> getById(String id);
	public Flux<Professor> getByFirstName(String firstName);
	public Flux<Professor> getByBirthdayDate(LocalDate date1, LocalDate date2);
	
}

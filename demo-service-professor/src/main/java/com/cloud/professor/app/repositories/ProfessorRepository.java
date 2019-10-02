package com.cloud.professor.app.repositories;

import java.time.LocalDate;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.cloud.professor.app.documents.Professor;

import reactor.core.publisher.Flux;

@Repository
public interface ProfessorRepository extends ReactiveMongoRepository<Professor, String>{

	public Flux<Professor> findByFirstName(String firstName);
	public Flux<Professor> findByBirthdayDateBetween(LocalDate date1, LocalDate date2);
}

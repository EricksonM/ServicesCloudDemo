package com.cloud.family.app.repositories;

import java.time.LocalDate;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.cloud.family.app.documents.Family;

import reactor.core.publisher.Flux;

@Repository
public interface FamilyRepository extends ReactiveMongoRepository<Family, String>{

	public Flux<Family> findByFirstName(String firstName);
	public Flux<Family> findByBirthdayDateBetween(LocalDate date1, LocalDate date2);
	public Flux<Family> findByIdTitular(String idTitular);
	
}

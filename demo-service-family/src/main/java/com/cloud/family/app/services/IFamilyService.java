package com.cloud.family.app.services;

import java.time.LocalDate;

import com.cloud.family.app.documents.Family;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IFamilyService {

	public Flux<Family> getAll();
	public Mono<Family> save(Family family);
	public Mono<Void> deleteById(String id);
	public Mono<Family> getById(String id);
	public Flux<Family> getByFirstName(String firstName);
	public Flux<Family> getByBirthdayDateBetween(LocalDate date1, LocalDate date2);
	public Flux<Family> getByIdTitular(String idTitular);
	
}

package com.cloud.professor.app.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.professor.app.documents.Professor;
import com.cloud.professor.app.repositories.ProfessorRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProfessorServiceImpl implements IProfessorService {

	@Autowired
	private ProfessorRepository _professorRepo;
	
	@Override
	public Flux<Professor> getAll() {
		return _professorRepo.findAll();
	}

	@Override
	public Mono<Professor> save(Professor professor) {
		return _professorRepo.save(professor);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return _professorRepo.deleteById(id);
	}

	@Override
	public Mono<Professor> getById(String id) {
		return _professorRepo.findById(id);
	}

	@Override
	public Flux<Professor> getByFirstName(String firstName) {
		return _professorRepo.findByFirstName(firstName);
	}

	@Override
	public Flux<Professor> getByBirthdayDate(LocalDate date1, LocalDate date2) {
		return _professorRepo.findByBirthdayDateBetween(date1, date2);
	}

}

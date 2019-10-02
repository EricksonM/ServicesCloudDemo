package com.cloud.qualify.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.qualify.app.documents.Qualify;
import com.cloud.qualify.app.repositories.QualifyRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class QualifyServiceImpl implements IQualifyService{

	@Autowired
	private QualifyRepository _qualifyRepo;
	
	@Override
	public Flux<Qualify> getAll() {
		return _qualifyRepo.findAll();
	}

	@Override
	public Mono<Qualify> save(Qualify qualify) {
		return _qualifyRepo.save(qualify);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return _qualifyRepo.deleteById(id);
	}

	@Override
	public Mono<Qualify> getById(String id) {
		return _qualifyRepo.findById(id);
	}
	
	@Override
	public Flux<Qualify> getByIdStudent(String idStudent) {
		return _qualifyRepo.findByIdStudent(idStudent);
	}

	@Override
	public Flux<Qualify> getByIdCourse(String idCourse) {
		return _qualifyRepo.findByIdCourse(idCourse);
	}


}

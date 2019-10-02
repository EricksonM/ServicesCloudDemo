package com.cloud.course.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.course.app.documents.Course;
import com.cloud.course.app.repositories.CourseRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CourseServiceImpl implements ICourseService {

	@Autowired
	private CourseRepository _courseRepo;	
	
	@Override
	public Flux<Course> getAll() {
		return _courseRepo.findAll();
	}

	@Override
	public Mono<Course> save(Course course) {
		return _courseRepo.save(course);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return _courseRepo.deleteById(id);
	}

	@Override
	public Mono<Course> getById(String id) {
		return _courseRepo.findById(id);
	}

	@Override
	public Flux<Course> getByName(String name) {
		return _courseRepo.findByName(name);
	}

	@Override
	public Flux<Course> getByIdProfessor(String idProfessor) {
		return _courseRepo.findByIdProfessor(idProfessor);
	}

	@Override
	public Flux<Course> getByStatus(String status) {
		return _courseRepo.findByStatus(status);
	}

}

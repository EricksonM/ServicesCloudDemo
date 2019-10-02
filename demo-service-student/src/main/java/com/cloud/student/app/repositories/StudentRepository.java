package com.cloud.student.app.repositories;

import java.time.LocalDate;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.cloud.student.app.documents.Student;

import reactor.core.publisher.Flux;

@Repository
public interface StudentRepository extends ReactiveMongoRepository<Student, String>{

	public Flux<Student> findByFirstName(String firstName);
	public Flux<Student> findByBirthdayDateBetween(LocalDate date1, LocalDate date2);
}

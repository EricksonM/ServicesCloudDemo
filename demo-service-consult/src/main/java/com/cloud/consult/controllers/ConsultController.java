package com.cloud.consult.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.consult.documents.CourseProfessor;
import com.cloud.consult.documents.CourseQualify;
import com.cloud.consult.documents.CourseStudent;
import com.cloud.consult.documents.ProfessorCourse;
import com.cloud.consult.documents.StudentQualify;
import com.cloud.consult.documents.ProfessorFamily;
import com.cloud.consult.documents.StudentFamily;
import com.cloud.consult.services.ConsultServiceImpl;

@RestController
@RequestMapping("/consult")
public class ConsultController {

	@Autowired
	private ConsultServiceImpl _consultServ;
	
	@GetMapping("/professorCourse")
	public ResponseEntity<List<ProfessorCourse>> getAllProfessorCourse(){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_consultServ.getAllProfessorCourse());
	}
	
	@GetMapping("/studentQualify")
	public ResponseEntity<List<StudentQualify>> getAllStudentQualify(){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_consultServ.getAllStudentQualify());
	}
	
	@GetMapping("/studentFamily")
	public ResponseEntity<List<StudentFamily>> getAllStudentFamily(){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_consultServ.getAllStudentFamily());
	}
	
	@GetMapping("/professorFamily")
	public ResponseEntity<List<ProfessorFamily>> getAllProfessorFamily(){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_consultServ.getAllProfessorFamily());
	}
	
	@GetMapping("/courseProfessor")
	public ResponseEntity<List<CourseProfessor>> getAllCourseProfessor(){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_consultServ.getAllCourseProfessor());
	}
	
	@GetMapping("/courseQualify")
	public ResponseEntity<List<CourseQualify>> getAllCourseQualify(){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_consultServ.getAllCourseQualify());
	}
	
	@GetMapping("/courseStudent")
	public ResponseEntity<List<CourseStudent>> getAllCourseStudent(){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_consultServ.getAllCourseStudent());
	}
}







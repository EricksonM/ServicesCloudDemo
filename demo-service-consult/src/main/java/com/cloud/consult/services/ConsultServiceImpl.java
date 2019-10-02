package com.cloud.consult.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cloud.consult.documents.CourseProfessor;
import com.cloud.consult.documents.ProfessorCourse;
import com.cloud.consult.documents.StudentQualify;
import com.cloud.consult.documents.ProfessorFamily;
import com.cloud.consult.documents.StudentFamily;
import com.cloud.consult.documents.models.Course;
import com.cloud.consult.documents.models.Family;
import com.cloud.consult.documents.models.Professor;
import com.cloud.consult.documents.models.Qualify;
import com.cloud.consult.documents.models.Student;

@Service
public class ConsultServiceImpl implements IConsultService {

	@Autowired
	private RestTemplate clientRest;

	@Override
	public List<ProfessorCourse> getAllProfessorCourse() {

		List<Professor> professor = Arrays
				.asList(clientRest.getForObject("http://localhost:8603/professor/", Professor[].class));

		return professor.stream().map(p -> {
			List<Course> course = Arrays.asList(
					clientRest.getForObject("http://localhost:8604/course/idProfessor/" + p.getId(), Course[].class));
			return new ProfessorCourse(p, course);
		}).collect(Collectors.toList());

	}

	@Override
	public List<StudentQualify> getAllStudentQualify() {

		List<Student> student = Arrays
				.asList(clientRest.getForObject("http://localhost:8601/student/", Student[].class));
		
		return student.stream().map(st -> {
			List<Qualify> qualify = Arrays.asList(
					clientRest.getForObject("http://localhost:8605/qualify/idStudent/" + st.getId(), Qualify[].class));
			return new StudentQualify(st, qualify);
		}).collect(Collectors.toList());
	}

	@Override
	public List<StudentFamily> getAllStudentFamily() {
		
		List<Student> students = Arrays.asList(
				clientRest.getForObject("http://localhost:8601/student/", Student[].class));
		
		return students.stream().map(st -> {
			List<Family> listFamily = Arrays.asList(
					clientRest.getForObject("http://localhost:8602/family/idTitular/" + st.getId(), Family[].class));
			return new StudentFamily(st, listFamily);
		}).collect(Collectors.toList());
	}

	@Override
	public List<ProfessorFamily> getAllProfessorFamily() {
		List<Professor> professor = Arrays.asList(
				clientRest.getForObject("http://localhost:8603/professor/", Professor[].class));
		return professor.stream().map(p -> {
			List<Family> listFamily = Arrays.asList(
					clientRest.getForObject("http://localhost:8602/family/idTitular/" + p.getId(), Family[].class));
			return new ProfessorFamily(p, listFamily);
		}).collect(Collectors.toList());
	}

	@Override
	public List<CourseProfessor> getAllCourseProfessor() {
		List<Course> course = Arrays.asList(
				clientRest.getForObject("http://localhost:8604/course/", Course[].class));
		return course.stream().map(c -> {
			Professor professor = clientRest.getForObject("http://localhost:8603/professor/id/" + c.getIdProfessor(), Professor.class);
			return new CourseProfessor(c, professor);
		}).collect(Collectors.toList());
	}

}

package com.cloud.consult.services;

import java.util.List;

import com.cloud.consult.documents.CourseProfessor;
import com.cloud.consult.documents.CourseQualify;
import com.cloud.consult.documents.CourseStudent;
import com.cloud.consult.documents.ProfessorCourse;
import com.cloud.consult.documents.StudentQualify;
import com.cloud.consult.documents.ProfessorFamily;
import com.cloud.consult.documents.StudentFamily;

public interface IConsultService {

	public List<ProfessorCourse> getAllProfessorCourse();
	
	public List<StudentQualify> getAllStudentQualify();
	
	public List<StudentFamily> getAllStudentFamily();
	
	public List<ProfessorFamily> getAllProfessorFamily();
	
	public List<CourseProfessor> getAllCourseProfessor();
	
	public List<CourseQualify> getAllCourseQualify();
	
	public List<CourseStudent> getAllCourseStudent();
}

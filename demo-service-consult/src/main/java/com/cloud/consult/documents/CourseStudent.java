package com.cloud.consult.documents;

import java.util.List;

import com.cloud.consult.documents.models.Course;
import com.cloud.consult.documents.models.Qualify;
import com.cloud.consult.documents.models.Student;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseStudent {

	private Course course;
	private Qualify qualify;
	private List<Student> listStudent;

	public CourseStudent(Course course, List<Student> listStudent) {
		this.course = course;
		this.listStudent = listStudent;
	}

}

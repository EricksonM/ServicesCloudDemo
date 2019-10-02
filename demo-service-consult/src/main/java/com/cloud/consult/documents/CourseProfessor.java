package com.cloud.consult.documents;

import com.cloud.consult.documents.models.Course;
import com.cloud.consult.documents.models.Professor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseProfessor {

	private Course course;
	private Professor professor;
}

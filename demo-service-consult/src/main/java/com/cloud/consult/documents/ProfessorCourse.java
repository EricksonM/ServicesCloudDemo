package com.cloud.consult.documents;

import java.util.List;

import com.cloud.consult.documents.models.Course;
import com.cloud.consult.documents.models.Professor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorCourse {

	private Professor professor;
	private List<Course> listCourse;
}

package com.cloud.consult.documents;

import java.util.List;

import com.cloud.consult.documents.models.Family;
import com.cloud.consult.documents.models.Student;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentFamily {

	private Student student;
	private List<Family> listFamily;
}

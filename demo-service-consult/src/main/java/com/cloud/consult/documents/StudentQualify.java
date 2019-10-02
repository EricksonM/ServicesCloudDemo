package com.cloud.consult.documents;

import java.util.List;

import com.cloud.consult.documents.models.Qualify;
import com.cloud.consult.documents.models.Student;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentQualify {

	private Student student;
	private List<Qualify> listQualify;

}

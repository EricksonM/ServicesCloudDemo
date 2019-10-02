package com.cloud.consult.documents;

import java.util.List;

import com.cloud.consult.documents.models.Family;
import com.cloud.consult.documents.models.Professor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfessorFamily {

	private Professor professor;
	private List<Family> listFamily;
}

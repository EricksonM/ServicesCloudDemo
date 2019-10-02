package com.cloud.consult.documents.models;

import lombok.Data;

@Data
public class Course {

	private String id;
	private String name;
	private Integer min;
	private Integer max;
	private String idProfessor;
	private String status;

}

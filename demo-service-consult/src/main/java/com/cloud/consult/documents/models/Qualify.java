package com.cloud.consult.documents.models;

import lombok.Data;

@Data
public class Qualify {

	private String id;
	private String idStudent;
	private String idCourse;
	private Double qualification1;
	private Double qualification2;
	private Double qualification3;

	public Double getAverage() {
		return (qualification1.doubleValue() + qualification2.doubleValue() + qualification3.doubleValue()) / 3;
	}

}

package com.cloud.qualify.app.documents;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "qualify")
public class Qualify implements Serializable{

	@Id
	private String id;
	private String idStudent;
	private String idCourse;
	private Double qualification1;
	private Double qualification2;
	private Double qualification3;
	
	
	public Double getAverage() {
		return (qualification1.doubleValue() + qualification2.doubleValue() + qualification3.doubleValue())/3;
	}
	
	
	private static final long serialVersionUID = -5440946731146048986L;

}

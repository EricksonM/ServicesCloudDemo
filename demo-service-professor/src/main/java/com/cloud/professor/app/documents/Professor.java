package com.cloud.professor.app.documents;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
@Document(collection = "professor")
public class Professor implements Serializable{
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String gende;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate birthdayDate;
	private String docType;
	private String docNumber;
	
	
	private static final long serialVersionUID = 8620896436387155431L;

}

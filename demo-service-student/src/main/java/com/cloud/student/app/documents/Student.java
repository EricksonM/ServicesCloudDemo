package com.cloud.student.app.documents;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "Students")
public class Student implements Serializable{
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String gender;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate birthdayDate;
	private String docType;
	private String docNumber;
	
	
	private static final long serialVersionUID = -3863854162290934369L;

	
}

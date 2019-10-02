package com.cloud.family.app.documents;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
@Document(collection = "family")
public class Family implements Serializable{
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String gender;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate birthdayDate;
	private String docType;
	private String docNumber;
	private String idTitular;
	private String familyRelationship;
	
	
	
	private static final long serialVersionUID = -1084816190849119499L;

}

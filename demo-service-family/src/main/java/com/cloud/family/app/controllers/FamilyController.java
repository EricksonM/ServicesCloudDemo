package com.cloud.family.app.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.family.app.documents.Family;
import com.cloud.family.app.services.FamilyServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/family")
public class FamilyController {

	@Autowired
	private FamilyServiceImpl _familyServ;
	
	@GetMapping("/")
	public ResponseEntity<Flux<Family>> getAll(){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_familyServ.getAll());
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Mono<Family>> create(@RequestBody Family family){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_familyServ.save(family));
	}
	
	@PutMapping("/id/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Mono<Family>> update(@RequestBody Family family, @PathVariable String id){
		Mono<Family> familyDB = _familyServ.getById(id)
				.flatMap(fam ->{
					fam.setFirstName(family.getFirstName());
					fam.setLastName(family.getLastName());
					fam.setGender(family.getGender());
					fam.setBirthdayDate(family.getBirthdayDate());
					fam.setDocType(family.getDocType());
					fam.setDocNumber(family.getDocNumber());
					fam.setIdTitular(family.getIdTitular());
					fam.setFamilyRelationship(family.getFamilyRelationship());
					
					return _familyServ.save(fam);
				});
		
		
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(familyDB);
	}
	
	@DeleteMapping("/id/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> deleteById(@PathVariable String id) {
		return _familyServ.deleteById(id);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Mono<Family>> getById(@PathVariable String id){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_familyServ.getById(id));
	}
	
	@GetMapping("/name/{firstName}")
	public ResponseEntity<Flux<Family>> getByFirstName(@PathVariable String firstName){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_familyServ.getByFirstName(firstName));
	}
	
	@GetMapping("/dates/{date1}/{date2}")
	public ResponseEntity<Flux<Family>> getByBirthdayDate(@PathVariable @DateTimeFormat(iso = ISO.DATE) LocalDate date1,
														  @PathVariable @DateTimeFormat(iso = ISO.DATE) LocalDate date2){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_familyServ.getByBirthdayDateBetween(date1, date2));
	}
	
	@GetMapping("/idTitular/{idTitular}")
	public ResponseEntity<Flux<Family>> getByIdTitular(@PathVariable String idTitular){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_familyServ.getByIdTitular(idTitular));
	}
}













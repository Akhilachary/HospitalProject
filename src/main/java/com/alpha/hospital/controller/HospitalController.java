package com.alpha.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.hospital.dto.PatientDTO;
import com.alpha.hospital.dto.ResponseStructure;
import com.alpha.hospital.entity.Patient;
import com.alpha.hospital.service.HospitalService;

import jakarta.validation.Valid;

@RestController
public class HospitalController {

	@Autowired
	private HospitalService service;
	
	@PostMapping("/savePatient")
	public ResponseStructure<Patient> savePatient(@RequestBody PatientDTO patientdto) {
		return service.savePatient(patientdto);
	}
	
	@GetMapping("/findPatient")
	public ResponseStructure<Patient> findPatient(@RequestParam int id) {
		return service.findPatient(id);
	}
	
	@DeleteMapping("/deletePatient")
	public ResponseStructure<Patient> deletePatient(@RequestHeader int id) {
		return service.deletePatient(id);
	}
	
	@PutMapping("/updatePatient")
	public ResponseStructure<Patient> updatePatient(@RequestBody @Valid Patient patient) {
		return service.updatePatient(patient);
	}
}

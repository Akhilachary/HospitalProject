package com.alpha.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alpha.hospital.Exception.PatientNotFoundException;
import com.alpha.hospital.dto.PatientDTO;
import com.alpha.hospital.dto.ResponseStructure;
import com.alpha.hospital.entity.Patient;
import com.alpha.hospital.repository.HospitalRepository;

@Service
public class HospitalService {

	@Autowired
	private HospitalRepository repository;
	
	
	public ResponseStructure<Patient> savePatient(PatientDTO patientdto) {
		
		Patient patient = new Patient();
		patient.setName(patientdto.getName());
		patient.setAge(patientdto.getAge());
		patient.setMobile(patientdto.getPhone());
		patient.setDisease(patientdto.getDisease());
		repository.save(patient);
		
		ResponseStructure<Patient> responseStructure = new ResponseStructure<Patient>();
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Patient SAVED successfully.");
		responseStructure.setData(patient);
		return responseStructure;
	}
	
	public ResponseStructure<Patient> findPatient(int id) {
		Patient patient = repository.findById(id).orElseThrow(()-> new PatientNotFoundException());
		ResponseStructure<Patient> responseStructure = new ResponseStructure<Patient>();
		responseStructure.setStatuscode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Patient with id "+id+" FOUND");
		responseStructure.setData(patient);
		return responseStructure;

	}
	
	public ResponseStructure<Patient> deletePatient(int id) {
		
		Patient patient = repository.findById(id).orElseThrow(()-> new PatientNotFoundException());
		
		repository.deleteById(id);
		
		ResponseStructure<Patient> responseStructure = new ResponseStructure<Patient>();
		responseStructure.setStatuscode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Patient with id "+id+" DELETED");
		responseStructure.setData(patient);
		return responseStructure;
	}
	
	public ResponseStructure<Patient> updatePatient(Patient p) {
		
		Patient patient = repository.findById(p.getId()).orElseThrow(()-> new PatientNotFoundException());
		
		patient.setAge(p.getAge());
		patient.setMobile(p.getMobile());
		patient.setName(p.getName());
		
		repository.save(patient);
		
		ResponseStructure<Patient> responseStructure = new ResponseStructure<Patient>();
		responseStructure.setStatuscode(HttpStatus.ACCEPTED.value());
		responseStructure.setMessage("Patient UPDATED successfully.");
		responseStructure.setData(patient);
		return responseStructure;
	}
	

}

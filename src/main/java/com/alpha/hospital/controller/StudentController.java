package com.alpha.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.hospital.dto.ResponseStructure;
import com.alpha.hospital.entity.Student;
import com.alpha.hospital.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping("/saveStudent")
	public ResponseStructure<Student> saveStudent(@RequestBody @Valid Student s) {
		return service.saveStudent(s);
	}
	
	@GetMapping("/findStudent/{id}")
	public ResponseStructure<Student> findStudent(@PathVariable int id) {
		return service.findStudent(id);
	}
	
	@DeleteMapping("/deleteStudent")
	public ResponseStructure<Student> deleteStudent(@RequestParam int id){
		return service.deleteStudent(id)
	}
	
	@PutMapping("/updateStudent/assignCourse/{courseID}")
	public void updateStudent(@RequestHeader int stuID,@PathVariable int courseID) {
		service.updateStudent(stuID,courseID);
	}
	
}

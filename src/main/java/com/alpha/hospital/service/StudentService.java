package com.alpha.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alpha.hospital.Exception.CourseNotFoundException;
import com.alpha.hospital.Exception.StudentNotFoundException;
import com.alpha.hospital.dto.ResponseStructure;
import com.alpha.hospital.entity.Course;
import com.alpha.hospital.entity.Student;
import com.alpha.hospital.repository.CourseRepository;
import com.alpha.hospital.repository.StudentRepository;

import jakarta.validation.Valid;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

	public ResponseStructure<Student> saveStudent(@Valid Student s) {
		Student student = repository.save(s);
		ResponseStructure<Student> responseStructure = new ResponseStructure<Student>();
		responseStructure.setStatuscode(HttpStatus.ACCEPTED.value());
		responseStructure.setMessage("Student SAVED Successfully.");
		responseStructure.setData(student);
		return responseStructure;
		
	}

	public ResponseStructure<Student> findStudent(int id) {
		Student s = repository.findById(id).orElseThrow(()-> new StudentNotFoundException());
		ResponseStructure<Student> responseStructure = new ResponseStructure<Student>();
		responseStructure.setStatuscode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Student with id "+id+" FOUND");
		responseStructure.setData(s);
		return responseStructure;
		
		
	}
	
	public ResponseStructure<Student> deleteStudent(int id) {
		Student s = repository.findById(id).orElseThrow(()-> new StudentNotFoundException());
		repository.deleteById(id);
		ResponseStructure<Student> responseStructure = new ResponseStructure<Student>();
		responseStructure.setStatuscode(HttpStatus.ACCEPTED.value());
		responseStructure.setMessage("Student with id "+id+" DELETED.");
		responseStructure.setData(s);
		return responseStructure;
		
	}
	
	
	@Autowired
	CourseRepository courseRepository;
	public ResponseStructure<Student> updateStudent(int stuID, int courseID) {
		Student s = repository.findById(stuID).orElseThrow(()-> new StudentNotFoundException());
		Course c = courseRepository.findById(courseID).orElseThrow(()->new CourseNotFoundException());
		s.setCourse(c);
		ResponseStructure<Student> responseStructure = new ResponseStructure<Student>();
		responseStructure.setStatuscode(HttpStatus.ACCEPTED.value());
		responseStructure.setMessage("Student UPDATED.");
		responseStructure.setData(s);
		return responseStructure;
		
	}
	
	
	
	
}

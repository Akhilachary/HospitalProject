package com.alpha.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alpha.hospital.Exception.CourseNotFoundException;
import com.alpha.hospital.dto.ResponseStructure;
import com.alpha.hospital.entity.Course;
import com.alpha.hospital.repository.CourseRepository;

import jakarta.validation.Valid;

@Service
public class CourseService {

	@Autowired
	private CourseRepository repository;

	public ResponseStructure<Course> saveCourse(@Valid Course c) {
		Course course = repository.save(c);
		ResponseStructure<Course> responseStructure = new ResponseStructure<Course>();
		responseStructure.setStatuscode(HttpStatus.ACCEPTED.value());
		responseStructure.setMessage("Course SAVED Successfully.");
		responseStructure.setData(course);
		return responseStructure;
		
	}

	public ResponseStructure<Course> findCourse(int id) {
		Course c = repository.findById(id).orElseThrow(()-> new CourseNotFoundException());
		ResponseStructure<Course> responseStructure = new ResponseStructure<Course>();
		responseStructure.setStatuscode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Course with id "+id+" FOUND");
		responseStructure.setData(c);
		return responseStructure;
		
		
	}
	
	public ResponseStructure<Course> deleteStudent(int id) {
		Course c = repository.findById(id).orElseThrow(()-> new CourseNotFoundException());
		repository.deleteById(id);
		ResponseStructure<Course> responseStructure = new ResponseStructure<Course>();
		responseStructure.setStatuscode(HttpStatus.ACCEPTED.value());
		responseStructure.setMessage("Course with id "+id+" DELETED.");
		responseStructure.setData(c);
		return responseStructure;
		
	}
	

	public ResponseStructure<Course> updateStudent( int courseID,String name) {
		Course c = repository.findById(courseID).orElseThrow(()->new CourseNotFoundException());
		c.setSubject(name);
		ResponseStructure<Course> responseStructure = new ResponseStructure<Course>();
		responseStructure.setStatuscode(HttpStatus.ACCEPTED.value());
		responseStructure.setMessage("Course UPDATED.");
		responseStructure.setData(c);
		return responseStructure;
		
	}
}

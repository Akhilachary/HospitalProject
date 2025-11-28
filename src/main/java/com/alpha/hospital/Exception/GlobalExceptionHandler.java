package com.alpha.hospital.Exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alpha.hospital.dto.ResponseStructure;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseStructure<String> patientNotFoundException(PatientNotFoundException ex) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("PATIENT NOT FOUND");
		responseStructure.setData(ex.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(PatientAlreadyPresentException.class)
	public ResponseStructure<String> patientAlreadyPresentException(PatientAlreadyPresentException ex) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatuscode(HttpStatus.CONFLICT.value());
		responseStructure.setMessage("PATIENT ALREADY PRESENT");
		responseStructure.setData(ex.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseStructure<Map<String, String>> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
		
		List<FieldError> errors = ex.getFieldErrors();
		
		Map<String, String> map = new HashMap<String, String>();
		for (FieldError fieldError : errors) {
			map.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ResponseStructure<Map<String, String>> responseStructure = new ResponseStructure<Map<String, String>>();
		responseStructure.setStatuscode(HttpStatus.BAD_REQUEST.value());
		responseStructure.setMessage("METHOD ARGUMENT NOT VALID ");
		responseStructure.setData(map);
		return responseStructure;
	}
	
}

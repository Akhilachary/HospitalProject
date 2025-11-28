package com.alpha.hospital.dto;

import org.hibernate.validator.constraints.Length;


import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

public class PatientDTO {
	

	@Length(min = 3,max = 16)
	private String name;
	@Positive
	@Min(value = 18)
	private int age;
	@Digits(integer = 10, fraction = 0)
	private long phone;
	@Length(min = 2,max = 20)
	private String disease;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	
	public PatientDTO(@Length(min = 3, max = 16) String name, @Positive @Min(18) int age,
			@Digits(integer = 10, fraction = 0) long phone, @Length(min = 2, max = 20) String disease) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.disease = disease;
	}
	public PatientDTO() {
		super();
	}
	
	
	
	
}

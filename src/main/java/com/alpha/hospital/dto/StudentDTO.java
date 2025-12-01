package com.alpha.hospital.dto;

import org.hibernate.validator.constraints.Length;


import jakarta.validation.constraints.Min;

public class StudentDTO {

	@Length(min = 2,max = 20)
	private String name;
	@Min(value = 16)
	private int age;
	@Min(value = 60)
	private double mark;

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
	public double getMark() {
		return mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}
	public StudentDTO( @Length(min = 2, max = 20) String name, @Min(16) int age, @Min(60) double mark) {
		super();
		this.name = name;
		this.age = age;
		this.mark = mark;
	}
	public StudentDTO() {
		super();
	}
	
}

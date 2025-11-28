package com.alpha.hospital.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

@Entity
public class Patient {
	
	@Positive
	@Id
	private int id;
	@Length(min = 3,max = 16)
	private String name;
	@Positive
	@Min(value = 18)
	private int age;
	@Digits(integer = 10,fraction = 0)
	private long mobile;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public Patient(int id, String name, int age, long mobile) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.mobile = mobile;
	}
	public Patient() {
		super();
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", age=" + age + ", mobile=" + mobile + "]";
	}
	
	
	
}

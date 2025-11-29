package com.alpha.hospital.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Length(min = 3,max = 16)
	private String name;
	@Min(value = 18)
	private int age;
	@Digits(integer = 10,fraction = 0)
	private long mobile;
	private String disease;
	private String bloodGroup;
	private int bp;
	private int sugarlevel;
	
	
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public int getBp() {
		return bp;
	}
	public void setBp(int bp) {
		this.bp = bp;
	}
	public int getSugarlevel() {
		return sugarlevel;
	}
	public void setSugarlevel(int sugarlevel) {
		this.sugarlevel = sugarlevel;
	}
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
	
	public Patient(@Positive int id, @Length(min = 3, max = 16) String name, @Positive @Min(18) int age,
			@Digits(integer = 10, fraction = 0) long mobile, String disease, String bloodGroup, int bp,
			int sugarlevel) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.disease = disease;
		this.bloodGroup = bloodGroup;
		this.bp = bp;
		this.sugarlevel = sugarlevel;
	}
	public Patient() {
		super();
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", age=" + age + ", mobile=" + mobile + "]";
	}
	
	
	
}

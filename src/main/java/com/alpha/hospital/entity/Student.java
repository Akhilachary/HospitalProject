package com.alpha.hospital.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;

@Entity
public class Student {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Length(min = 2,max = 20)
	private String name;
	@Min(value = 16)
	private int age;
	@Min(value = 60)
	private double mark;
	@ManyToOne
	private Course course;

	public int getId() {
		return id;
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
	public double getMark() {
		return mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Student( @Length(min = 2, max = 20) String name, @Min(16) int age, @Min(60) double mark,
			Course course) {
		super();
		this.name = name;
		this.age = age;
		this.mark = mark;
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", mark=" + mark + ", course=" + course + "]";
	}
	
	
	
}

package com.alpha.hospital.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Positive;

@Entity
public class Course {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Length(min = 3,max = 20)
	private String subject;
	@Positive
	private double fees;
	@Length(min = 3,max = 20)
	private String trainer;
	
	
	public int getId() {
		return id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public String getTrainer() {
		return trainer;
	}
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	
	
	public Course(@Length(min = 3, max = 20) String subject, @Positive double fees,
			@Length(min = 3, max = 20) String trainer) {
		super();
		this.subject = subject;
		this.fees = fees;
		this.trainer = trainer;
	}
	
	
	public Course() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", subject=" + subject + ", fees=" + fees + ", trainer=" + trainer + "]";
	}
	
	
	
}

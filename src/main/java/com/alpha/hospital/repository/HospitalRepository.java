package com.alpha.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.hospital.entity.Patient;

public interface HospitalRepository extends JpaRepository<Patient, Integer>{

}

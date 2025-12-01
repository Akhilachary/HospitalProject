package com.alpha.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.hospital.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}

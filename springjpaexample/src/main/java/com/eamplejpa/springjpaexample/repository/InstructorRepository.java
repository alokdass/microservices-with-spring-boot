package com.eamplejpa.springjpaexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eamplejpa.springjpaexample.model.Instructor;


@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long>{

}
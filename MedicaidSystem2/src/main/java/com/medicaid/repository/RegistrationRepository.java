package com.medicaid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicaid.model.Doctor;



@Repository
public interface RegistrationRepository extends JpaRepository<Doctor, Integer>{
 public Doctor findByEmailId(String emailId);
 
 public Doctor findByEmailIdAndPasswordAndRole(String emailId,String password,String role );
 
 
 }

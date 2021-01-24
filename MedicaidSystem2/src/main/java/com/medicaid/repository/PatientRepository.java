package com.medicaid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicaid.model.History;

@Repository
public interface PatientRepository extends JpaRepository<History,Long>{

}


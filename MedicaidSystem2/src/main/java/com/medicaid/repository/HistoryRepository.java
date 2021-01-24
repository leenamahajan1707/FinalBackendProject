package com.medicaid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medicaid.model.History;
import com.medicaid.model.Patient;

@Repository
public interface HistoryRepository extends JpaRepository<History,Long>{

	List<History> findByPatient( Patient patient);
//
//	@Query("select * from history h where h.patient_id =:patient_id ")
//	List<History> getHistoryList(@Param("patient_id") long patient_id);

	

}


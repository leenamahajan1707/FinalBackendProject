package com.medicaid.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicaid.model.History;
import com.medicaid.repository.HistoryRepository;


public interface HistoryService {

	History storePatientHistory(History history);
	 //public void storePatientHistory(History history);
	 //public List<History> getPatientHistory();

	Optional<History> getPatientHistory(long patient_id);

	List<History> getHistoryList(long patient_id);
	
}

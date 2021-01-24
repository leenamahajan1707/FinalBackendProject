package com.medicaid.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicaid.model.History;
import com.medicaid.model.Patient;
import com.medicaid.repository.HistoryRepository;
import com.medicaid.repository.RegPatientRepository;

@Service
public class HistoryServiceImple implements HistoryService {
	
	@Autowired
	private HistoryRepository historyRepository;
	@Autowired
	private RegPatientRepository regPatientRepository;

	@Override
	public History storePatientHistory(History history)
	{
		Optional<Patient> patient1 = regPatientRepository.findById(history.getPatient_id());
		Patient patient =null;
		if(patient1.isPresent())
		{
			patient = patient1.get();
		}
		history.setPatient(patient);
		return historyRepository.save(history);
		
	}

	@Override
	public Optional<History> getPatientHistory(long patient_id) {
		
		return historyRepository.findById(patient_id);
	}

	@Override
	public List<History> getHistoryList(long patient_id) {
		Patient patient = null; 
		Optional<Patient> data = regPatientRepository.findById(patient_id);
		if(data.isPresent())
		{
			patient = data.get();
			
		}
		
		//return historyRepository.getHistoryList(patient_id);
		return historyRepository.findByPatient(patient);
	}

}



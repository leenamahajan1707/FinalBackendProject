package com.medicaid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicaid.model.History;
import com.medicaid.model.Patient;
import com.medicaid.repository.DoctorSearchRepository;

@Service
public class DoctorSearchServiceImple implements DoctorSearchService{
	
	@Autowired
	private DoctorSearchRepository doctorSearchRepository;

//	@Override
//	public List<History> getPatient(String pname, String psurname, String mobno) {
//		return doctorSearchRepository.getPatientByNnameAndSurnameAndMobno(pname, psurname, mobno);
//	}
	
	@Override
	public List<Patient> getPatient(String pname, String psurname, String mobno) {
		return doctorSearchRepository.getPatientByNnameAndSurnameAndMobno(pname, psurname, mobno);
	}

	@Override
	public List<Patient> getPatient(String pname, String psurname) {
		// TODO Auto-generated method stub
		return doctorSearchRepository.findByPnameAndPsurname(pname, psurname);
	}

	@Override
	public List<Patient> getPatient(String pname) {
		// TODO Auto-generated method stub
		return doctorSearchRepository.findByPname(pname);
	}

	@Override
	public List<Patient> getPatientbyNameOrSurname(String pname, String psurname) {
		// TODO Auto-generated method stub
		return doctorSearchRepository.findByPnameOrPsurname(pname, psurname);
	}
	
}

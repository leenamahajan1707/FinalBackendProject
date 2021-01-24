package com.medicaid.service;

import java.util.List;

import com.medicaid.model.History;
import com.medicaid.model.Patient;

public interface DoctorSearchService {

//	List<History> getPatient(String pname, String psurname, String mobno);
	List<Patient> getPatient(String pname, String psurname, String mobno);

	List<Patient> getPatient(String pname, String psurname);

	List<Patient> getPatient(String pname);

	List<Patient> getPatientbyNameOrSurname(String pname, String psurname);

}

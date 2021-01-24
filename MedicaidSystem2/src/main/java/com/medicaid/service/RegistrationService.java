package com.medicaid.service;

import com.medicaid.model.Doctor;
import com.medicaid.model.Patient;

public interface RegistrationService {

	Doctor savePatient(Doctor doctor);


	Doctor fetchPatientByEmailId(String tempEmailId);


	Object fetchPatientById(int id);


	Doctor FindUserForLogin(String tempEmailId, String tempPassword, String tempRole);


	

}

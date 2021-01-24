package com.medicaid.service;



import java.util.List;
import java.util.Optional;

import com.medicaid.model.Patient;

public interface RegPatientService {

	Patient insertPatient(Patient patient);

	Patient FindUserForLogin(String tempEmailId, String tempPassword, String tempRole);

	
	void modifyPassword(String emailId, String password);

	Optional<Patient> getPatientById(long patient_id);

	Patient fetchPatientByEmailId(String emailId);

	void updatePassword(String emailId,String password);

	void saveOtp(String to,int otp);

	void saveOtpValidate(String to, int otpValidate);



}

package com.medicaid.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicaid.model.Patient;
import com.medicaid.repository.RegPatientRepository;

@Service
public class RegPatientServiceImple implements RegPatientService {

	@Autowired
	private RegPatientRepository regPatientRepository;
	@Override
	public Patient insertPatient(Patient patient) {
		return regPatientRepository.save(patient);
		
		
	}
	@Override
	public Patient FindUserForLogin(String tempEmailId, String tempPassword, String tempRole) {
		return regPatientRepository.findByEmailIdAndPasswordAndRole(tempEmailId, tempPassword, tempRole);
		
	}
	
	
	@Override
	public void modifyPassword(String emailId, String password) {
		System.out.println("email"+emailId+"pass"+password);
		regPatientRepository.updatePassword(emailId, password);
		
	}
	@Override
	public Optional<Patient> getPatientById(long patient_id) {
		return regPatientRepository.findById(patient_id);
	}
	
	
	
	public Patient fetchPatientByEmailId(String emailId) {
		 return regPatientRepository.findByEmailId(emailId);
	}
	
	public Patient fetchPatientByEmailIdAndPassword(String emailId,String password) {
		 return regPatientRepository.findByEmailIdAndPassword(emailId, password);
	}
	
	@Override
	public void updatePassword(String emailId, String password) {
		System.out.println(" email "+emailId+" , pass "+password);
		 regPatientRepository.updatePassword(emailId, password);
	}
	
	@Override
	public void saveOtp(String to, int otp) {
		regPatientRepository.saveOtp(to,otp);
		
	}
	@Override
	public void saveOtpValidate(String to, int otpValidate) {
		regPatientRepository.saveOtpValidate(to,otpValidate);
		
	}
	
	
	

}

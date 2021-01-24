package com.medicaid.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicaid.model.Doctor;
import com.medicaid.repository.RegistrationRepository;

@Service
public class RegistrationServiceImple implements RegistrationService {
	@Autowired
	private RegistrationRepository registrationRepository;

	
	
	public Doctor savePatient(Doctor doctor) {
		 return registrationRepository.save(doctor);
	}
	
	public Doctor fetchPatientByEmailId(String emailId) {
		 return registrationRepository.findByEmailId(emailId);
	}
	public Optional<Doctor> fetchPatientById(int id) {
		return registrationRepository.findById(id);
	}

	@Override
	public Doctor FindUserForLogin(String tempEmailId, String tempPassword, String tempRole) {
		return registrationRepository.findByEmailIdAndPasswordAndRole(tempEmailId, tempPassword, tempRole);
	}

}

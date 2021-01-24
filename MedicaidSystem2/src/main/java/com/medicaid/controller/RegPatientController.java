package com.medicaid.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicaid.email.SmtpMailSender;
import com.medicaid.model.History;
import com.medicaid.model.Patient;
import com.medicaid.service.RegPatientService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RegPatientController {
	
	@Autowired
	private SmtpMailSender smtpMailSender;
	
//	public int id;
	
	public Patient updatedPatient;
	
//	public int getId() {
//		return id;
//	}
//
//	protected void setId(int id) {
//		this.id = id;
//	}

	
	@Autowired
	private RegPatientService regPatientService;
	
	
	 @PostMapping("/registerPatient")
	  public Patient insertUser(@RequestBody Patient patient)
	  {
		  System.out.println(patient.toString());
		  return regPatientService.insertPatient(patient);
		 
	  }
	 
	 
	 
	  @PostMapping(value="/loginPatient")
	  public Patient LoginUser(@RequestBody Patient patient) throws Exception
	  {
		  String tempEmailId=patient.getEmailId();
		  String tempPassword=patient.getPassword();
		  String tempRole=patient.getRole();
		  
		 // System.out.println(t);
		  Patient patientObj=null;
		  
		  if(tempEmailId != null && tempPassword != null && (tempRole != null || tempRole == "Patient"))
		  {
			 // System.out.println(tempRole);
			  return patientObj=regPatientService.FindUserForLogin(tempEmailId, tempPassword, tempRole);
		  }
		  
		  if(patientObj == null)
		  {
			  throw new Exception("Invalid credentilas");
		  }
		  
		  System.out.println(patientObj.toString());
		  
		   return patientObj;
	  }
	  
	  // update password 
	   
	  
	
	  @GetMapping(value = "/updatePassword/{emailId}/{password}")
		public void PassUpdate(@PathVariable("emailId") String emailId,@PathVariable("password") String password) {
		 
		  System.out.println(emailId);
		  System.out.println(password);
		  regPatientService.modifyPassword(emailId,password); 
			
		}	
	  
	  @GetMapping("/getPatient/{patient_id}")
		public Optional<Patient> getPatient(@PathVariable("patient_id") long patient_id )
		{
			return regPatientService.getPatientById(patient_id);
		  
		}
	  
	  // Forget Password Otp email
	  
	  @GetMapping("/validateEmail/{emailId}")
		public boolean fetchPatientById(@PathVariable String emailId) {
			 Patient patient = new Patient();
			patient= regPatientService.fetchPatientByEmailId(emailId);
			
			 updatedPatient = patient;
			
			 regPatientService.insertPatient(updatedPatient);
			
	          return true;
		}
		
		
		@GetMapping("/updatePassword/{emailId}/{password}/{otp}")
		public boolean PassUpdate(@PathVariable("emailId") String emailId,@PathVariable String password, @PathVariable int otp) {
			
			Patient pdata = regPatientService.fetchPatientByEmailId(emailId);
				
				if(otp == pdata.getOtp()) {
				
				 regPatientService.updatePassword(emailId,password);
				}
				else
				{
					return false;
				}
				
			return true;
			
			
		}
		
		
//	validate Otp of Patient
		@GetMapping("/validateOtp/{emailId}/{otpValidate}")
		public boolean validateOtp(@PathVariable("emailId") String emailId, @PathVariable int otpValidate) {
			
			Patient pdata = regPatientService.fetchPatientByEmailId(emailId);
			System.out.println("====="+otpValidate);
			System.out.println(pdata.getOtpValidate());
				
				if(otpValidate == pdata.getOtpValidate()) {
				
				 return true;
				}
				
					return false;
				
							
		}

		

}
	
	


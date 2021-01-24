package com.medicaid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicaid.model.Doctor;
import com.medicaid.model.Patient;
import com.medicaid.service.RegistrationService;


@CrossOrigin(origins = "*")
@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	//patient-registration//
	@PostMapping("/registerDoctor")
	public Doctor registerPatient(@RequestBody Doctor doctor) throws Exception {
		String tempEmailId = doctor.getEmailId();
		if(tempEmailId !=null && !"".equals(tempEmailId)) {
			Doctor drObj = registrationService.fetchPatientByEmailId(tempEmailId);
			if(drObj !=null)
			{
				throw new Exception("Patient with this email-id already exists");
				
			}
		}
		Doctor drObj = null;
		drObj = registrationService.savePatient(doctor);
		return drObj;
	}
	
	
	@PostMapping(value="/loginDoctor")
	  public Doctor LoginUser(@RequestBody Doctor doctor) throws Exception
	  {
			System.out.println(doctor);
		  String tempEmailId=doctor.getEmailId();
		  String tempPassword=doctor.getPassword();
		  String tempRole=doctor.getRole();
		  
		 // System.out.println(t);
		  Doctor doctorObj=null;
		  
		  if(tempEmailId != null && tempPassword != null && (tempRole != null || tempRole == "Doctor"))
		  {
			 // System.out.println(tempRole);
			  return doctorObj=registrationService.FindUserForLogin(tempEmailId, tempPassword, tempRole);
		  }
		  
		  if(doctorObj == null)
		  {
			  throw new Exception("Invalid credentilas");
		  }
		  
		  System.out.println(doctorObj.toString());
		  
		   return doctorObj;
	  }
	
	
	/*private List<Doctor> createList() {
		// TODO Auto-generated method stub
		return null;
	}*/


//	//view details//
//	@GetMapping("/getproductbyid/{id}")
//	public Doctor fetchPatientById(@PathVariable int id) {
//	return  registrationService.fetchPatientById(id)).get();
	//}

}




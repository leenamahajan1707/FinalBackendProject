package com.medicaid.email;

import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicaid.service.RegPatientService;


@CrossOrigin
@RestController
public class RootController {

	SmtpMailSender smtp = new SmtpMailSender();
	
	@Autowired
	private SmtpMailSender smtpMailSender;
	
	@Autowired
	private SmtpMailSender2 smtpMailSender2;
	
	@Autowired
	private RegPatientService regPatientService;

	//@PostMapping("/sendmail")
	//@RequestMapping(name = "/sendmail", method = RequestMethod.GET)
	@GetMapping("/sendmail/{emailId}")
	public boolean sendMail(@PathVariable("emailId") String emailId ) throws MessagingException {
		
		smtpMailSender.send(emailId, "Smart Cognitive Medicaid System ", "Your OTP is:");
		return true;
					
	}
	
	//for validating Patient
	@GetMapping("/sendotpmail/{emailId}")
	public boolean sendOtpMail(@PathVariable("emailId") String emailId ) throws MessagingException {
		System.out.println(emailId);		
		smtpMailSender2.send(emailId, "Smart Cognitive Medicaid System ", "Your OTP is:");
		
		
		return true;
			
		
	}
	

	
	/*@PutMapping("/updatepatient/{emailId}")
	public boolean fetchPatientById(@PathVariable String emailId) {
		 Patient patient = new Patient();
		patient= service.fetchPatientByEmailId(emailId);
		
		if(patient.getEmailId() != null)
		{
			patient.setPassword("Test");
		}
		Patient updatedPatient = patient;
		
		service.savePatient(updatedPatient);
		
          return true;
	}*/
	//@RequestMapping(value = "/login", method = RequestMethod.POST)
	//public @ResponseBody String postLogin(String user) {
		//String userName = null;
		//if(user !=null) {
		  // userName = user.trim();
		//}
		//return userName;

}

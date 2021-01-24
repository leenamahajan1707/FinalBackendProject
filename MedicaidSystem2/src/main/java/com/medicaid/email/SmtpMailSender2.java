package com.medicaid.email;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.medicaid.service.RegPatientService;


@Component
public class SmtpMailSender2 {
		
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired 
	private RegPatientService regPatientService;
	
	public int otpValidate;
	

	public int getOtpValidate() {
		return otpValidate;
	}


	public void setOtpValidate(int otpValidate) {
		this.otpValidate = otpValidate;
	}


	public void send(String to, String subject, String body) throws MessagingException {
		 MimeMessage message = javaMailSender.createMimeMessage();
		 Random random =new Random();
		 this.setOtpValidate(random.nextInt(1000));
		 MimeMessageHelper helper;
		 
		 regPatientService.saveOtpValidate(to,otpValidate);
		 
		 helper = new MimeMessageHelper(message, true); // true indicates
		   // multipart message
         helper.setSubject(subject);
         helper.setTo(to);
         helper.setText(body+this.getOtpValidate(), true); // true indicates html
// continue using helper object for more functionalities like adding attachments, etc.  

         javaMailSender.send(message);
	}
	
	
	private void saveOtp(String to, int otp2) {
		// TODO Auto-generated method stub
		
	}

	public int add (int a, int b)
	{
		return a + b;
	}

}

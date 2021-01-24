package com.medicaid.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicaid.model.History;
import com.medicaid.model.Patient;
import com.medicaid.repository.DoctorSearchRepository;
import com.medicaid.repository.HistoryRepository;
import com.medicaid.service.DoctorSearchService;
import com.medicaid.service.RegPatientService;

//s@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/psearch/")
public class DoctorSearchController {
	
	@Autowired
	private DoctorSearchService doctorSearchService;
	
	
	
	//search patient
//	@GetMapping("/doctorsearch/{pname}/{psurname}/{mobno}")
//	public List<History> getHistory(@PathVariable("pname") String pname,@PathVariable("psurname") String psurname,@PathVariable("mobno") String mobno)
//	{
//		System.out.println(pname+" , "+psurname+" , "+mobno);
//		return doctorSearchService.getPatient(pname, psurname, mobno);
//	}
	
//	@GetMapping("/doctorsearch/{pname}/{psurname}/{mobno}")
//	public List<Patient> getHistory(@PathVariable("pname") String pname,@PathVariable("psurname") String psurname,@PathVariable("mobno") String mobno)
//	{
//		System.out.println(pname+" , "+psurname+" , "+mobno);
//		return doctorSearchService.getPatient(pname, psurname, mobno);
//	}
	
	@GetMapping("/doctorsearch/{pname}")
	public List<Patient> getHistory(@PathVariable("pname") String pname )
	{
		if(pname.contains(" "))
		{
			String[] arrOfStr = pname.split(" ");
	        for (String a: arrOfStr)
	            System.out.println("----"+a);
	        pname = arrOfStr[0];
	        String psurname = arrOfStr[1];
	        System.out.println("+++++++"+arrOfStr[0]+"  "+arrOfStr[1]);
	        return doctorSearchService.getPatient(pname, psurname);
		}
		else
		{
			String psurname = pname;
			System.out.println("====="+pname+" "+psurname);
			return doctorSearchService.getPatientbyNameOrSurname(pname,psurname);
		}
	}
	
	
	
	
}

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
import com.medicaid.repository.HistoryRepository;
import com.medicaid.service.HistoryService;

@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class HistoryController {
	
	@Autowired
	private HistoryService historyService;
	
	// create history rest API
	@PostMapping("/history")
	public History createHistory(@RequestBody History history)
	{
		System.out.println(history);
		return historyService.storePatientHistory(history);
	}
	
	//get all History
//	@GetMapping("history/{patient_id}")
//	public Optional<History> getHistory(@PathVariable("patient_id") long patient_id)
//	{
//		return historyService.getPatientHistory(patient_id);
//	}
	
	@GetMapping("history/{patient_id}")
	public List<History> getHistoryList(@PathVariable("patient_id") long patient_id )
	{
		
	        return historyService.getHistoryList(patient_id);
		
	}
	
	
	
	

	
}

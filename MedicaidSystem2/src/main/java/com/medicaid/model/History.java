package com.medicaid.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "history")
public class History {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pid;
	private String pname;
	private String psurname;
	private int age;
	private String mob_no;
	private String date_visited;
	private String reason_for_visit;
	private String symptoms;
	private String medicine_Prescribed;
	private String allergy_if_any;
	private String is_admitted;
	private String date_of_admitted;
	private String date_of_released;
	private String test_Done;
	//private String testReport;
	private String hosp_name;
	private String doctor_Name;
	private String doctor_Designation;
	private String hosp_address;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	@Transient
	private long patient_id;
	
	

	public History() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public History(Long pid, String pname, String psurname, int age, String mob_no, String date_visited,
			String reason_for_visit, String symptoms, String medicine_Prescribed, String allergy_if_any,
			String is_admitted, String date_of_admitted, String date_of_released, String test_Done, String hosp_name,
			String doctor_Name, String doctor_Designation, String hosp_address, Patient patient, long patient_id) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.psurname = psurname;
		this.age = age;
		this.mob_no = mob_no;
		this.date_visited = date_visited;
		this.reason_for_visit = reason_for_visit;
		this.symptoms = symptoms;
		this.medicine_Prescribed = medicine_Prescribed;
		this.allergy_if_any = allergy_if_any;
		this.is_admitted = is_admitted;
		this.date_of_admitted = date_of_admitted;
		this.date_of_released = date_of_released;
		this.test_Done = test_Done;
		this.hosp_name = hosp_name;
		this.doctor_Name = doctor_Name;
		this.doctor_Designation = doctor_Designation;
		this.hosp_address = hosp_address;
		this.patient = patient;
		this.patient_id = patient_id;
	}



	public Long getPid() {
		return pid;
	}


	public void setPid(Long pid) {
		this.pid = pid;
	}


	public String getPsurname() {
		return psurname;
	}


	public void setPsurname(String psurname) {
		this.psurname = psurname;
	}

	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMob_no() {
		return mob_no;
	}
	public void setMob_no(String mob_no) {
		this.mob_no = mob_no;
	}
	public String getDate_visited() {
		return date_visited;
	}
	public void setDate_visited(String date_visited) {
		this.date_visited = date_visited;
	}
	public String getReason_for_visit() {
		return reason_for_visit;
	}
	public void setReason_for_visit(String reason_for_visit) {
		this.reason_for_visit = reason_for_visit;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	public String getMedicine_Prescribed() {
		return medicine_Prescribed;
	}
	public void setMedicine_Prescribed(String medicine_Prescribed) {
		this.medicine_Prescribed = medicine_Prescribed;
	}
	public String getAllergy_if_any() {
		return allergy_if_any;
	}
	public void setAllergy_if_any(String allergy_if_any) {
		this.allergy_if_any = allergy_if_any;
	}
	public String getIs_admitted() {
		return is_admitted;
	}
	public void setIs_admitted(String is_admitted) {
		this.is_admitted = is_admitted;
	}
	public String getDate_of_admitted() {
		return date_of_admitted;
	}
	public void setDate_of_admitted(String date_of_admitted) {
		this.date_of_admitted = date_of_admitted;
	}
	public String getDate_of_released() {
		return date_of_released;
	}
	public void setDate_of_released(String date_of_released) {
		this.date_of_released = date_of_released;
	}
	public String getTest_Done() {
		return test_Done;
	}
	public void setTest_Done(String test_Done) {
		this.test_Done = test_Done;
	}
	public String getHosp_name() {
		return hosp_name;
	}
	public void setHosp_name(String hosp_name) {
		this.hosp_name = hosp_name;
	}
	public String getDoctor_Name() {
		return doctor_Name;
	}
	public void setDoctor_Name(String doctor_Name) {
		this.doctor_Name = doctor_Name;
	}
	public String getDoctor_Designation() {
		return doctor_Designation;
	}
	public void setDoctor_Designation(String doctor_Designation) {
		this.doctor_Designation = doctor_Designation;
	}
	public String getHosp_address() {
		return hosp_address;
	}
	public void setHosp_address(String hosp_address) {
		this.hosp_address = hosp_address;
	}
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public long getPatient_id() {
		return patient_id;
	}


	public void setPatient_id(long patient_id) {
		this.patient_id = patient_id;
	}



	@Override
	public String toString() {
		return "History [pid=" + pid + ", pname=" + pname + ", psurname=" + psurname + ", age=" + age + ", mob_no="
				+ mob_no + ", date_visited=" + date_visited + ", reason_for_visit=" + reason_for_visit + ", symptoms="
				+ symptoms + ", medicine_Prescribed=" + medicine_Prescribed + ", allergy_if_any=" + allergy_if_any
				+ ", is_admitted=" + is_admitted + ", date_of_admitted=" + date_of_admitted + ", date_of_released="
				+ date_of_released + ", test_Done=" + test_Done + ", hosp_name=" + hosp_name + ", doctor_Name="
				+ doctor_Name + ", doctor_Designation=" + doctor_Designation + ", hosp_address=" + hosp_address
				+ ", patient=" + patient + ", patient_id=" + patient_id + ", getPid()=" + getPid() + ", getPsurname()="
				+ getPsurname() + ", getPname()=" + getPname() + ", getAge()=" + getAge() + ", getMob_no()="
				+ getMob_no() + ", getDate_visited()=" + getDate_visited() + ", getReason_for_visit()="
				+ getReason_for_visit() + ", getSymptoms()=" + getSymptoms() + ", getMedicine_Prescribed()="
				+ getMedicine_Prescribed() + ", getAllergy_if_any()=" + getAllergy_if_any() + ", getIs_admitted()="
				+ getIs_admitted() + ", getDate_of_admitted()=" + getDate_of_admitted() + ", getDate_of_released()="
				+ getDate_of_released() + ", getTest_Done()=" + getTest_Done() + ", getHosp_name()=" + getHosp_name()
				+ ", getDoctor_Name()=" + getDoctor_Name() + ", getDoctor_Designation()=" + getDoctor_Designation()
				+ ", getHosp_address()=" + getHosp_address() + ", getPatient()=" + getPatient() + ", getPatient_id()="
				+ getPatient_id() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}


	
	
	
	
}

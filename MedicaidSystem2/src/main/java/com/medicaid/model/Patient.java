package com.medicaid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="patient",uniqueConstraints=@UniqueConstraint(columnNames={"emailId"}))

public class Patient {
	 	@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long patient_id;
	 	
		@Column(name = "pname",nullable = false)
		private String pname;
		
		@Column(name = "psurname",nullable = false)
		private String psurname;
		
		@Column(name = "age",nullable = false)
		private int age;
	
		@Column(name = "parent_name",nullable = false)
		private String parent_name;
		
		@Column(name = "mob_no",nullable = false)
		private String mob_no;
		
		 @Column(name = "emailId", length=128, unique=true ,nullable = false)
		 
		private String emailId;
		
		 @Column(name = "password",nullable = false)
		private String password;
		
		 @Column(name = "role",nullable = false)
		private String role;
		 
		 private int otp;
		 
		 private int otpValidate;

		public Patient() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Patient(long patient_id, String pname, String psurname, int age, String parent_name, String mob_no,
				String emailId, String password, String role) {
			super();
			this.patient_id = patient_id;
			this.pname = pname;
			this.psurname = psurname;
			this.age = age;
			this.parent_name = parent_name;
			this.mob_no = mob_no;
			this.emailId = emailId;
			this.password = password;
			this.role = role;
		}

		public long getPatient_id() {
			return patient_id;
		}

		public void setPatient_id(long patient_id) {
			this.patient_id = patient_id;
		}

		public String getPname() {
			return pname;
		}

		public void setPname(String pname) {
			this.pname = pname;
		}

		public String getPsurname() {
			return psurname;
		}

		public void setPsurname(String psurname) {
			this.psurname = psurname;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getParent_name() {
			return parent_name;
		}

		public void setParent_name(String parent_name) {
			this.parent_name = parent_name;
		}

		public String getMob_no() {
			return mob_no;
		}

		public void setMob_no(String mob_no) {
			this.mob_no = mob_no;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}
		

		public int getOtp() {
			return otp;
		}

		public void setOtp(int otp) {
			this.otp = otp;
		}

		
		public int getOtpValidate() {
			return otpValidate;
		}

		public void setOtpValidate(int otpValidate) {
			this.otpValidate = otpValidate;
		}

		@Override
		public String toString() {
			return "Patient [patient_id=" + patient_id + ", pname=" + pname + ", psurname=" + psurname + ", age=" + age
					+ ", parent_name=" + parent_name + ", mob_no=" + mob_no + ", emailId=" + emailId + ", password="
					+ password + ", role=" + role + "]";
		}
		
		
		
}




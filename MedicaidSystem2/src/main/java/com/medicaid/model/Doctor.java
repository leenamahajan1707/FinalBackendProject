package com.medicaid.model;

import javax.persistence.*;

@Entity
public class Doctor {
	
		@Id
		private int id;
				
		@Column(name = "emailId", length=128, unique=true ,nullable = false)
		private String emailId;
		
		@Column(name = "password",nullable = false)
		private String password;
		
		@Column(name = "role",nullable = false)
		private String role;

		
		
		public Doctor() {
			super();
			// TODO Auto-generated constructor stub
		}



		public Doctor(int id, String emailId, String password, String role) {
			super();
			this.id = id;
			this.emailId = emailId;
			this.password = password;
			this.role = role;
		}



		public int getId() {
			return id;
		}



		public void setId(int id) {
			this.id = id;
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



		@Override
		public String toString() {
			return "Doctor [id=" + id + ", emailId=" + emailId + ", password=" + password + ", role=" + role + "]";
		}

		

}







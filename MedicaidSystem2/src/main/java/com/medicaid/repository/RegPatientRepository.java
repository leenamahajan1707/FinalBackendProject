package com.medicaid.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medicaid.model.History;
import com.medicaid.model.Patient;

@Repository
public interface RegPatientRepository extends JpaRepository<Patient,Long> {
	public Patient findByEmailIdAndPasswordAndRole(String emailId,String password,String role );
	
	@Modifying
	@Transactional
	@Query("update Patient p set p.password =:password where p.emailId =:emailId")
	public void updatePassword(@Param("emailId") String emailId ,@Param("password") String password);
	
	public Patient findByEmailId(String emailId);
	 public Patient findByEmailIdAndPassword(String emailId, String password);

	 @Modifying
	@Transactional
	 @Query("update Patient p set p.otp =:otp where p.emailId =:email")
	public void saveOtp(@Param("email")String to, @Param("otp") int otp);
	 
	 @Modifying
		@Transactional
		 @Query("update Patient p set p.otpValidate =:otpValidate where p.emailId =:email")
		public void saveOtpValidate(@Param("email")String to, @Param("otpValidate") int otpValidate);
	
}


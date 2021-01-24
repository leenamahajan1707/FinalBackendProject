package com.medicaid.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.medicaid.model.History;
import com.medicaid.model.Patient;



@Repository
public interface DoctorSearchRepository extends JpaRepository<Patient,Long> {
	
//	@Query(value="select * from history h where h.pname =:name and h.psurname =:surname and h.mob_no =:mob ",nativeQuery = true)
//	public List<History> getPatientByNnameAndSurnameAndMobno(@Param("name") String pname, @Param("surname") String psurname,@Param("mob") String mobno);
//	
	@Query(value="select * from Patient p where p.pname =:name and p.psurname =:surname and p.mob_no =:mob ",nativeQuery = true)
	public List<Patient> getPatientByNnameAndSurnameAndMobno(@Param("name") String pname, @Param("surname") String psurname,@Param("mob") String mobno);

//	@Query(value="select * from Patient p where p.pname =:name and p.psurname =:surname ",nativeQuery = true)
//	public List<Patient> getPatientByNnameAndSurname(@Param("name") String pname, @Param("surname") String psurname);

	public List<Patient> findByPnameAndPsurname(String pname,String psurname);

	public List<Patient> findByPname(String pname);

	public List<Patient> findByPnameOrPsurname(String pname, String psurname);
}

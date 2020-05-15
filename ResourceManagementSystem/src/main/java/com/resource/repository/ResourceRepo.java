package com.resource.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.resource.model.Resources;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Repository
@Transactional
public interface ResourceRepo extends JpaRepository<Resources, String> {
	Optional<Resources> findByEmailId(String emailId);
	public Resources findByEmployeeId(String employeeId);

	@Modifying
	@Query("UPDATE Resources r SET r.password = :pass WHERE r.emailId = :email")
	void updatePassword(@Param("pass") String password,@Param("email") String emailId);

	@Query("select r from Resources r where r.status= :sts and r.type= :typ and r.officeCity= :city")
	List<Resources> filter(@Param("sts") String status, @Param("typ") String type, @Param("city") String officeCity);
}

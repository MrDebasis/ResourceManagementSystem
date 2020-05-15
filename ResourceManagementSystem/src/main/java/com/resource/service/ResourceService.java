package com.resource.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.resource.constant.ConstantKeys;
import com.resource.model.Resources;
import com.resource.repository.ResourceRepo;


@Service
@Transactional
public class ResourceService {

	@Autowired
	private ResourceRepo resourceRepo;

	Resources resources=new Resources();


	public Optional<Resources> login(Resources resources) {
		java.util.Optional<Resources> dbDetails=resourceRepo.findById(resources.getEmployeeId());
		if(resources.getEmployeeId().equals(dbDetails.get().getEmployeeId()) && resources.getPassword().equals(dbDetails.get().getPassword()) ) {
			return  dbDetails;	
		}
		return null;	
	}

	public ConstantKeys register(Resources resources) {
		resourceRepo.save(resources);
		return ConstantKeys.REGISTRACTION_SUCESSSFULLY;
	}


	public ConstantKeys forgetpass(String empid, String email, String password) {

		java.util.Optional<Resources> dbDetails=resourceRepo.findById(empid);

		if(empid.equals(dbDetails.get().getEmployeeId())&& email.equals(dbDetails.get().getEmailId())) {
			resourceRepo.updatePassword(password, email);
			return ConstantKeys.PASSWORD_CHANGED_SUCESSFULLY;
		}
		else {
			return ConstantKeys.INVALID_EMPLOYEEID_AND_EMAIL;
		}
	}
	public List<Resources> filterByStatus(String status, String type, String officeCity) {
		List<Resources> resources=resourceRepo.filter(status,type,officeCity);	
		return resources;

	}
	public List<Resources> findAll(){
		return resourceRepo.findAll();

	}
	public void deleteById(String id) {
		resourceRepo.deleteById(id);
		
		
	}
}



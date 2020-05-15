package com.resource.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.resource.constant.ConstantKeys;
import com.resource.constant.StringConstants;
import com.resource.exception.FilterExceptin;
import com.resource.exception.ForgetPasswordException;
import com.resource.exception.LoginException;
import com.resource.exception.RegistractionException;
import com.resource.model.Resources;
import com.resource.service.ExcelGenerator;
import com.resource.service.ResourceService;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/resource")
public class ResourceController {

	@Autowired
	private ResourceService resourceService;

	@GetMapping("/login")
	public  Optional<Resources> login(@Valid @RequestBody Resources resources) throws LoginException{

		Optional<Resources> res	=resourceService.login(resources);
		if(res==null){

			throw new LoginException(StringConstants.INVALID_LOGIN);
		}
		return res;
	}

	@PostMapping("/restn")
	public ConstantKeys registractionEmployee(@Valid @RequestBody Resources resources) throws RegistractionException {
		return resourceService.register(resources);
	}

	@PostMapping("/forgetpass/{empid}/{email}/{password}") 
	public ConstantKeys forgetPassword(@PathVariable String empid,@PathVariable String email,
			@PathVariable String password) throws ForgetPasswordException {
		return resourceService.forgetpass(empid, email, password);
	}

	@GetMapping("/filter/{status}/{type}/{officeCity}")
	public List<Resources> filterByStatus(@PathVariable String status,@PathVariable String type,@PathVariable String officeCity) throws FilterExceptin{
		return resourceService.filterByStatus(status,type,officeCity);	
	}

	@GetMapping(value = "/{status}/{type}/{officeCity}/download/Resources.xlsx") 
	public ResponseEntity<InputStreamResource> excelResourcesReport(@PathVariable String 
			status,@PathVariable String type,@PathVariable String officeCity) throws IOException {

		List<Resources> resources =
				(List<Resources>)resourceService.filterByStatus(status,type,officeCity);

		ByteArrayInputStream in = ExcelGenerator.resourcessToExcel(resources);

		HttpHeaders headers = new HttpHeaders(); headers.add("Content-Disposition",
				"attachment; filename=Resources.xlsx");

		return ResponseEntity
				.ok() 
				.headers(headers) 
				.body(new InputStreamResource(in)); 
	}
	@GetMapping("/filter/all")
	public List<Resources> getAll(){
		return resourceService.findAll();

	}
	@DeleteMapping("/delete/{id}")
	public String deleteByIdd(@PathVariable String id) {
		resourceService.deleteById(id);;
		return StringConstants.DELETE_SUCESSFULLY;
	}


}

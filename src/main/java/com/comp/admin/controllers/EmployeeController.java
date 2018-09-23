package com.comp.admin.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.comp.admin.data.CompanyRepository;
import com.comp.admin.data.EmployeeRepository;
import com.comp.admin.model.Company;
import com.comp.admin.model.Employee;

@Component
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return  employeeRepository.findAll();
	}
	
	@GetMapping("/employee/{employeeid}")
	public Employee getEmployeeById(@PathVariable int employeeid) {
		return  employeeRepository.findById(employeeid).get();
	}
	
	@GetMapping("/company/{companyId}/employees")
	public Page<Employee> createEmployee(@Valid Company company, Pageable pageable) {
		
		company.setCompId(1);
		company.setCompName("TCS");
		
		return employeeRepository.findByCompany(company, pageable);
	}

	@PutMapping("/company/{companyId}/employee/")
    public ResponseEntity<Void> updateEmployee(@PathVariable Integer companyId, @Valid @RequestBody Employee employeeRequest,
    		@Valid @RequestBody Company companyRequest) 
    {
		Optional<Company> companyOptional = companyRepository.findById(companyId);
		if (companyOptional.get()==null)
			return ResponseEntity.notFound().build();
		
		
		/*companyOptional.get();
		
		Optional<Employee> employeeOptional = employeeRepository.findById(employeeRequest.getCompany().getCompanyid());
		
		Employee employee = employeeOptional.get();
		employee.setExperience(employeeRequest.getExperience());
		employee.setExpertise(employeeRequest.getExpertise());
		employee.setName(employeeRequest.getName());
		employee.setCompany(companyRequest);
		
		employeeRepository.save(employee);
*/
		return ResponseEntity.noContent().build();
    }

	@DeleteMapping("/company/{companyId}/employee/employeeId")
    public ResponseEntity<?> deleteEmployee(@PathVariable Integer employeeId) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if (employee.get()==null)
			return ResponseEntity.notFound().build();
		
		employeeRepository.delete(employee.get());

		return ResponseEntity.ok().build();
	}
}

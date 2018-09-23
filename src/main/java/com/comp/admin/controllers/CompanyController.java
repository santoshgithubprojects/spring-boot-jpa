package com.comp.admin.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.comp.admin.data.CompanyRepository;
import com.comp.admin.model.Company;

@Component
@RestController
public class CompanyController {

	@Autowired
	private CompanyRepository companyRepository;

	@GetMapping("/companies")
	public List<Company> getCompanies() {
		return companyRepository.findAll();
	}
	
	@GetMapping("/company/{companyid}")
	public Company getCompanyById(@PathVariable int companyid) {
		return companyRepository.findById(companyid).get();
	}
	

	@PostMapping("/company")
	public Company createCompany(@Valid @RequestBody Company company) {
		return companyRepository.save(company);
	}

	@PutMapping("/company/{companyId}")
    public ResponseEntity<Void> updateCompany(@PathVariable Integer companyId, @Valid @RequestBody Company companyRequest) {
		Optional<Company> company = companyRepository.findById(companyId);
		if (company.get()==null)
			return ResponseEntity.notFound().build();
		
		company.get().setCompName((companyRequest.getCompName()));
		companyRepository.save(companyRequest);

		return ResponseEntity.noContent().build();
    }

	@DeleteMapping("/company/{companyId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Integer companyId) {
		Optional<Company> company = companyRepository.findById(companyId);
		if (company.get()==null)
			return ResponseEntity.notFound().build();
		
		companyRepository.delete(company.get());

		return ResponseEntity.ok().build();
	}
}
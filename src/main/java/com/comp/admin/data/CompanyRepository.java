package com.comp.admin.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comp.admin.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>
{
//	Optional<Company> findById(Long companyid);
	
	
}

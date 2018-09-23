package com.comp.admin.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comp.admin.model.Company;
import com.comp.admin.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
	Page<Employee> findByCompany(Company company, Pageable pageable);
}

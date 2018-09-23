package com.comp.admin.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee 
{
	@Id
	@Column(name = "EMP_ID", nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	
	@Column(name = "EMP_EXPERIENCE", nullable=false)
	private int experience;
	
	@Column(name = "EMP_NAME", nullable=false)
	private String name;
	
	@Column(name = "EMP_EXPERTISE_IN", nullable=false)
	private String expertise;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "COMP_ID")
    private Company company;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public int getExperience() {
		return experience;
	}


	public void setExperience(int experience) {
		this.experience = experience;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getExpertise() {
		return expertise;
	}


	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}
}

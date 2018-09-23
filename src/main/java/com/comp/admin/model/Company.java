package com.comp.admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COMPANY")
public class Company 
{
	@Id
    @GeneratedValue
    @Column(name="COMP_ID")
    private int compId;
    
    @Column(name="COMP_NAME")
    private String compName;

	public int getCompId() {
		return compId;
	}

	public void setCompId(int compId) {
		this.compId = compId;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}
}

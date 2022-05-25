package com.npci.user_management_application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Department {

	@Id
	@Column(name = "department_id")
	private Integer departmentId;

	@Column(name = "department_name")
	private String departmentIame;

	@Column(name = "department_description")
	private String departmentDescription;

}

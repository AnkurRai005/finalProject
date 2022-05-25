package com.npci.user_management_application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Data
@Entity
public class Item {

	@Id
	@Column(name = "item_id")
	private Integer itemId;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "item_type")
	private String itemType;
	
	@Column(name = "item_description")
	private String itemDescription;
	
	@Column(name = "item_image")
	@Lob
	private byte[] itemImage;
	
	@Column(name = "created_by")
	private Integer createdBy;
	
	@Column(name = "created_date")
	private String createdDate;

	@Column(name = "updated_by")
	private Integer updatedBy;

	@Column(name = "updated_date")
	private String updatedDate;
	
	@Column(name = "category_id")
	private Integer categoryId;
	
	@Column(name = "department_id")
	private Integer departmentId;
}

package com.npci.user_management_application.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.npci.user_management_application.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

	@Query(value = "select * from item where category_id=:category_id and department_id=:department_id", nativeQuery = true)
	public List<Item> itemselect(@Param("category_id") Integer categoryId, @Param("department_id") Integer departmentId);

}

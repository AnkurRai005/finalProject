package com.npci.user_management_application.service;

import java.util.List;

import com.npci.user_management_application.model.Item;
import com.npci.user_management_application.model.Users;

public interface UserService {

	Users storeUserData(Users user);
	
	Item storeItemData(Item item);
	
	Item updateUserDetails(Item item);
	
	List<Item> getItemData(Integer s, Integer a);
}

package com.npci.user_management_application.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npci.user_management_application.dao.ItemRepository;
import com.npci.user_management_application.dao.UserRepository;
import com.npci.user_management_application.exceptions.InvalidEmailIdException;
import com.npci.user_management_application.exceptions.InvalidPhoneNoException;
import com.npci.user_management_application.exceptions.ItemNotAvailableException;
import com.npci.user_management_application.model.Item;
import com.npci.user_management_application.model.Users;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ItemRepository rep;

	@Autowired
	private UserRepository usRep;
	
	Logger log = LoggerFactory.getLogger("UserServiceImpl.class");
	
	@Override
	public Users storeUserData(Users user) {
		log.info("Saving User Details for User Id: {}.",user.getUserId());
		if(!user.getPhoneNo().matches("^\\d{10}$")) {
			throw new InvalidPhoneNoException("Invalid Phone Number");
		}
		else if(!user.getEmailId().matches("^(.+)@(.+)$")) {
			throw new InvalidEmailIdException("Invalid Email Id");
		}
		Users u = usRep.save(user);
		log.info("User Details for User Id: {} saved.",user.getUserId());
		return u;
	}

	@Override
	public Item storeItemData(Item item) {
		log.info("Saving Item Details for Item Id: {}.",item.getItemId());
		Item i = rep.save(item);
		log.info("Item Details for Item Id: {} saved.",item.getItemId());
		return i;
	}

	@Override
	public List<Item> getItemData(Integer catId,Integer depId) {
		log.info("Serching Item Details for Category Id: {} and Department Id: {}.",catId,depId);
		List<Item> itemselect = rep.itemselect(catId, depId);
		log.info("Item Details for Category Id: {} and Department Id: {} returned.",catId,depId);
		return itemselect;
	}

	@Override
	public Item updateUserDetails(Item item) {
		log.info("Updating Item Details for Item Id: {}.",item.getItemId());
		Optional<Item> itemRecord = rep.findById(item.getItemId());
		if(!itemRecord.isPresent()) {
			throw new ItemNotAvailableException("Item not available for Item Id: "+item.getItemId());
		}
		Item i = itemRecord.get();
		i.setItemName(item.getItemName());
		i.setItemType(item.getItemType());
		i.setItemDescription(item.getItemDescription());
		i.setItemImage(item.getItemImage());
		i.setCategoryId(item.getCategoryId());
		i.setDepartmentId(item.getDepartmentId());
		i.setUpdatedBy(item.getUpdatedBy());
		i.setUpdatedDate(item.getUpdatedDate());
		rep.save(i);
		log.info("Item Details for Item Id: {} Updated.",item.getItemId());
		return i;
	}

}

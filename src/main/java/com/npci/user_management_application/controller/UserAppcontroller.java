package com.npci.user_management_application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.user_management_application.model.Item;
import com.npci.user_management_application.model.Users;
import com.npci.user_management_application.service.UserService;

@RestController
@RequestMapping(value = "/welcome")
public class UserAppcontroller {

	@Autowired
	private UserService userService;
	
	@PostMapping("/suserd")
	public ResponseEntity<String> storeUserData(@RequestBody Users user) {
		Users u = userService.storeUserData(user);
		return new ResponseEntity<>("Data save for Id :" + u.getUserId(), HttpStatus.CREATED);
	}

	@PostMapping("/sitemd")
	public ResponseEntity<String> storeItemData(@RequestBody Item item) {
		Item i = userService.storeItemData(item);
		return new ResponseEntity<>("Data save for Id :" + i.getCreatedBy(), HttpStatus.CREATED);
	}

	@GetMapping("/gitemd/{catId}/{depId}")
	public ResponseEntity<List<Item>> getItemData(@PathVariable Integer catId, @PathVariable Integer depId) {
		List<Item> itemselect = userService.getItemData(depId, catId);
		return new ResponseEntity<>(itemselect, HttpStatus.FOUND);
	}
	
	@PutMapping("/citemd")
	public ResponseEntity<Item> updateUserDetails(@RequestBody Item item){
		Item i = userService.updateUserDetails(item);
		return new ResponseEntity<>(i, HttpStatus.OK);
	}
}

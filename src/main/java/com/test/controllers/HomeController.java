
package com.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.pojo.User;
import com.test.services.UserService;

@RestController
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/saveUser")
	public ResponseEntity<?> testAPI(@RequestBody User user)
	{
		return this.userService.saveUser(user);
	}
	
	@GetMapping("/getUserList")
	public ResponseEntity<?> getUserList()
	{
		return this.userService.getUserList();
	}
	
	@DeleteMapping("/deleteUserById/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable Long id)
	{
		return this.userService.deleteUserById(id);
	}
	
	@PostMapping("/updateUser/{id}")
	public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Long id)
	{
		return this.userService.updateUser(user,id);
	}
	
	

}

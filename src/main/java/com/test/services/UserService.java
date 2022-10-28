package com.test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.pojo.User;
import com.test.repository.UserRepo;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepo userRepo;

	
	//saveUser
	public ResponseEntity<?> saveUser(User user) {
		
		try {
			User userResult =  this.userRepo.save(user);
			return ResponseEntity.ok(userResult);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}


	public ResponseEntity<?> getUserList() {
		return ResponseEntity.ok(this.userRepo.findAll());
	}


	public ResponseEntity<?> deleteUserById(Long id) {
		
		try {
			this.userRepo.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}


	public ResponseEntity<?> updateUser(User user, Long id) {
		User data =  this.userRepo.findById(id).get();
		try {
			if(data == null )
			{
				throw new Exception("something went wrong");
			}
			
			user.setId(id);
			User result =  this.userRepo.save(user);
			return ResponseEntity.ok(result);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}
	
	
	

}

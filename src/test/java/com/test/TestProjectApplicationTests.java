package com.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.pojo.User;
import com.test.repository.UserRepo;

@SpringBootTest
class TestProjectApplicationTests {
	
	@Autowired
	UserRepo userRepo;

	@Test
	public void testCreate() {
		User user = new User();
		user.setId(1L);
		user.setEmailId("rajatrao908@gmail.com");
		user.setFirstName("Rajat");
		user.setLastName("Yadav");
		user.setMobile("8200845715");
		userRepo.save(user);
		assertNotNull(userRepo.findById(1L).get());
	}
	
	@Test
	public void testReadAll() {
		List<User> list = userRepo.findAll();
		assertThat(list).size().isGreaterThan(0);	
	}
	
	@Test
	public void testSingleRecord() {
		User user = userRepo.findById(1L).get();
		assertEquals("8200845715", user.getMobile());
		
	}
	
	@Test
	public void testUpdate() {
		User u = userRepo.findById(1L).get();
		u.setMobile("7206276806");
		userRepo.save(u);
		assertNotEquals("8200845715", userRepo.findById(1L).get().getMobile());
	}
	
	
	@Test
	public void testDelete() {
		userRepo.deleteById(1L);
		assertThat(userRepo.existsById(1L)).isFalse();
	}
	
}















package com.persistent.tourism;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.persistent.tourism.entities.TourismUser;
import com.persistent.tourism.repos.UserRepo;

@SpringBootTest
public class Demo1ApplicationTests {
	
	@Autowired
	UserRepo uRepo;
	
	@Test
	public void createTest() {
		TourismUser user  = new TourismUser();
		user.setFirstName("Rishi");
		user.setLastName("Goel");
		user.setMobNo("9466365889");
		user.setPassword("1234");
		uRepo.save(user);
		assertNotNull(uRepo.findByMobNo("9466365889"));
		
		
	}
}


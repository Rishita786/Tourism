package com.persistent.tourism.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.tourism.entities.TourismUser;
import com.persistent.tourism.repos.UserRepo;

@Service
public class ContService {

	@Autowired
	UserRepo userRepo;
	
	public Boolean SaveUser(TourismUser tourismUser) {
		if(userRepo.findByMobNo(tourismUser.getMobNo()).isPresent()) {
			return false;
		}
		userRepo.save(tourismUser);
		return true;
	}
	public double getCostOfPackage(Long pid) {
		return 5;//packageRepo.findById(pid).get().getCost();
	}
}

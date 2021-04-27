package com.persistent.tourism.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.tourism.entities.Pack;
import com.persistent.tourism.repos.PackageRepository;


@Service
public class PackageServiceImpl implements PackageService {
@Autowired
private PackageRepository packageRepository;
	@Override
	public List<Pack> getAllPackages() {
		return packageRepository.findAll();
		// TODO Auto-generated method stub
//		return null;
	}
	@Override
	public void savePack(Pack pack) {
		this.packageRepository.save(pack);
	}
	@Override
	public Pack getPackageById(long id) {
		// TODO Auto-generated method stub
		Optional<Pack> optional=packageRepository.findById(id);
		Pack pack=null;
		if(optional.isPresent()) {
			pack=optional.get();
			
		}else {
			throw new RuntimeException("Package not found for id ::" +id);
		}
		return pack;
	}
	@Override
	public void deletePackageById(long id) {
		// TODO Auto-generated method stub
		this.packageRepository.deleteById(id);
	}
	
	

}

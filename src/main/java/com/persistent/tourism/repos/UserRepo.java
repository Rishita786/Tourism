package com.persistent.tourism.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.persistent.tourism.entities.TourismUser;

@Repository
public interface UserRepo extends JpaRepository<TourismUser, Long> {

	Optional<TourismUser> findByMobNo(String mobNo);

	void deleteBymobNo(String mobNo);
}

package com.persistent.tourism.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.persistent.tourism.entities.Booking;


public interface BookingRepository extends JpaRepository<Booking,Long>{

	List<Booking> findByuid(String uid );
//	@Query(value = "SELECT * FROM Booking b WHERE u.uid = uId", 
//			nativeQuery = true)
//	List<Booking> getUser(long uId);

	void deleteByBid(int bid);

	void deleteByUid(String uid);

}

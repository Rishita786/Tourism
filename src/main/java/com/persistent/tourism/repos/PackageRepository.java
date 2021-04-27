package com.persistent.tourism.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.persistent.tourism.entities.Pack;


@Repository
public interface PackageRepository extends JpaRepository<Pack,Long> {

}

package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nt.Entity.PlansEntity;

public interface IESPlansRepo extends JpaRepository<PlansEntity, Integer> {

	
	@Modifying
	@Query("UPDATE PlansEntity e SET e.activeSwitch = ?2 WHERE e.id = ?1")
	Integer planStatusSw(Integer id, String activeSwitch);
}

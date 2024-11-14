package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.Entity.ApplicationEntity;


public interface IESApplicationRepo extends JpaRepository<ApplicationEntity, Integer> {

}

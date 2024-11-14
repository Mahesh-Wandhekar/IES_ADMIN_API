package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.Entity.BenefitInfo;


public interface BenefitInfoRepo extends JpaRepository<BenefitInfo, Integer> {

}

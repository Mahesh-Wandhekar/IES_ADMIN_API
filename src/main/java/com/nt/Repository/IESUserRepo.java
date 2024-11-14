package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;



import com.nt.Entity.IESUsersEntity;

public interface IESUserRepo extends JpaRepository<IESUsersEntity, Integer> {

	public IESUsersEntity findByEmail(String email);

	public IESUsersEntity findByEmailAndPassword(String email, String password);
}

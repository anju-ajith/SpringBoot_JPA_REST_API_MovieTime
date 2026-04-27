package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TblUser;

@Repository
public interface UserRepository extends JpaRepository<TblUser, Integer>{
	
	@Query("select u from TblUser u where u.email=:email and u.password=:password")
	TblUser findUser(@Param("email") String email,@Param("password") String password);

}

package com.cg.flp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.flp.entities.User;



@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	
	public User findByUserNameAndPassword(String userName, String password);

	
	@Query("select user from User user where user.userName=:uname and user.password=:pId")
	User validateUser(@Param("uname")String userName,@Param("pId") String password);
	
	
	@Query("select user from User user where user.userName =:uname ")
	User validateUser(@Param("uname") String userName);
}

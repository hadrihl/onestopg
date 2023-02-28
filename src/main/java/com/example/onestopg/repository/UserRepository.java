package com.example.onestopg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.onestopg.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.username = :username")
	public User findUserByUsername(String username);
	
	@Query("SELECT u FROM User u WHERE u.email = :email")
	public User findUserByEmail(String email);
}

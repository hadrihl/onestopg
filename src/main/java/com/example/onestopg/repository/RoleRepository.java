package com.example.onestopg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.onestopg.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	@Query("SELECT r FROM Role r WHERE r.name = :name")
	public String findRoleByName(String name);
}

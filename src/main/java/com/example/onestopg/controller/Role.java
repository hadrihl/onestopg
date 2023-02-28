package com.example.onestopg.controller;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.example.onestopg.entity.User;

@Entity
@Table (name = "role")
public class Role {

	private Integer id;
	
	private String name;
	
	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<>();
	
	// default constructor
	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}	
}

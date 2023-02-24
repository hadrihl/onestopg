package com.example.onestopg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.onestopg.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Integer> {
	
}

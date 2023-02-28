package com.example.onestopg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.onestopg.entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {
	
	@Query(value = "SELECT s FROM Store s WHERE s.name LIKE '%' || :keyword || '%'"
			+ " OR s.address LIKE '%' || :keyword || '%'"
			+ " OR s.phone_number LIKE '%' || :keyword || '%'"
			+ " OR s.email LIKE '%' || :keyword || '%'"
			+ " OR s.status LIKE '%' || :keyword || '%'"
			)
	public List<Store> search(@Param("keyword") String keyword);
}

package com.example.onestopg.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.onestopg.entity.Store;

@Repository
public class StoreDao {
	
	List<Store> stores = new ArrayList<>();
	
	public Store saveStore(Store store) {
		stores.add(store);
		return store;
	}
	
	public List<Store> getAllStores() {
		return stores;
	}

}

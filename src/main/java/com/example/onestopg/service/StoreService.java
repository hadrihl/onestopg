package com.example.onestopg.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.onestopg.entity.Store;
import com.example.onestopg.repository.StoreRepository;

@Service
public class StoreService {
	
	@Autowired
	private StoreRepository storeRepository;
	
	public Store saveStore(Store store) {
		return storeRepository.save(store);
	}
	
	public List<Store> getAllStores() {
		return storeRepository.findAll();
	}
}

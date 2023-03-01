package com.example.onestopg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.onestopg.entity.Store;
import com.example.onestopg.repository.StoreRepository;

@Service
@Transactional
public class StoreService {
	
	@Autowired
	private StoreRepository storeRepository;
	
	public Store saveStore(Store store) {
		store.setStatus(true);
		return storeRepository.save(store);
	}
	
	public List<Store> getAllStores() throws StoreNotFoundException {
		List<Store> stores = storeRepository.findAll();
		if(stores.isEmpty()) {
			throw new StoreNotFoundException("store not found.");
		} else {
			return stores;
		}
	}
	
	public Store getStoreById(Integer id) {
		return storeRepository.findById(id).get();
	}
	
	public Store updateStore(Store tmp, Integer id) {
		Store store = storeRepository.findById(id).get();
		store.setName(tmp.getName());
		store.setAddress(tmp.getAddress());
		store.setEmail(tmp.getEmail());
		store.setPhone_number(tmp.getPhone_number());
		store.setStatus(tmp.getStatus());
		store.setLocalities(tmp.getLocalities());
		return storeRepository.save(store);
	}
	
	public void deleteStore(Integer id) {
		storeRepository.deleteById(id);
	}
	
	public List<Store> search(String keyword) {
		return storeRepository.search(keyword);
	}
}

package com.example.onestopg.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.onestopg.entity.Store;
import com.example.onestopg.repository.StoreRepository;

@ExtendWith(MockitoExtension.class)
public class StoreServiceTest {

	@Mock
	private StoreRepository storeRepository;
	
	@InjectMocks
	private StoreService storeService;

	@Test
	public void testSaveStore() {
		Store store = new Store();
		store.setName("Test Store");
		store.setPhone_number("12345678910");
		
		when(storeRepository.save(store)).thenReturn(store);
		
		Store savedStore = storeService.saveStore(store);
		
		verify(storeRepository, times(1)).save(store);
		assertEquals(store, savedStore);
	}
	
}

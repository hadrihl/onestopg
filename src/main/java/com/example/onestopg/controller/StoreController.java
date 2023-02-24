package com.example.onestopg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.onestopg.entity.Store;
import com.example.onestopg.service.StoreService;

@Controller
public class StoreController {
	
	@Autowired
	public StoreService storeService;

	@GetMapping("/stores")
	public String getStoresPage(Model model) {
		List<Store> stores = storeService.getAllStores();
		model.addAttribute("stores", stores);
		return "stores";
	}
	
	@GetMapping("/add-store")
	public String getAddStorePage() {
		return "add-store";
	}
	
	@PostMapping("/add-store")
	public String processAddStore(@ModelAttribute("store") Store store) {
		storeService.saveStore(store);
		return "redirect:stores";
	}
}

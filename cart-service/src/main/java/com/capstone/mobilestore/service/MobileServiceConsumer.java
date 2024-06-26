package com.capstone.mobilestore.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capstone.mobilestore.model.Mobile;

@FeignClient(name="MOBILE-SERVICE")
public interface MobileServiceConsumer {

	@GetMapping("/mobile/{id}")
	Mobile getMobileDetails(@PathVariable("id") long mobileId);
	
}

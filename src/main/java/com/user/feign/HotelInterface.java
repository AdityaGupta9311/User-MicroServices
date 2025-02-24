package com.user.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.hotel.Models.Hotels;

@FeignClient("HOTELMICROSERVICES")
public interface HotelInterface {
	
	@GetMapping("/getallhotel")
	public List<Hotels> getAllHotels();
}

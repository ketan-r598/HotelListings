package com.dxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.exception.DuplicateHotelIDException;
import com.dxc.exception.HotelDoesNotExistException;
import com.dxc.model.Hotel;
import com.dxc.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService service;

	@PostMapping("add")
	public void addHotel(@RequestBody Hotel hotel) {
		try {
			System.out.println(hotel);
			service.addHotel(hotel);
		} catch (DuplicateHotelIDException e) {
			System.out.println("\nCannot add the hotel\n");
			System.out.println(e);
//			e.printStackTrace();
		}
	}

	@PutMapping("update")
	public void updateHotel(@RequestBody Hotel hotel) {
		try {
			service.updateHotel(hotel);
		} catch (HotelDoesNotExistException e) {
			System.out.println("\nCannot update the hotel\n");
			System.out.println(e);
//			e.printStackTrace();
		}
	}

	@DeleteMapping("delete")
	public void deleteHotel(@RequestBody Hotel hotel) {
		try {
			service.deleteHotel(hotel);
		} catch (HotelDoesNotExistException e) {
			System.out.println("\nCannot delete the hotel\n");
			System.out.println(e);
//			e.printStackTrace();
		}
	}
	
	@GetMapping("getHotels")
	public List<Hotel> getHotels() {

		return service.getHotels();
	}

	@GetMapping("getHotel/{id}")
	public Hotel getHotel(@PathVariable int id)  {
		
		Hotel hotel = null;
		try {
			hotel = service.getHotel(id);
		} catch (HotelDoesNotExistException e) {
			System.out.println("\nCannot find the hotel\n");
			System.out.println(e);
			return null;
//			e.printStackTrace();
		}
		return hotel;
	}
	
	@GetMapping("getHotelByCity/{city}")
	public List<Hotel> getHotelByCity(@PathVariable String city) {
		return service.getHotelByCity(city);
	}
	@GetMapping("getHotelByAvgRating/{avgRating}")
	public List<Hotel> getHotelByAvgRating(@PathVariable double avgRating) {
		return service.getHotelByAvgRating(avgRating);
	}
	@GetMapping("getHotelByCityAndAvgRating/{city}/{avgRating}")
	public List<Hotel> getHotelByCityAndAvgRating(@PathVariable String city, @PathVariable double avgRating) {
		return service.getHotelByCityAndAvgRating(city, avgRating);
	}
}
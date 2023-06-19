package com.dxc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxc.model.Hotel;
import java.util.List;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
	
	public Hotel getByHotelId(int id);
	public List<Hotel> getByCity(String city);
	public List<Hotel> getByAvgRating(double avgRating);
	public List<Hotel> getByCityAndAvgRating(String city, double avgRating);
}
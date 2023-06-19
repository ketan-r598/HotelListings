package com.dxc.service;

import java.util.List;

import com.dxc.exception.DuplicateHotelIDException;
import com.dxc.exception.HotelDoesNotExistException;
import com.dxc.model.Hotel;

public interface HotelService {
	
	public void addHotel(Hotel hotel) throws DuplicateHotelIDException;
	public void updateHotel(Hotel hotel) throws HotelDoesNotExistException;
	public void deleteHotel(Hotel hotel) throws HotelDoesNotExistException;
	public List<Hotel> getHotels();
	public Hotel getHotel(int id) throws HotelDoesNotExistException;
	public List<Hotel> getHotelByCity(String city);
	public List<Hotel> getHotelByAvgRating(double avgRating);
	public List<Hotel> getHotelByCityAndAvgRating(String city, double avgRating);
}
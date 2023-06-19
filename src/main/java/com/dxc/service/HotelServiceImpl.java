package com.dxc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.exception.DuplicateHotelIDException;
import com.dxc.exception.HotelDoesNotExistException;
import com.dxc.model.Hotel;
import com.dxc.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository repo;
	
	@Override
	public void addHotel(Hotel hotel) throws DuplicateHotelIDException {
		
		int id = hotel.getHotelId();
		System.out.println(id);
		
		Optional<Hotel> _hotel = repo.findById(id);
		System.out.println(_hotel.isPresent());
		
		if(_hotel.isEmpty()) {
			System.out.println(hotel);
			repo.save(hotel);
			System.out.println("\nHotel Saved Successfully\n");
			return;
		}
		
		throw new DuplicateHotelIDException();
	}

	@Override
	public void updateHotel(Hotel hotel) throws HotelDoesNotExistException {
		
		int id = hotel.getHotelId();
		Optional<Hotel> _hotel = repo.findById(id);
		
		if(_hotel.isEmpty()) {
			throw new HotelDoesNotExistException();
		}
		repo.save(hotel);
		System.out.println("\nHotel Updated Successfully\n");
	}

	@Override
	public void deleteHotel(Hotel hotel) throws HotelDoesNotExistException {
		
		int id = hotel.getHotelId();
		Optional<Hotel> _hotel = repo.findById(id);
		
		if(_hotel.isEmpty()) {
			throw new HotelDoesNotExistException();
		}
		repo.deleteById(id);
		System.out.println("\nHotel Deleted Successfully\n");
	}

	@Override
	public List<Hotel> getHotels() {
		return repo.findAll();
	}

	@Override
	public Hotel getHotel(int id) throws HotelDoesNotExistException {
		
		Optional<Hotel> _hotel = repo.findById(id);
		
		if(_hotel.isEmpty()) {
			throw new HotelDoesNotExistException();
		}
		return _hotel.get();
	}

	@Override
	public List<Hotel> getHotelByCity(String city) {
		return repo.getByCity(city);
	}

	@Override
	public List<Hotel> getHotelByAvgRating(double avgRating) {
		return repo.getByAvgRating(avgRating);
	}

	@Override
	public List<Hotel> getHotelByCityAndAvgRating(String city, double avgRating) {
		return repo.getByCityAndAvgRating(city, avgRating);
	}
}

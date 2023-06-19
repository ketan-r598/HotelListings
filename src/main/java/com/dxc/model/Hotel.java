package com.dxc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Hotel {

	@Id
	int hotelId;
	String name;
	String description;
	String address;
	String city;
	String state;
	String country;
	double avgRating;
	String contactInfo;
	String email;

	public Hotel() {

	}

	public Hotel(int hotelId, String name, String description, String address, String city, String state,
			String country, double avgRating, String contactInfo, String email) {
		this.hotelId = hotelId;
		this.name = name;
		this.description = description;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.avgRating = avgRating;
		this.contactInfo = contactInfo;
		this.email = email;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", name=" + name + ", description=" + description + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", avgRating=" + avgRating
				+ ", contactInfo=" + contactInfo + ", email=" + email + "]";
	}
}

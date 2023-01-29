package com.booking.recruitment.hotel.dto;

import com.booking.recruitment.hotel.model.City;
import com.booking.recruitment.hotel.model.Hotel;

public class HotelResponseDto {
    private Long id;

    private String name;
    private Double rating;
    private String address;
    private double latitude;
    private double longitude;
    private City city;

    public HotelResponseDto(Hotel hotel){
        this.id = hotel.getId();
        this.name = hotel.getName();
        this.address = hotel.getAddress();
        this.latitude = hotel.getLatitude();
        this.longitude = hotel.getLongitude();
        this.city = hotel.getCity();
    }
}

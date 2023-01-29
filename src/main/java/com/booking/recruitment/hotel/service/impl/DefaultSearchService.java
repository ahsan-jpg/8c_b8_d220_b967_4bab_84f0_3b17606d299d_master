package com.booking.recruitment.hotel.service.impl;

import com.booking.recruitment.hotel.model.City;
import com.booking.recruitment.hotel.model.Hotel;
import com.booking.recruitment.hotel.repository.CityRepository;
import com.booking.recruitment.hotel.repository.HotelRepository;
import com.booking.recruitment.hotel.service.SearchService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

import static com.booking.recruitment.hotel.utils.HaversineFormula.haversine;

public class DefaultSearchService implements SearchService {

    private HotelRepository hotelRepository;
    private CityRepository cityRepository;

    public DefaultSearchService(HotelRepository hotelRepository,
                                CityRepository cityRepository){
        this.hotelRepository = hotelRepository;
        this.cityRepository = cityRepository;
    }

    public List<Hotel> getNearestCityHotels(Long cityId){
        List<Hotel> nearestHotels =  new ArrayList<>();

        Optional<City> cityExist = cityRepository.findById(cityId);
        City city = cityExist.orElse(null);

        List<Hotel> hotels = hotelRepository.getHotelByCity(city);

        TreeMap<Double, Hotel> map = new TreeMap<>();

        for(Hotel ele:hotels){
           Double distance =  haversine(city.getCityCentreLatitude(),
                    city.getCityCentreLongitude(),
                    ele.getLatitude(),
                    ele.getLongitude());

            map.put(distance, ele);
        }

        map.forEach((key, value) -> nearestHotels.add(value));

        nearestHotels.stream().limit(3);

        return nearestHotels;

    }
}

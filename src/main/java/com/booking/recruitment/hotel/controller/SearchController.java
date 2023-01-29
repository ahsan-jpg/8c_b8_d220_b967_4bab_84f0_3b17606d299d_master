package com.booking.recruitment.hotel.controller;

import com.booking.recruitment.hotel.model.City;
import com.booking.recruitment.hotel.model.Hotel;
import com.booking.recruitment.hotel.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    private SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Hotel> getNearestCityHotels(@PathVariable("cityId") Long cityId) {
        return searchService.getNearestCityHotels(cityId);
    }
}

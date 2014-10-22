package com.example.cities.controller;

import com.example.cities.domain.City;
import com.example.cities.repositories.CityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CitiesController {
    private CityRepository repository;

    @Autowired
    public CitiesController(CityRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<City> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Page<City> search(@RequestParam("name") String name, Pageable pageable) {
        return repository.findByNameContainsIgnoreCase(name, pageable);
    }

    @RequestMapping(value = "/version", method = RequestMethod.GET)
    public String version() {
        return System.getenv("VERSION");
    }
}

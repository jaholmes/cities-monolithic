package com.example.cities.repositories;

import com.example.cities.domain.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface CityRepository extends PagingAndSortingRepository<City, Long> {

    Page<City> findAll(Pageable pageable);

    City findById(Long id);

    Page<City> findByNameIgnoreCase(String name, Pageable pageable);

    Page<City> findByNameContainsIgnoreCase(String name, Pageable pageable);

    Page<City> findByStateCodeIgnoreCase(String stateCode, Pageable pageable);

    Page<City> findByPostalCode(String postalCode, Pageable pageable);
}

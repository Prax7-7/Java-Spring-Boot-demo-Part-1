package com.example.demo.repositories;

import com.example.demo.models.Cars;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarsRepository extends MongoRepository<Cars,String> {

    List<Cars> findByBrand(String brand);
}

package com.example.demo.controllers;

import com.example.demo.models.Cars;
import com.example.demo.repositories.CarsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/cars")
public class CarsController {

    @Autowired
    private CarsRepository repository;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Cars> getAllCars() {
        return repository.findAll();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Cars getCarById(@PathVariable("id") String id) {
        return repository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateCarById(@PathVariable("id") ObjectId id, @Valid @RequestBody Cars car) {
        car.setId(id.toString());
        repository.save(car);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Cars addNewCar(@Valid @RequestBody Cars car) {
        car.setId(ObjectId.get().toString());
        repository.save(car);
        return car;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCarByID(@PathVariable("id") String id) {
         repository.delete(repository.findOne(id));
    }
}

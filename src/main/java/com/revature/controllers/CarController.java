package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.services.CarService;
import com.revature.models.Car;

@RestController
@RequestMapping("/car")
public class CarController {

  private CarService carService;

  @Autowired
  public CarController(CarService carService){
    this.carService = carService;
  }

  @GetMapping
  public ResponseEntity<List<Car>> findAllCars(){
    return ResponseEntity.status(200).body(carService.getInventory());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Car> findCarById(@PathVariable int id){
    Car car = carService.getCarById(id);
    return ResponseEntity.status(200).body(car);
  }

  @PostMapping
  public ResponseEntity<Car> addNewCar(@RequestBody Car car){
    carService.addOrUpdateCar(car);
    return ResponseEntity.status(201).build();
  }

  @PutMapping
  public ResponseEntity<Car> updateCar(@RequestBody Car car){
    carService.addOrUpdateCar(car);
    return ResponseEntity.status(200).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Car> deleteCar(@PathVariable int id){
    Car car = carService.getCarById(id);
    carService.deleteCar(car);
    return ResponseEntity.status(200).build();
  }
}

package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repos.CarRepo;
import com.revature.models.Car;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
  
  private CarRepo carRepo;

  @Autowired
  public CarService(CarRepo carRepo){
    this.carRepo=carRepo;
  }

  public List<Car> getInventory(){
    return carRepo.findAll();
  }

  public Car getCarById(int id){
    Optional<Car> opt = carRepo.findById(id);
    if(opt.isPresent()){
      return opt.get();
    }
    return null;
  }

  public void addOrUpdateCar(Car car){
    carRepo.save(car);
  }

  public void deleteCar(Car car){
    carRepo.delete(car);
  }
}

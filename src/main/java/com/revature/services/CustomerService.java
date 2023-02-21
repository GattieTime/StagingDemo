package com.revature.services;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.repos.CustomerRepo;
import com.revature.models.Customer;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

  private CustomerRepo customerRepo;

  @Autowired
  public CustomerService(CustomerRepo customerRepo){
    this.customerRepo=customerRepo;
  }

  public List<Customer> getInventory(){
    return customerRepo.findAll();
  }

  public Customer getCustomerById(int id){
    Optional<Customer> opt = customerRepo.findById(id);
    if(opt.isPresent()){
      return opt.get();
    }
    return null;
  }

  public void addOrUpdateCustomer(Customer customer){
    customerRepo.save(customer);
  }

  public void deleteCustomer(Customer customer){
    customerRepo.delete(customer);
  }
}

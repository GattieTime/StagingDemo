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

import com.revature.services.CustomerService;
import com.revature.models.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController {

  private CustomerService customerService;

  @Autowired
  public CustomerController(CustomerService customerService){
    this.customerService = customerService;
  }

  @GetMapping
  public ResponseEntity<List<Customer>> findAllCustomers(){
    return ResponseEntity.status(200).body(customerService.getInventory());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Customer> findCustomerById(@PathVariable int id){
    Customer customer = customerService.getCustomerById(id);
    return ResponseEntity.status(200).body(customer);
  }

  @PostMapping
  public ResponseEntity<Customer> addNewCustomer(@RequestBody Customer customer){
    customerService.addOrUpdateCustomer(customer);
    return ResponseEntity.status(201).build();
  }

  @PutMapping
  public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
    customerService.addOrUpdateCustomer(customer);
    return ResponseEntity.status(200).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Customer> deleteCustomer(@PathVariable int id){
    Customer customer = customerService.getCustomerById(id);
    customerService.deleteCustomer(customer);
    return ResponseEntity.status(200).build();
  }
  
}

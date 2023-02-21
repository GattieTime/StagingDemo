package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Car {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String make;
  private String model;
  @Column(name="modelYear")
  private int year;
  private double cost;
  @ManyToOne(cascade = CascadeType.ALL)
  private Customer buyer;

  public Car() {}

  public Car(int id, String make, String model, int year, double cost, Customer buyer) {
    this.id = id;
    this.make = make;
    this.model = model;
    this.year = year;
    this.cost = cost;
    this.buyer = buyer;
  }
  
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getMake() {
    return make;
  }
  public void setMake(String make) {
    this.make = make;
  }
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    this.model = model;
  }
  public int getYear() {
    return year;
  }
  public void setYear(int year) {
    this.year = year;
  }
  public double getCost() {
    return cost;
  }
  public void setCost(double cost) {
    this.cost = cost;
  }
  public Customer getBuyer() {
    return buyer;
  }
  public void setBuyer(Customer buyer) {
    this.buyer = buyer;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    result = prime * result + ((make == null) ? 0 : make.hashCode());
    result = prime * result + ((model == null) ? 0 : model.hashCode());
    result = prime * result + year;
    long temp;
    temp = Double.doubleToLongBits(cost);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + ((buyer == null) ? 0 : buyer.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Car other = (Car) obj;
    if (id != other.id)
      return false;
    if (make == null) {
      if (other.make != null)
        return false;
    } else if (!make.equals(other.make))
      return false;
    if (model == null) {
      if (other.model != null)
        return false;
    } else if (!model.equals(other.model))
      return false;
    if (year != other.year)
      return false;
    if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
      return false;
    if (buyer == null) {
      if (other.buyer != null)
        return false;
    } else if (!buyer.equals(other.buyer))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Car [id=" + id + ", make=" + make + ", model=" + model + ", year=" + year + ", cost=" + cost + ", buyer="
        + buyer + "]";
  }

}

package com.test.sw.PizzaOrder.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.test.sw.PizzaOrder.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

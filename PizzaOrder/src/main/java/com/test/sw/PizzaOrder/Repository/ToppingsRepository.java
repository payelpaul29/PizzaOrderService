package com.test.sw.PizzaOrder.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.sw.PizzaOrder.Entity.Toppings;

@Repository
public interface ToppingsRepository extends JpaRepository<Toppings, Integer> {
	@Query("select topping_id from Toppings t where t.topping_name = ?1")
	Integer findByToppingName(String topping_name);

}

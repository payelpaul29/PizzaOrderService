package com.test.sw.PizzaOrder.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.sw.PizzaOrder.Entity.OrderStatus;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {

}

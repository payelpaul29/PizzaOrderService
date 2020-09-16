package com.test.sw.PizzaOrder.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.sw.PizzaOrder.Entity.OrderDetails;
import com.test.sw.PizzaOrder.Entity.OrderKey;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetails, OrderKey> {
	@Transactional
	@Modifying
	@Query(value = "Delete from Order_Details o where o.order_id = ?1", nativeQuery = true)
	void DeleteByOrderId(Integer order_id);

}

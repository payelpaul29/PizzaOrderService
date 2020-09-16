package com.test.sw.PizzaOrder.Service;

import org.springframework.stereotype.Service;

import com.test.sw.PizzaOrder.Entity.OrderStatus;
import com.test.sw.PizzaOrder.Model.OrderMO;

@Service
public interface ProcessOrderService {

	public OrderStatus placeOrder(OrderMO orderMo);

	public OrderStatus updateOrder(OrderMO orderMo, Integer orderId);

	public OrderStatus cancelOrder(Integer orderId);

}

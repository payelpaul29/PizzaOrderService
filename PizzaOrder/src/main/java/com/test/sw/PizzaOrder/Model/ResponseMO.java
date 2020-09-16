package com.test.sw.PizzaOrder.Model;


import org.springframework.stereotype.Component;

import com.test.sw.PizzaOrder.Entity.OrderStatus;

@Component
public class ResponseMO {

	private String message;
	private OrderStatus orderStatus;

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

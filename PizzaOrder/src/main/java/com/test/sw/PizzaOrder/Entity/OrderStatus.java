package com.test.sw.PizzaOrder.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class OrderStatus {

	@Id
	private Integer OrderId;
	private String status;

	public OrderStatus() {

	}

	@Override
	public String toString() {
		return "OrderStatus [OrderId=" + OrderId + ", status=" + status + "]";
	}

	public Integer getOrderId() {
		return OrderId;
	}

	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

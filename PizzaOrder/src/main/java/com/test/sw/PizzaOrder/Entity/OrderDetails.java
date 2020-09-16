package com.test.sw.PizzaOrder.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.TableGenerator;

import org.springframework.stereotype.Component;

@Entity
@Component
@IdClass(OrderKey.class)
public class OrderDetails {

	@Id
	private Integer order_id;
	@Id
	private Integer pizza_id;
	@Id
	private Integer cust_id;
	@Id
	private Integer topping_id;

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Integer getPizza_id() {
		return pizza_id;
	}

	public void setPizza_id(Integer pizza_id) {
		this.pizza_id = pizza_id;
	}

	public Integer getCust_id() {
		return cust_id;
	}

	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
	}

	public Integer getTopping_id() {
		return topping_id;
	}

	public void setTopping_id(Integer topping_id) {
		this.topping_id = topping_id;
	}

}

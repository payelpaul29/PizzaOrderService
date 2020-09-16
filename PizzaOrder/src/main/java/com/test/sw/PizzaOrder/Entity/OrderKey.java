package com.test.sw.PizzaOrder.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Embeddable
public class OrderKey implements Serializable {

	private Integer order_id;
	private Integer pizza_id;
	private Integer cust_id;
	private Integer topping_id;
	
	
	
	public Integer getTopping_id() {
		return topping_id;
	}
	public void setTopping_id(Integer topping_id) {
		this.topping_id = topping_id;
	}
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cust_id == null) ? 0 : cust_id.hashCode());
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
		result = prime * result + ((pizza_id == null) ? 0 : pizza_id.hashCode());
		result = prime * result + ((topping_id == null) ? 0 : topping_id.hashCode());
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
		OrderKey other = (OrderKey) obj;
		if (cust_id == null) {
			if (other.cust_id != null)
				return false;
		} else if (!cust_id.equals(other.cust_id))
			return false;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		if (pizza_id == null) {
			if (other.pizza_id != null)
				return false;
		} else if (!pizza_id.equals(other.pizza_id))
			return false;
		if (topping_id == null) {
			if (other.topping_id != null)
				return false;
		} else if (!topping_id.equals(other.topping_id))
			return false;
		return true;
	}
	
}

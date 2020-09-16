package com.test.sw.PizzaOrder.Model;

import java.util.List;

import com.test.sw.PizzaOrder.Entity.Customer;

public class OrderMO {

	private Customer customer;
	private List<PizzaMO> pizzaList;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<PizzaMO> getPizzaList() {
		return pizzaList;
	}

	public void setPizzaList(List<PizzaMO> pizzaList) {
		this.pizzaList = pizzaList;
	}

	public OrderMO() {
		super();
		// TODO Auto-generated constructor stub
	}

}

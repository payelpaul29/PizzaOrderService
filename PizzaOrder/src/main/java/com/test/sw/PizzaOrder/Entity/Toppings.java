package com.test.sw.PizzaOrder.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Component
public class Toppings {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonIgnore
	private String topping_id;
	private String topping_name;
	
	//Order order;
	
	

	@Override
	public String toString() {
		return "Toppings [topping_name=" + topping_name + ", topping_id=" + topping_id + "]";
	}

	public Toppings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Toppings(String topping_name, String topping_id) {
		super();
		this.topping_name = topping_name;
		this.topping_id = topping_id;
	}

	public String getTopping_name() {
		return topping_name;
	}

	public void setTopping_name(String topping_name) {
		this.topping_name = topping_name;
	}

	public String getTopping_id() {
		return topping_id;
	}

	public void setTopping_id(String topping_id) {
		this.topping_id = topping_id;
	}
}

package com.test.sw.PizzaOrder.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Component
public class Pizza {
	
	@Id
	@GeneratedValue
	@JsonIgnore
	private Integer pizza_id;
	private String style;
	private String size;
	
	@Override
	public String toString() {
		return "Pizza [pizza_id=" + pizza_id + ", style=" + style + ", size=" + size + ", toppings="  +"]";
	}
	
	public Pizza() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pizza(Integer pizza_id, String style, String size, List<Toppings> toppings) {
		super();
		this.pizza_id = pizza_id;
		this.style = style;
		this.size = size;
	//	this.toppings = toppings;
	}
	public Integer getPizza_id() {
		return pizza_id;
	}
	public void setPizza_id(Integer pizza_id) {
		this.pizza_id = pizza_id;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	/*public List<Toppings> getToppings() {
		return toppings;
	}
	public void setToppings(List<Toppings> toppings) {
		this.toppings = toppings;
	}*/
	
	//List<Toppings> toppings=new ArrayList();

}

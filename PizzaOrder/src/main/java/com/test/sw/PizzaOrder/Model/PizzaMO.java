package com.test.sw.PizzaOrder.Model;

import java.util.List;

import com.test.sw.PizzaOrder.Entity.Toppings;

public class PizzaMO {
	
	private  String style;
	private  String size;
	private  List<Toppings> toppings;
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
	public List<Toppings> getToppings() {
		return toppings;
	}
	public void setToppings(List<Toppings> toppings) {
		this.toppings = toppings;
	}
	public PizzaMO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}

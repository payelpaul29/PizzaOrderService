package com.test.sw.PizzaOrder.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Component
public class Customer {
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	private int cust_id;

	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", name=" + name + ", address=" + address + ", phnumber=" + phnumber
				+ ", cardinfo=" + "]";
	}

	public int getCust_id() {
		return cust_id;
	}

	public Customer() {

	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getName() {
		return name;
	}

	public Customer(int cust_id, String name, String address, String phnumber, List<String> cardinfo) {
		super();
		this.cust_id = cust_id;
		this.name = name;
		this.address = address;
		this.phnumber = phnumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhnumber() {
		return phnumber;
	}

	public void setPhnumber(String phnumber) {
		this.phnumber = phnumber;
	}

	
	private String name;
	private String address;
	private String phnumber;
	

}

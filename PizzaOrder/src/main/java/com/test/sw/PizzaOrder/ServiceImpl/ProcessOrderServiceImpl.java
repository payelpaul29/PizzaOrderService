package com.test.sw.PizzaOrder.ServiceImpl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.sw.PizzaOrder.Common.Constants;
import com.test.sw.PizzaOrder.Entity.Customer;
import com.test.sw.PizzaOrder.Entity.OrderDetails;
import com.test.sw.PizzaOrder.Entity.OrderStatus;
import com.test.sw.PizzaOrder.Model.OrderMO;
import com.test.sw.PizzaOrder.Repository.CustomerRepository;
import com.test.sw.PizzaOrder.Repository.OrderRepository;
import com.test.sw.PizzaOrder.Repository.OrderStatusRepository;
import com.test.sw.PizzaOrder.Repository.PizzaRepository;
import com.test.sw.PizzaOrder.Repository.ToppingsRepository;
import com.test.sw.PizzaOrder.Service.ProcessOrderService;

@Service
public class ProcessOrderServiceImpl implements ProcessOrderService {


	@Autowired
	private PizzaRepository pizzRep;
	@Autowired
	private ToppingsRepository topRep;
	@Autowired
	private CustomerRepository custRep;
	@Autowired
	private Customer customer;
	@Autowired
	private OrderDetails orderDet;
	@Autowired
	private OrderStatus orderStatus;
	@Autowired
	private OrderRepository orderRep;
	@Autowired
	private OrderStatusRepository orderStatRep;

	private int orderId;

	@Override
	public OrderStatus placeOrder(OrderMO orderMo) {

		customer = new Customer();
		Integer customerId = saveCustomerDetails(orderMo.getCustomer());
		orderMo.getCustomer().setCust_id(customerId);
		orderStatus.setOrderId(0);
		orderStatus.setStatus(Constants.ORDER_STATUS_NEW);
		orderStatus = processOrderDetails(orderMo, orderStatus);

		return orderStatus;
	}

	public OrderStatus processOrderDetails(OrderMO orderMo, OrderStatus orderStatus) {
		orderId = orderStatus.getOrderId();
		orderMo.getPizzaList().forEach(pizza -> {
			Integer pizzaId = pizzRep.findByStyleNSize(pizza.getStyle(), pizza.getSize());
			pizza.getToppings().forEach(topping -> {
				Integer toppingId = topRep.findByToppingName(topping.getTopping_name());
				orderRep.flush();
				orderDet = new OrderDetails();
				if (orderId == 0) {
					Random rnd = new Random();
					int number = rnd.nextInt(999999);
					orderDet.setOrder_id(number);
				} else {
					orderDet.setOrder_id(orderId);
				}
				orderId = saveOrderDetails(orderMo.getCustomer().getCust_id(), toppingId, pizzaId);

			});

			orderStatus.setOrderId(orderId);
			saveOrderStatus();

		}

		);

		return orderStatus;
	}

	public Integer saveOrderDetails(Integer customerId, Integer toppingId, Integer pizzaId) {

		orderDet.setCust_id(customerId);
		orderDet.setPizza_id(pizzaId);
		orderDet.setTopping_id(toppingId);
		orderDet = orderRep.save(orderDet);
		return orderDet.getOrder_id();

	}

	public void saveOrderStatus() {

		orderStatRep.save(this.orderStatus);

	}

	public Integer saveCustomerDetails(Customer cust) {
		customer.setAddress(cust.getAddress());
		customer.setName(cust.getName());
		customer.setPhnumber(cust.getPhnumber());
		custRep.save(customer);
		return customer.getCust_id();

	}

	@Override
	public OrderStatus updateOrder(OrderMO orderMo, Integer orderId) {

		if (orderStatRep.getOne(orderId) != null) {
			orderDet = new OrderDetails();
			orderDet.setCust_id(orderMo.getCustomer().getCust_id());
			orderDet.setOrder_id(orderId);
			orderRep.DeleteByOrderId(orderId);
			orderStatus.setOrderId(orderId);
			orderStatus.setStatus(Constants.ORDER_STATUS_UDPATED);

			orderStatus = processOrderDetails(orderMo, orderStatus);
			return orderStatus;
		} else
			return null;

	}

	@Override
	public OrderStatus cancelOrder(Integer orderId) {

		orderStatus.setOrderId(orderId);
		orderStatus.setStatus(Constants.ORDER_STATUS_CANCELLED);

		if (orderStatRep.getOne(orderId) != null) {
			saveOrderStatus();
			return orderStatus;
		} else
			return null;

	}

}

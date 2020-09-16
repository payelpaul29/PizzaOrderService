package com.test.sw.PizzaOrder.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.sw.PizzaOrder.Entity.OrderStatus;
import com.test.sw.PizzaOrder.Model.CreditCardInfo;
import com.test.sw.PizzaOrder.Model.OrderMO;
import com.test.sw.PizzaOrder.Model.ResponseMO;
import com.test.sw.PizzaOrder.Service.ProcessOrderService;

@RestController
@RequestMapping(value = "/pizzaOrder")
public class PizzaOrderController {

	@Autowired
	private ProcessOrderService processOrderServiceImpl;
	@Autowired
	private ResponseMO responseMo;

	@PostMapping("/placeOrder")
	public ResponseEntity<Object> placeOrder(@Valid @RequestBody OrderMO orderMo) {

		OrderStatus orderStatus = processOrderServiceImpl.placeOrder(orderMo);

		responseMo.setMessage("Your order is successfull. Order details are below:");
		responseMo.setOrderStatus(orderStatus);
		return new ResponseEntity<>(responseMo, HttpStatus.OK);
	}

	@PostMapping("/changeOrder/{orderId}")
	public ResponseEntity<Object> changeOrder(@Valid @RequestBody OrderMO orderMo, @PathVariable Integer orderId) {

		OrderStatus orderStatus = processOrderServiceImpl.updateOrder(orderMo, orderId);

		responseMo.setMessage("Your order is successfully updated. Order details are below:");
		responseMo.setOrderStatus(orderStatus);
		return new ResponseEntity<>(responseMo, HttpStatus.OK);

	}

	@PostMapping("/cancelOrder/{orderId}")
	public ResponseEntity<Object> cancelOrder(@PathVariable Integer orderId) {

		OrderStatus orderStatus = processOrderServiceImpl.cancelOrder(orderId);

		responseMo.setMessage("Sorry to see you go. Please visit next time!!!");
		responseMo.setOrderStatus(orderStatus);
		return new ResponseEntity<>(responseMo, HttpStatus.OK);
	}
	
	@PostMapping("/checkOut/{orderId}")
	public ResponseEntity<Object> checkOut(@PathVariable Integer orderId,@Valid @RequestBody CreditCardInfo cardInfo) {

		responseMo.setMessage("Payement Successfull.");
		return new ResponseEntity<>(responseMo, HttpStatus.OK);
	}

}

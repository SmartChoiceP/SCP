package com.smartchoice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.smartchoice.model.OrderList;
import com.smartchoice.service.Service;

@RestController
@RequestMapping(value="/order")
public class OrderListController {
	
	
	@Autowired
	Service ser;
	
	/*1.create OrderList and insert*/
		@PostMapping(value="/create",headers="Accept=application/json")
		public ResponseEntity<OrderList> createOrder(@RequestBody OrderList o){
			ser.createOrder(o);
			HttpHeaders headers=new HttpHeaders();
			return new ResponseEntity<>(headers,HttpStatus.ACCEPTED);	
		}
	
	
	/*2.select all from OrderList*/
		@RequestMapping(value="/get")
		public List<OrderList> getAllOrders() {
			List<OrderList> olist=ser.getAllOrders();
			return olist;
			
		}
		
	/*3.select by id from OrderList*/
		
		@GetMapping(value="/get/{o_id}")
		public ResponseEntity<OrderList> getOrderById(@PathVariable(value="o_id") int id){
			System.out.println("########  select Order by Id  ##########");
		OrderList obyId=ser.selectOrderById(id);
		
		if(obyId==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			
			return new ResponseEntity<OrderList>(obyId,HttpStatus.ACCEPTED);
			
		}
			
		}
		
	/*4.delete a order from OrderList*/
		@DeleteMapping(value="/delete/{o_id}")
		public ResponseEntity<OrderList> deleteOrder(@PathVariable(value="o_id") int id){
			OrderList obyid=ser.selectOrderById(id);
			
			if(obyid==null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else {
				ser.deleteOrder(id);
				return new ResponseEntity<>(HttpStatus.OK);
				
			}
			
		}
		
/*	5.update order	*/
		@PutMapping(value="update")
		public ResponseEntity<OrderList> updateOrder(@RequestBody OrderList order){
			
			ser.updateOrder(order);
			return new ResponseEntity<OrderList>(HttpStatus.ACCEPTED);
			
			
		}
}

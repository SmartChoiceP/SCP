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

import com.smartchoice.model.Admin;
import com.smartchoice.model.Customer;
import com.smartchoice.service.Service;

@RestController
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	Service ser;

	/****************Create Customer Records*****************/
	@PostMapping(value="/create",headers="Accept=application/json")
	public ResponseEntity<Void> create(@RequestBody Customer c)
	{
		System.out.println("in admin create method");
		
		ser.createCustomer(c);
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		
	}
/**************************Get all customer data******************************/
	 @GetMapping(value="/get",  headers="Accept=application/json")
	 public List<Customer> selectAllCustomer(){
		System.out.println("Select all Customer_table");
		List<Customer> clist=ser.selectAllCustomer();
		return clist;
		
	}

	 @GetMapping(value="get/{c_id}",headers="Accept=application/json")
	 public ResponseEntity<Customer> selectCustByID(@PathVariable("c_id")int id){
		 System.out.println("id"+id);
		 Customer cbyid=ser.selectCustomerbyId(id);
		 if(cbyid==null) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }else {
			 
		return new ResponseEntity<>(cbyid,HttpStatus.OK);
		 }
	 }
	
	 @DeleteMapping(value="delete/{c_id}",headers="Accept=application/json")
	 public ResponseEntity<Customer> deleteCustomer(@PathVariable("c_id")int id)
	 {
		 System.out.println("Id to delete"+id);
		 Customer cbyid=ser.selectCustomerbyId(id);
		 if(cbyid==null) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		 else {
			 ser.deleteCustomer(id);
			 return new ResponseEntity<Customer>(HttpStatus.ACCEPTED);        
		 }
	 }
	 
	 
@PutMapping(value="update",headers="Accept=application/json")
	 public ResponseEntity<Customer> updateCustomer(@RequestBody Customer c)
	 {
		System.out.println("#######################################");
		System.out.println("update_customerDetail ");

	
		ser.updateCustomer(c);
		return new ResponseEntity<Customer>(HttpStatus.ACCEPTED);
	}
		 
	 }
	 
	

	 





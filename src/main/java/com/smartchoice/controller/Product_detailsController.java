package com.smartchoice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartchoice.model.Product_details;
import com.smartchoice.service.Service;

@RestController
@RequestMapping(value="/product_details")
public class Product_detailsController {
	
	@Autowired
	Service ser;
	
	
	/*1.create product_details table and insert*/	
	@PostMapping(value="/create",headers="Accept=application/json")
	public ResponseEntity<Product_details> createProductD(@RequestBody Product_details pro){
		System.out.println("Priduct_detail..create");
		ser.createProductD(pro);
		HttpHeaders headers=new HttpHeaders();
		return new ResponseEntity<>(headers,HttpStatus.ACCEPTED);
	}
	
	/*2.select all products*/	
	@RequestMapping(value="/get")
	public List<Product_details> getProductDByid(){
		System.out.println("#############*******#############");
		List<Product_details> plist=ser.selectAllProductD();
		
		return plist;
		
		
		}

	/*3.select product by id*/	
	@RequestMapping(value="/get/{p_id}")
	public ResponseEntity getProductDByid(@PathVariable(value="p_id")int id){
		
		Product_details pbyid=ser.selectProduct_Detail_byId(id);
		if(pbyid==null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
			
		}
		else {
			return new ResponseEntity(pbyid,HttpStatus.OK);
		}
		
		
		
	}
	/*4.delete product*/	
	@DeleteMapping(value="/delete/{p_id}")
	public ResponseEntity deleteProductDByid(@PathVariable(value="p_id")int id){
		
		Product_details pbyid=ser.selectProduct_Detail_byId(id);
		if(pbyid==null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
			
		}
		else {
			ser.deleteProductDbyId(pbyid);
			return new ResponseEntity(HttpStatus.OK);
		}
		
		
		
	}
	/*5.update product*/	

	@PutMapping(value="/update")
	public ResponseEntity deleteProductDByid(@RequestBody Product_details p){
	
			ser.updateProductD(p);
			return new ResponseEntity(HttpStatus.OK);
		}
		

}

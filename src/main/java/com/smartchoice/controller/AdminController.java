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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartchoice.model.Admin;
import com.smartchoice.service.Service;

@RestController
@RequestMapping(value="/admin")

public class AdminController {
	
	@Autowired
	Service ser;
	
	/****************Create Admin Records*****************/
	@PostMapping(value="/create",headers="Accept=application/json")
	public ResponseEntity<Void> create(@RequestBody Admin a)
	{
		System.out.println("in admin create method");
		
		ser.createAdmin(a);
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		
	}
	

	/****************Select Admin Records*****************/
	
	 @GetMapping(value="/get",  headers="Accept=application/json")
	public List<Admin> getall()
	 {
		 
		 System.out.println("in admin selectAll method");
		 List<Admin> alist=ser.selectAll();
		return alist;
		 
	 }
	
		/****************Select Admin Records By Id*****************/
	 
	 @GetMapping(value="/{a_id}", headers="Accept=application/json")
	 public ResponseEntity<Admin> selectbyId(@PathVariable("a_id") int id)
	 {
		 System.out.println("getting id" +id);
		Admin ad=ser.selectbyId(id);
		if(ad == null)
		{
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Admin>(ad,HttpStatus.OK);
		 
	 }
	 
	 /****************Delete Admin Records*****************/
	 
	 @DeleteMapping(value="/delete/{a_id}", headers="Accept=application/json")
	 public ResponseEntity<Admin> deleteRecord(@PathVariable("a_id") int id)
	 {
		 
		 System.out.println("getting id" +id);
		 Admin ad=ser.selectbyId(id);
		 if(ad == null)
		 {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		 else 
		 {
			 ser.deleteAdmin(id);
		return new ResponseEntity<Admin>(HttpStatus.ACCEPTED);
		 }
		 
	 }
	 
	 
}

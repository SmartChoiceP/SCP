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

import com.smartchoice.model.Employee;
import com.smartchoice.service.Service;

@RestController
@RequestMapping(value="/employee")
//@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class EmployeeController {

	@Autowired
	Service ser;
	
	/***********************Create Employee Records************************/
	@PostMapping(value="/create",headers="Accept=application/json")
	public ResponseEntity<Void> create(@RequestBody Employee e)
	{
		System.out.println("----------in create employee method----------");
		
		ser.createEmp(e);
		
		HttpHeaders headers=new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	
	/***********************Select Employee Records************************/
	@GetMapping(value="/get",headers="Accept=application/json")
	public List<Employee> getall()
	{
		System.out.println("----------in getall  method----------");
		
		List<Employee> elist=ser.selectAllEmployee();
		
		return elist;
	}
	
	/***********************Select Employee Records By Id************************/
	@GetMapping(value="/get/{e_id}",headers="Accept=application/json")
	public ResponseEntity<Employee> selectById(@PathVariable("e_id")int id)
	{
		System.out.println("getting id" +id);
		Employee emp=ser.select_emp_byId(id);
		if(emp == null)
		{
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
	/***********************Delete Employee Records************************/
	@DeleteMapping(value="/delete/{e_id}",headers="Accept=application/json")
	public ResponseEntity<Employee> deleteById(@PathVariable ("e_id") int id)
	{
		Employee user=ser.select_emp_byId(id);
		if(user==null)
		{
			return new  ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		ser.deleteEmp(id);
		return new ResponseEntity<Employee>(HttpStatus.ACCEPTED);
	}
	
	/***********************Update Employee Records************************/
	@PutMapping(value="/update" , headers="Accept=application/json")
	public ResponseEntity<String> updateRecord(@RequestBody Employee e)
	 {
		
		 ser.updateEmp(e);
		return new ResponseEntity<String>(HttpStatus.OK);
		 
	 }
}

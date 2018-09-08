package com.smartchoice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Customer_Table")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int c_id;
	
	private String c_name;
	
	private String c_address;
	
	private String c_contact;
	
	private String c_email;
	
	private String c_uname;
	
	private String c_password;

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_address() {
		return c_address;
	}

	public void setC_address(String c_address) {
		this.c_address = c_address;
	}


	public String getC_email() {
		return c_email;
	}

	public String getC_contact() {
		return c_contact;
	}

	public void setC_contact(String c_contact) {
		this.c_contact = c_contact;
	}

	public void setC_email(String c_email) {
		this.c_email = c_email;
	}

	public String getC_uname() {
		return c_uname;
	}

	public void setC_uname(String c_uname) {
		this.c_uname = c_uname;
	}

	public String getC_password() {
		return c_password;
	}

	public void setC_password(String c_password) {
		this.c_password = c_password;
	}



}

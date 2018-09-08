package com.smartchoice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin_info")
public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int a_id;
	
	private String a_name;
	
	private String a_address;
	
	private String a_contact;
	
	private String a_email;
	
	private String a_uname;
	
	private String a_password;

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public String getA_name() {
		return a_name;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}

	public String getA_address() {
		return a_address;
	}

	public void setA_address(String a_address) {
		this.a_address = a_address;
	}

	public String getA_contact() {
		return a_contact;
	}

	public void setA_contact(String a_contact) {
		this.a_contact = a_contact;
	}

	public String getA_email() {
		return a_email;
	}

	public void setA_email(String a_email) {
		this.a_email = a_email;
	}

	public String getA_uname() {
		return a_uname;
	}

	public void setA_uname(String a_uname) {
		this.a_uname = a_uname;
	}

	public String getA_password() {
		return a_password;
	}

	public void setA_password(String a_password) {
		this.a_password = a_password;
	}
	
	
}

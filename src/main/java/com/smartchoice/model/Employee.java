package com.smartchoice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_info")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int e_id;
	
	private String e_name;
	
	private String e_address;
	
	private String e_contact;
	
	private String e_email;
	
	private String e_desig;
	
	private String e_uname;
	
	private String e_password;

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public String getE_address() {
		return e_address;
	}

	public void setE_address(String e_address) {
		this.e_address = e_address;
	}

	public String getE_contact() {
		return e_contact;
	}

	public void setE_contact(String e_contact) {
		this.e_contact = e_contact;
	}

	public String getE_email() {
		return e_email;
	}

	public void setE_email(String e_email) {
		this.e_email = e_email;
	}

	public String getE_desig() {
		return e_desig;
	}

	public void setE_desig(String e_desig) {
		this.e_desig = e_desig;
	}

	public String getE_uname() {
		return e_uname;
	}

	public void setE_uname(String e_uname) {
		this.e_uname = e_uname;
	}

	public String getE_password() {
		return e_password;
	}

	public void setE_password(String e_password) {
		this.e_password = e_password;
	}

}

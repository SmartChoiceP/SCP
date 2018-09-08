package com.smartchoice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="product_details")
public class Product_details {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int p_id;
	String p_name;
	int p_quantity;
	float p_price;
	float p_amount;
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_quantity() {
		return p_quantity;
	}
	public void setP_quantity(int p_quantity) {
		this.p_quantity = p_quantity;
	}
	public float getP_price() {
		return p_price;
	}
	public void setP_price(float p_price) {
		this.p_price = p_price;
	}
	public float getP_amount() {
		return p_amount;
	}
	public void setP_amount(float p_amount) {
		this.p_amount = p_amount;
	}
	
	
	 
	
}

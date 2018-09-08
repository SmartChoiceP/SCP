package com.smartchoice.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loginmaster")
public class Lmaster {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int lid;
	
	private String luname;
	
	private String lpass;
	
	private String type;

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLuname() {
		return luname;
	}

	public void setLuname(String luname) {
		this.luname = luname;
	}

	public String getLpass() {
		return lpass;
	}

	public void setLpass(String lpass) {
		this.lpass = lpass;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}

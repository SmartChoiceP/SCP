package com.smartchoice.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product_FILES_UPLOAD")
public class UploadFile {

	@Id
	@GeneratedValue
	private long id;
	private String fileName;
//	private float price;
	private byte[] data;
//private Blob data;
	@Column(name = "FILE_ID")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "FILE_NAME")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/*@Column(name = "FILE_DATA")
	public Blob getData() {
		return data;
	}*/
@Column(name = "FILE_DATA", columnDefinition="LONGBLOB")
	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

/*	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
*/
	

/*	public void setData(Blob data) {
		this.data = data;
	}
*/
}

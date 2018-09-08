package com.smartchoice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smartchoice.dao.Dao;
import com.smartchoice.model.Admin;
import com.smartchoice.model.Customer;
import com.smartchoice.model.Employee;
import com.smartchoice.model.OrderList;
import com.smartchoice.model.Product_details;
import com.smartchoice.model.UploadFile;

@Component
public class ServiceImpl implements Service{
	

	@Autowired
	Dao d;
	
	@Override
	public void createAdmin(Admin ad) {
		
		d.createAdmin(ad);
		
	}

	@Override
	public List<Admin> selectAll() {
		return d.selectAll();
	}

	@Override
	public Admin selectbyId(int id) {

		return d.selectbyId(id);
	}

	@Override
	public void deleteAdmin(int id) {

		d.deleteAdmin(id);
	}

	@Override
	public void createCustomer(Customer c) {
		// TODO Auto-generated method stub
		d.createCustomer(c);
		
	}

	@Override
	public List<Customer> selectAllCustomer() {
		return	d. selectAllCustomer();
	
	}

	@Override
	public Customer selectCustomerbyId(int id) {
		
		return d.selectCustomerbyId(id);
	}

	@Override
	public void deleteCustomer(int id) {
		d.deleteCustomer(id);
		
	}

	@Override
	public void updateCustomer(Customer c) {
		d.updateCustomer(c);
	}
		/*######## Order ###########*/	
	
	@Override
	public void createOrder(OrderList o) {
		d.createOrder(o);
		
	}

	@Override
	public List<OrderList> getAllOrders() {
		
		return d.getAllOrders();
	}

	@Override
	public OrderList selectOrderById(int id) {
		return d.selectOrderById(id);
	}

	@Override
	public void deleteOrder(int id) {
		
		d.deleteOrder(id);
		
	}

	@Override
	public void updateOrder(OrderList order) {
		d.updateOrder(order);
		
	}

	@Override
	public void createProductD(Product_details pro) {
		d.createProductD(pro);
		
	}

	@Override
	public Product_details selectProduct_Detail_byId(int id) {
	return	d.selectProduct_Detail_byId(id);
		
	}

	@Override
	public List<Product_details> selectAllProductD() {
		
		return d.selectAllProductD();
	}

	@Override
	public void deleteProductDbyId(Product_details pbyid) {
		d.deleteProductDbyId(pbyid);
		
	}

	@Override
	public void updateProductD(Product_details p) {
		d.updateProductD(p);
		
	}

	@Override
	public void save(UploadFile uploadFile) {
		d.save(uploadFile);

		
	}

	@Override
	public void remove(long documentId) {
		d.remove(documentId);
		
	}

	@Override
	public List<UploadFile> getAllFileUpload() {
		// TODO Auto-generated method stub
		return d.getAllFileUpload();
	}

	@Override
	public UploadFile getfile(UploadFile f) {
		// TODO Auto-generated method stub
		return d.getfile(f);
	}

	@Override
	public void createProduct(UploadFile upProduct) {
		d.createProduct(upProduct);
		
	}
	
	/**********************************Employee Model Methods*************************************/
	@Override
	public void createEmp(Employee e) {

		d.createEmp(e);
	}

	@Override
	public List<Employee> selectAllEmployee() {

		return d.selectAllEmployee();
	}

	@Override
	public Employee select_emp_byId(int id) {

		return d.select_emp_byId(id);
	}

	@Override
	public void deleteEmp(int id) {

		d.deleteEmp(id);
	}

	@Override
	public void updateEmp(Employee e) {

		d.updateEmp(e);
	}


}
